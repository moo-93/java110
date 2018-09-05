package bitcamp.java110.cms.control;

import java.util.Scanner;
import bitcamp.java110.cms.domain.Member;


public class StudentController {
    static Student[] students = new Student[100];
    static int studentIndex = 0;
    public static Scanner KeyIn;

    static class Student extends Member{
        protected String school;
        protected boolean working;
        protected String tel;

        public String getSchool() {
            return school;
        }
        public void setSchool(String school) {
            this.school = school;
        }
        public boolean isWorking() {
            return working;
        }
        public void setWorking(boolean working) {
            this.working = working;
        }
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }   
    }

    public static void serviceStudentMenu() {
        while(true) {
            System.out.println("[list] or [add] or [quit]");
            System.out.print("학생 관리 > ");

            String command = KeyIn.nextLine();

            if (command.equals("list")) {    
                printStudents();
            } else if(command.equals("add")) {
                inputStudents();
            } else if(command.equals("quit")) {
                break;
            } else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }

    private static void printStudents() {
        int cnt = 0;
        for(Student s : students) {
            if(cnt++ == studentIndex) break;
            System.out.printf("%s, %s, %s, %s, %b, %s\n"
                    ,s.getName()
                    ,s.getEmail()
                    ,s.getPassword()
                    ,s.getSchool()
                    ,s.isWorking()
                    ,s.getTel());
        }
    }

    private static void inputStudents() {
        while(true) {
            //inner class 가져올때 외부 객체를 만들어준 후 내부객체를 가지고 옴다.
            /*App a = new App();
            App.Member m = a.new Member();*/

            //static nested inner class
            //App.Member m = new App.Member();
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
            students[studentIndex++] = s;

            System.out.print("continue? (Y/n) ");
            String answer = KeyIn.nextLine();
            if(answer.toLowerCase().equals("n")) break;
        }
    }
}
