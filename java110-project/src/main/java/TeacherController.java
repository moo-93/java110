import java.util.Scanner;

public class TeacherController {
    static Teacher[] teachers = new Teacher[100];
    static int teacherIndex = 0;
    static Scanner KeyIn;
    
    static class Teacher extends Member{
        protected String tel;
        protected int pay;
        protected String subjects;

        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public int getPay() {
            return pay;
        }
        public void setPay(int pay) {
            this.pay = pay;
        }
        public String getSubjects() {
            return subjects;
        }
        public void setSubjects(String subjects) {
            this.subjects = subjects;
        }
    }
    
    static void serviceTeacherMenu() {
        while(true) {
            System.out.println("[list] or [add] or [quit]");
            System.out.print("강사 관리 > ");

            String command = KeyIn.nextLine();

            if (command.equals("list")) {    
                printTeachers();
            } else if(command.equals("add")) {
                inputTeachers();
            } else if(command.equals("quit")) {
                break;
            } else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    
    static void printTeachers() {
        int cnt = 0;
        for(Teacher t : teachers) {
            if(cnt++ == teacherIndex) break;
            System.out.printf("%s, %s, %s, %s, %b, %s\n"
                    ,t.getName()
                    ,t.getEmail()
                    ,t.getPassword()
                    ,t.getTel()
                    ,t.getPay()
                    ,t.getSubjects());
        }
    }
    
    static void inputTeachers() {
        while(true) {
            //inner class 가져올때 외부 객체를 만들어준 후 내부객체를 가지고 옴다.
            /*App a = new App();
            App.Member m = a.new Member();*/

            //static nested inner class
            //App.Member m = new App.Member();
            Teacher t = new Teacher();

            System.out.print("이름 : ");
            t.setName(KeyIn.nextLine());

            System.out.print("이메일 : ");
            t.setEmail(KeyIn.nextLine());

            System.out.print("암호 : ");
            t.setPassword(KeyIn.nextLine());
            
            System.out.print("전화번호  : ");
            t.setTel(KeyIn.nextLine());
            
            System.out.print("시급 : ");
            t.setPay(Integer.parseInt(KeyIn.nextLine()));
            
            System.out.print("강의과목 : ");
            t.setSubjects(KeyIn.nextLine());
            teachers[teacherIndex++] = t;

            System.out.print("continue? (Y/n) ");
            String answer = KeyIn.nextLine();
            if(answer.toLowerCase().equals("n")) break;
        }
    }
}
