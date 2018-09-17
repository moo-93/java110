package bitcamp.java110.cms.control.teacher;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class TeacherDeleteController {
    
    TeacherDao teacherDao;
    
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
    
    @RequestMapping("teacher/delete")
    public void delete(Request request, Response response) {
        int no = Integer.parseInt(request.getParameter("no"));
        
        PrintWriter out = response.getWriter();
        if(teacherDao.deleteByNo(no) > 0) {
         out.println("삭제 완료");   
        } else {
         out.println("해당 선생의 번호가 존재하지 않습니다.");
        }
        
    }
}
