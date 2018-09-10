package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;

@Component
public class TeacherDeleteController {

    @RequestMapping("teacher/delete")
    public void delete(Scanner KeyIn) {
        System.out.print("삭제할 선생의 이메일 : ");
        String email = KeyIn.nextLine();
        
        if(App.teacherDao.delete(email) > 0) {
         System.out.println("삭제 완료");   
        } else {
            System.out.println("해당 선생의 이메일이 존재하지 않습니다.");
        }
        
    }
}
