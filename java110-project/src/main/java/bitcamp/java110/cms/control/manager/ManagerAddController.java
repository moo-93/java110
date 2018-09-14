package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerAddController {

    ManagerDao managerDao;

    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

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

            managerDao.insert(m);

            System.out.print("continue? (Y/n) ");
            String answer = KeyIn.nextLine();
            if(answer.toLowerCase().equals("n")) break;
        }
    }

}
