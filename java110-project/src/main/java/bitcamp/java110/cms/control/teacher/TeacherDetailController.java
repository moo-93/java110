package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherDetailController {

    TeacherDao teacherDao;
    
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
    
    @RequestMapping("teacher/detail")
    public void detail(Scanner keyIn) {
        System.out.print("조회할 번호? ");
        String email = keyIn.nextLine();
        
        Teacher t = teacherDao.findByEmail(email);
        
        if(t==null) {
            System.out.println("해당 매니저의 이메일이 존재하지 않습니다.");
            return;
        }
        
        System.out.printf("이름: %s\n", t.getName());
        System.out.printf("이메일: %s\n", t.getEmail());
        System.out.printf("암호: %s\n", t.getPassword());
        System.out.printf("전화: %s\n", t.getTel());
        System.out.printf("시급: %d\n", t.getPay());
        System.out.printf("강의과목: %s\n", t.getSubjects());
    }

}
