package bitcamp.java110.cms.control;

import java.util.Scanner;

import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.util.ArrayList;

public class StudentController {

    private ArrayList<Student> students = new ArrayList<>();
    public Scanner KeyIn;
    
    public StudentController(Scanner KeyIn) {
        this.KeyIn=KeyIn;
    }
    
    public void serviceStudentMenu() {
        while(true) {
            System.out.println("[list] or [add] or [delete]"
                    + " or [detail] or [quit] ");
            System.out.print("학생 관리 > ");

            String command = KeyIn.nextLine();

            if (command.equals("list")) {    
                printStudents();
            } else if(command.equals("add")) {
                inputStudents();
            } else if(command.equals("delete")) {
                deleteStudent();
            } else if(command.equals("detail")) {
                detailStudent();
            } else if(command.equals("quit")) {
                break;
            } else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }

    private void printStudents() {
        for(int i= 0; i< students.size(); i++) {
            Student s = students.get(i);
            System.out.printf("%d : %s, %s, %s, %s, %b, %s\n"
                    ,i
                    ,s.getName()
                    ,s.getEmail()
                    ,s.getPassword()
                    ,s.getSchool()
                    ,s.isWorking()
                    ,s.getTel());
        }
    }

    private void inputStudents() {
        while(true) {

            Student s = new Student();

            System.out.print("이름 : ");
            s.setName(KeyIn.nextLine());

            System.out.print("이메일 : ");
            s.setEmail(KeyIn.nextLine());

            System.out.print("암호 : ");
            s.setPassword(KeyIn.nextLine());

            System.out.print("최종학력  : ");
            s.setSchool(KeyIn.nextLine());

            System.out.print("재직여부 : (true/false)");
            s.setWorking(Boolean.parseBoolean(KeyIn.nextLine()));

            System.out.print("전화번호 : ");
            s.setTel(KeyIn.nextLine());

            students.add(s);

            System.out.print("continue? (Y/n) ");
            String answer = KeyIn.nextLine();
            if(answer.toLowerCase().equals("n")) break;
        }
    }

    private void deleteStudent() {
        System.out.print("삭제할 번호 : ");
        int num = Integer.parseInt(KeyIn.nextLine());

        if(num < 0 || num >= students.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        students.remove(num);
        System.out.println("삭제 완료");
    }

    private void detailStudent() {
        System.out.print("조회할 번호 : ");
        int num = Integer.parseInt(KeyIn.nextLine());

        if(num < 0 || num >= students.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        Student student = students.get(num);

        System.out.printf("이름 : %s\n", student.getName());
        System.out.printf("이메일 : %s\n", student.getEmail());
        System.out.printf("암호 : %s\n", student.getPassword());
        System.out.printf("최종학력 : %s\n", student.getSchool());
        System.out.printf("전화 : %s\n", student.getTel());
        System.out.printf("재직여부 : %b\n", student.isWorking());
    }

     { //인스턴스 블록
        Student s = new Student();
        s.setName("a");
        students.add(s);
        s = new Student();
        s.setName("b");
        students.add(s);
        s = new Student();
        s.setName("c");
        students.add(s);
        s = new Student();
        s.setName("d");
        students.add(s);
        s = new Student();
        s.setName("e");
        students.add(s);
    }
}
