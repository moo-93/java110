package bitcamp.java110.cms.control.student;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class StudentDeleteController {

    StudentDao studentDao;
    
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    @RequestMapping("student/delete")
    public void delete(Request request, Response response) {
       
        int no = Integer.parseInt(request.getParameter("no"));
        
        PrintWriter out = response.getWriter();
        
        if(studentDao.deleteByNo(no)> 0) {
            out.println("삭제 완료");
        } else {
            out.println("해당 학생번호가 존재하지 않습니다.");
        }
    }
}
