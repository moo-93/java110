import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import bitcamp.java110.cms.control.Controller;
import bitcamp.java110.cms.control.ManagerController;
import bitcamp.java110.cms.control.StudentController;
import bitcamp.java110.cms.control.TeacherController;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.domain.Teacher;

public class App {
    //여러 속성의 값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용한다.

    static Scanner KeyIn = new Scanner(System.in);

    public static void main(String[] args) {

        HashMap<String,Controller> requestHandlerMapping = new HashMap<>();

        requestHandlerMapping.put("1", new StudentController(new LinkedList<Student>()));    
        requestHandlerMapping.put("2", new TeacherController(new ArrayList<Teacher>()));
        requestHandlerMapping.put("3", new ManagerController(new ArrayList<Manager>()));

        while(true) {
            String menu = promptMenu();
            
            if (menu.equals("0")){
                System.out.println("사용해주셔서 감사합니다!");
                break;
            }
            
            Controller controller = requestHandlerMapping.get(menu);

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

        while(true) {
            System.out.print("input menu > ");

            String menu = KeyIn.nextLine();
            switch(menu) {
            case "1":
            case "2":
            case "3":
            case "0":
                return menu;
            default:
                System.out.println("메뉴 번호가 유효하지 않습니다.");
            }
        }
    }


}