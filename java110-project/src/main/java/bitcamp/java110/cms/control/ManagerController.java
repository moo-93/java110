package bitcamp.java110.cms.control;

import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Manager;

public class ManagerController implements Controller{
   
    private List<Manager> managers;
   
    public ManagerController(List<Manager> managers) {
        this.managers = managers;
    }
    
    public void service(Scanner KeyIn) {
        while(true) {
            System.out.println("[list] or [add] or [delete]"
                    + " or [detail] or [quit] ");
            System.out.print("매니져 관리 > ");

            String command = KeyIn.nextLine();

            if (command.equals("list")) {    
                printManagers();
            } else if(command.equals("add")) {
                inputManagers(KeyIn);
            } else if(command.equals("delete")) {
                deleteManager(KeyIn);
            } else if(command.equals("detail")) {
                detailManager(KeyIn);
            } else if(command.equals("quit")) {
                break;
            } else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    
    private void printManagers() {
        for(int i = 0; i < managers.size(); i++) {
            Manager m = managers.get(i);
            System.out.printf("%d : %s, %s, %s, %s, %s\n"
                    ,i
                    ,m.getName()
                    ,m.getEmail()
                    ,m.getPassword()
                    ,m.getTel()
                    ,m.getPosition());
        }
    }
    
    private void inputManagers(Scanner KeyIn) {
        while(true) {
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
            
            managers.add(m);

            System.out.print("continue? (Y/n) ");
            String answer = KeyIn.nextLine();
            if(answer.toLowerCase().equals("n")) break;
        }
    }
    
    

    private void deleteManager(Scanner KeyIn) {
        System.out.print("삭제할 번호 : ");
        int num = Integer.parseInt(KeyIn.nextLine());
        
        if(num < 0 || num >= managers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        managers.remove(num);
        System.out.println("삭제 완료");
    }

    private void detailManager(Scanner KeyIn) {
        System.out.print("조회할 번호 : ");
        int num = Integer.parseInt(KeyIn.nextLine());

        if(num < 0 || num >= managers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        Manager m = managers.get(num);

        System.out.printf("이름 : %s\n", m.getName());
        System.out.printf("이메일 : %s\n", m.getEmail());
        System.out.printf("암호 : %s\n", m.getPassword());
        System.out.printf("전화 : %s\n", m.getTel());
        System.out.printf("강의과목 : %s\n", m.getPosition());
    }
}
