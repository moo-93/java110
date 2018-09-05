import java.util.Scanner;

public class App {
    //여러 속성의 값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용한다.
    static class Member{
        protected String name;
        protected String email;
        protected String password;
        //인스턴스의 메모리를 다루는 operator = setter/gatter = accessor = property =message
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    }
    
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
    
    static Student[] students = new Student[100];

    static int index = 0;

    static Scanner KeyIn = new Scanner(System.in);

    public static void main(String[] args) {

        while(true) {
            String menu = promptMenu();

            if(menu.equals("1")) {
                serviceStudentMenu();
            } else if (menu.equals("0")){
                System.out.println("사용해주셔서 감사합니다!");
                break;
            }
        }
        KeyIn.close();
    }

    private static void serviceStudentMenu() {
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

    static void printStudents() {
        int cnt = 0;
        for(Student s : students) {
            if(cnt++ == index) break;
            System.out.printf("%s, %s, %s, %s, %b, %s\n"
                    ,s.getName()
                    ,s.getEmail()
                    ,s.getPassword()
                    ,s.getSchool()
                    ,s.isWorking()
                    ,s.getTel());
        }
    }
    //merge test
    static void inputStudents() {
        while(true) {
            //inner class 가져올때 외부 객체를 만들어준 후 내부객체를 가지고 옴다.
            /*App a = new App();
            App.Member m = a.new Member();*/

            //static nested inner class
            //App.Member m = new App.Member();
            Student m = new Student();

            System.out.print("이름 : ");
            m.setName(KeyIn.nextLine());

            System.out.print("이메일 : ");
            m.setEmail(KeyIn.nextLine());

            System.out.print("암호 : ");
            m.setPassword(KeyIn.nextLine());
            
            System.out.println("최종학력  : ");
            m.setSchool(KeyIn.nextLine());
            
            System.out.println("재직여부 : (true/false)");
            m.setWorking(Boolean.parseBoolean(KeyIn.nextLine()));
            
            System.out.println("전화번호 : ");
            m.setTel(KeyIn.nextLine());
            students[index++] = m;

            System.out.println("continue? (Y/n) ");
            String answer = KeyIn.nextLine();
            if(answer.toLowerCase().equals("n")) break;
        }
    }
}