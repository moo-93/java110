import java.util.Scanner;

import bitcamp.java110.cms.control.ManagerController;
import bitcamp.java110.cms.control.StudentController;
import bitcamp.java110.cms.control.TeacherController;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.util.ArrayList;
import bitcamp.java110.cms.util.LinkedList;

public class App {
    //여러 속성의 값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용한다.

    static Scanner KeyIn = new Scanner(System.in);

    public static void main(String[] args) {

        StudentController sc = new StudentController(
                KeyIn, new LinkedList<Student>());    
        TeacherController tc = new TeacherController(
                KeyIn, new ArrayList<Teacher>());
        ManagerController mc = new ManagerController(
                KeyIn, new ArrayList<Manager>());

        while(true) {
            String menu = promptMenu();
            
            if(menu.equals("1")) {
                sc.serviceStudentMenu();
            } else if (menu.equals("2")) {
                tc.serviceTeacherMenu();  
            } else if (menu.equals("3")) {
                mc.serviceManagerMenu();
            } else if (menu.equals("0")){
                System.out.println("사용해주셔서 감사합니다!");
                break;
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