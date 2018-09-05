package bitcamp.java110.cms.control;

import java.util.Scanner;
import bitcamp.java110.cms.domain.Member;

public class ManagerController {
    static Manager[] managers = new Manager[100];
    static int managerIndex = 0;
    public static Scanner KeyIn;
    
    static class Manager extends Member{   
        protected String tel;
        protected String position;
        
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public String getPosition() {
            return position;
        }
        public void setPosition(String position) {
            this.position = position;
        }
    }
    
    public static void serviceManagerMenu() {
        while(true) {
            System.out.println("[list] or [add] or [quit]");
            System.out.print("매니져 관리 > ");

            String command = KeyIn.nextLine();

            if (command.equals("list")) {    
                printManagers();
            } else if(command.equals("add")) {
                inputManagers();
            } else if(command.equals("quit")) {
                break;
            } else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    
    private static void printManagers() {
        int cnt = 0;
        for(Manager m : managers) {
            if(cnt++ == managerIndex) break;
            System.out.printf("%s, %s, %s, %s, %s\n"
                    ,m.getName()
                    ,m.getEmail()
                    ,m.getPassword()
                    ,m.getTel()
                    ,m.getPosition());
        }
    }
    
    private static void inputManagers() {
        while(true) {
            //inner class 가져올때 외부 객체를 만들어준 후 내부객체를 가지고 옴다.
            /*App a = new App();
            App.Member m = a.new Member();*/

            //static nested inner class
            //App.Member m = new App.Member();
            Manager m = new Manager();

            System.out.print("이름 : ");
            m.setName(KeyIn.nextLine());

            System.out.print("이메일 : ");
            m.setEmail(KeyIn.nextLine());

            System.out.print("암호 : ");
            m.setPassword(KeyIn.nextLine());

            System.out.print("전화번호 : ");
            m.setTel(KeyIn.nextLine());
            
            System.out.print("포지션 : ");
            m.setPosition(KeyIn.nextLine());
            managers[managerIndex++] = m;

            System.out.print("continue? (Y/n) ");
            String answer = KeyIn.nextLine();
            if(answer.toLowerCase().equals("n")) break;
        }
    }
}
