package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        System.out.print("삭제할 학생의 번호 : ");
        int no = Integer.parseInt(KeyIn.nextLine());
        if(studentDao.deleteByNo(no)> 0) {
            System.out.println("삭제 완료");
        } else {
            System.out.println("해당 학생번호가 존재하지 않습니다.");
        }
    }
}
