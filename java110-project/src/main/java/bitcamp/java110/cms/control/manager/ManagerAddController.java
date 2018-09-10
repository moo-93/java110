package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerAddController {


    @RequestMapping("manager/add")
    public void add(Scanner KeyIn) {
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

            App.managers.add(m);

            System.out.print("continue? (Y/n) ");
            String answer = KeyIn.nextLine();
            if(answer.toLowerCase().equals("n")) break;
        }
    }

}
