package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerDetailController {

    ManagerDao managerDao;

    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
    @RequestMapping("manager/detail")
    public void detail(Scanner KeyIn) {
        System.out.print("조회할 매니저의 번호 : ");
        int no = Integer.parseInt(KeyIn.nextLine());

        Manager m = managerDao.findByNo(no);

        if(m==null) {
            System.out.println("해당 매니져의 번호가 존재하지 않습니다.");
            return;
        }

        System.out.printf("이름 : %s\n", m.getName());
        System.out.printf("이메일 : %s\n", m.getEmail());
        System.out.printf("암호 : %s\n", m.getPassword());
        System.out.printf("전화 : %s\n", m.getTel());
        System.out.printf("강의과목 : %s\n", m.getPosition());
    }
}
