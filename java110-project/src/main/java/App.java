import java.util.Scanner;

import bitcamp.java110.cms.context.ApplicationContext;
import bitcamp.java110.cms.control.Controller;

public class App {
    //여러 속성의 값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용한다.

    static Scanner KeyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        ApplicationContext iocContainer = 
                new ApplicationContext("bitcamp.java110.cms.control");

        while(true) {
            String menu = promptMenu();

            if (menu.equals("0")){
                System.out.println("사용해주셔서 감사합니다!");
                break;
            }

            Controller controller = (Controller)iocContainer.getBean(menu);

            if(controller != null) {
                controller.service(KeyIn);
            } else {
                System.out.println("해당 메뉴가 존재하지 않습니다.");
            }
        }
        KeyIn.close();
    }

    private static String promptMenu() {
        System.out.println("[메뉴]");
        System.out.println("1.학생관리\t 2.강사관리\t 3.매니저관리\t 0.종료");
        System.out.print("input menu > ");

        String menu = KeyIn.nextLine();
        
        return menu;

    }
}