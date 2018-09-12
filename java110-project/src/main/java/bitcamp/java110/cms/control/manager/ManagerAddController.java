package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
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
            
            int rtval = 0;
            if((rtval = managerDao.insert(m)) > 0) {
                System.out.println("저장 완료!");   
            } else if(rtval == -1) {
              System.out.println("필수 입력 항목이 비었습니다.");  
            } else if(rtval == -2){
                System.out.println("해당 이메일이 존재합니다.");
            } else {
                System.out.println("예기치 않은 오류가 발생하였습니다.");
            }

            System.out.print("continue? (Y/n) ");
            String answer = KeyIn.nextLine();
            if(answer.toLowerCase().equals("n")) break;
        }
    }

}
