package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;

@Component
public class StudentDeleteController {

    StudentDao studentDao;
    
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    @RequestMapping("student/delete")
    public void delete(Scanner KeyIn) {
        System.out.print("삭제할 학생의 이메일 : ");
        String email = KeyIn.nextLine();
        if(studentDao.delete(email)> 0) {
            System.out.println("삭제 완료");
        } else {
            System.out.println("이메일에 해당하는 학생이 존재하지 않습니다.");
        }
    }
}
