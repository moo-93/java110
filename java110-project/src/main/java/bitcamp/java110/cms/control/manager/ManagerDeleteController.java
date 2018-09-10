package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;

@Component
public class ManagerDeleteController {

    @RequestMapping("manager/delete")
    public void delete(Scanner KeyIn) {
        System.out.print("삭제할 이메일 : ");
        String email = KeyIn.nextLine();

        if(App.managerDao.delete(email) > 0) {
            System.out.println("삭제 완료");    
        } else {
            System.out.println("해당 이메일이 존재하지 않습니다.");
        }
    }
}
