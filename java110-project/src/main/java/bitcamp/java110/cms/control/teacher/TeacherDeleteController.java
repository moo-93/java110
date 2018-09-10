package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;

@Component
public class TeacherDeleteController {

    @RequestMapping("teacher/delete")
    public void delete(Scanner KeyIn) {
        System.out.print("삭제할 번호 : ");
        int num = Integer.parseInt(KeyIn.nextLine());
        
        if(num < 0 || num >= App.teachers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        App.teachers.remove(num);
        System.out.println("삭제 완료");
    }
}
