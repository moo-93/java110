package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;

@Component
public class TeacherDeleteController {
    
    TeacherDao teacherDao;
    
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
    
    @RequestMapping("teacher/delete")
    public void delete(Scanner KeyIn) {
        System.out.print("삭제할 선생의 이메일 : ");
        String email = KeyIn.nextLine();
        
        if(teacherDao.delete(email) > 0) {
         System.out.println("삭제 완료");   
        } else {
            System.out.println("해당 선생의 이메일이 존재하지 않습니다.");
        }
        
    }
}
