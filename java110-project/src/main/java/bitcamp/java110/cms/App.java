package bitcamp.java110.cms;
import java.util.ArrayList;
import java.util.Scanner;

import bitcamp.java110.cms.context.ApplicationContext;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;
import bitcamp.java110.cms.domain.Student;

public class App {
    //여러 속성의 값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용한다.

    public static ArrayList<Student> students = new ArrayList<>();
    static Scanner KeyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        ApplicationContext iocContainer = 
                new ApplicationContext("bitcamp.java110.cms.control");
        
        RequestMappingHandlerMapping requestHandlerMap = 
                new RequestMappingHandlerMapping();
        
        // => IoC 컨테이너에 보관된 객체의 이름 목록을 가져온다.
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names) {
            // => 이름으로 객체를 꺼낸다.
            Object obj = iocContainer.getBean(name);
            
            // => 객체에서 @RequestMapping이 붙은 메서드를 찾아 지정한다.
            requestHandlerMap.addMapping(obj);
        }
        
        while(true) {
            String menu = prompt();

            if (menu.equals("exit")){
                System.out.println("사용해주셔서 감사합니다!");
                break;
            }

            RequestMappingHandler mapping = requestHandlerMap.getMapping(menu);

            if(mapping == null) {
                System.out.println("해당 메뉴가 존재하지 않습니다.");
                continue;
            }
   
            mapping.getMethod().invoke(mapping.getInstance(), KeyIn);
        }
        KeyIn.close();
    }

    private static String prompt() {
        System.out.print("menu > ");
        return KeyIn.nextLine();

    }
}