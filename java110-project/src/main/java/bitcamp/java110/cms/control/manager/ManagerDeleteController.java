package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;

@Component
public class ManagerDeleteController {
    
    @RequestMapping("manager/delete")
    public void delete(Scanner KeyIn) {
        System.out.print("삭제할 번호 : ");
        int num = Integer.parseInt(KeyIn.nextLine());
        
        if(num < 0 || num >= App.managers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        App.managers.remove(num);
        System.out.println("삭제 완료");
    }
    
}
