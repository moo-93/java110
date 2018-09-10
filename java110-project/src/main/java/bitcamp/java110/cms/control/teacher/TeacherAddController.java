package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherAddController {

    @RequestMapping("teacher/add")
    public void add(Scanner KeyIn) {
        while(true) {
            Teacher t = new Teacher();

            System.out.print("이름 : ");
            t.setName(KeyIn.nextLine());

            System.out.print("이메일 : ");
            t.setEmail(KeyIn.nextLine());

            System.out.print("암호 : ");
            t.setPassword(KeyIn.nextLine());
            
            System.out.print("전화번호  : ");
            t.setTel(KeyIn.nextLine());
            
            System.out.print("시급 : ");
            t.setPay(Integer.parseInt(KeyIn.nextLine()));
            
            System.out.print("강의과목 : ");
            t.setSubjects(KeyIn.nextLine());
            
            if(App.teacherDao.insert(t) > 0) {
                System.out.println("저장 성공!");
            } else {
                System.out.println("해당 이메일이 이미 존재합니다.");
            }

            System.out.print("continue? (Y/n) ");
            String answer = KeyIn.nextLine();
            if(answer.toLowerCase().equals("n")) break;
        }
    }
}
