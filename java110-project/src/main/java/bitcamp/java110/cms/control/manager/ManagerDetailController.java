package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerDetailController {
    
    @RequestMapping("manager/detail")
    public void detail(Scanner KeyIn) {
        System.out.print("조회할 번호 : ");
        int num = Integer.parseInt(KeyIn.nextLine());

        if(num < 0 || num >= App.managers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        Manager m = App.managers.get(num);

        System.out.printf("이름 : %s\n", m.getName());
        System.out.printf("이메일 : %s\n", m.getEmail());
        System.out.printf("암호 : %s\n", m.getPassword());
        System.out.printf("전화 : %s\n", m.getTel());
        System.out.printf("강의과목 : %s\n", m.getPosition());
    }
}
