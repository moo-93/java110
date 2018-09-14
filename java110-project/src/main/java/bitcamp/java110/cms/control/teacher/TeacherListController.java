package bitcamp.java110.cms.control.teacher;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherListController {

    TeacherDao teacherDao;
    
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
    
    @RequestMapping("teacher/list")
    public void list(Scanner keyIn) {
        
        List<Teacher> teachers = teacherDao.findAll();
        for(Teacher t : teachers){
            System.out.printf("%d %s, %s, %s, %s, %d, %s\n",
                    t.getNo(),
                    t.getName(), 
                    t.getEmail(), 
                    t.getPassword(), 
                    t.getTel(),
                    t.getPay(),
                    t.getSubjects());
        }
    }
}
