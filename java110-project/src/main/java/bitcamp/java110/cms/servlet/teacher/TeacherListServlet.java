package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@WebServlet("/teacher/list")
public class TeacherListServlet extends HttpServlet{
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException  {
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        TeacherDao teacherDao = (TeacherDao)this.getServletContext()
                .getAttribute("teacherDao");
        
        List<Teacher> teachers = teacherDao.findAll();
        for(Teacher t : teachers){
            out.printf("%d %s, %s, %s, %s, %d, %s\n",
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
