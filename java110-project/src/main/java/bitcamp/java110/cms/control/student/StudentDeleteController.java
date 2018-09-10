package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;

@Component
public class StudentDeleteController {

    @RequestMapping("student/delete")
    public void delete(Scanner KeyIn) {
        System.out.print("삭제할 번호 : ");
        int num = Integer.parseInt(KeyIn.nextLine());

        if(num < 0 || num >= App.students.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        App.students.remove(num);
        System.out.println("삭제 완료");
    }
}
