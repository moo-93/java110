package bitcamp.java110.cms.control;

import java.util.Scanner;
import bitcamp.java110.cms.domain.Member;


public class StudentController {
    static Student[] students = new Student[5];
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

    private static void printStudents() {
        int cnt = 0;
        for(Student s : students) {
            if(cnt++ == studentIndex) break;
            System.out.printf("%d : %s, %s, %s, %s, %b, %s\n"
                    ,cnt-1
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

            if(studentIndex == students.length) {
                increaseStorage();
            }

            students[studentIndex++] = s;

            System.out.print("continue? (Y/n) ");
            String answer = KeyIn.nextLine();
            if(answer.toLowerCase().equals("n")) break;
        }
    }

    private static void increaseStorage() {
        Student[] newList = new Student[students.length+3];
        for(int i = 0; i< students.length; i++) {
            newList[i] = students[i];
        }
        students = newList;
    }

    private static void deleteStudent() {
        System.out.print("삭제할 번호 : ");
        int num = Integer.parseInt(KeyIn.nextLine());
        
        if(num < 0 || num > studentIndex) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        for(int i = num; i < studentIndex - 1; i++) {
            students[i] = students[i+1];
        }
        studentIndex--;

        System.out.println("삭제 완료");
    }

    private static void detailStudent() {
        System.out.print("조회할 번호 : ");
        int num = Integer.parseInt(KeyIn.nextLine());

        if(num < 0 || num > studentIndex) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        System.out.printf("이름 : %s\n", students[num].getName());
        System.out.printf("이메일 : %s\n", students[num].getEmail());
        System.out.printf("암호 : %s\n", students[num].getPassword());
        System.out.printf("최종학력 : %s\n", students[num].getSchool());
        System.out.printf("전화 : %s\n", students[num].getTel());
        System.out.printf("재직여부 : %b\n", students[num].isWorking());
    }

    /*static {
        Student s = new Student();
        s.setName("a");
        students[studentIndex++]=s;
        s = new Student();
        s.setName("b");
        students[studentIndex++]=s;
        s = new Student();
        s.setName("c");
        students[studentIndex++]=s;
        s = new Student();
        s.setName("d");
        students[studentIndex++]=s;
        s = new Student();
        s.setName("e");
        students[studentIndex++]=s;
    }*/
}
