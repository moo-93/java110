package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@WebServlet("/teacher/add")
public class TeacherAddServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        Teacher t = new Teacher();
        t.setName(request.getParameter("name"));
        t.setEmail(request.getParameter("email"));
        t.setTel(request.getParameter("tel"));
        t.setPassword(request.getParameter("password"));
        t.setPay(Integer.parseInt(request.getParameter("pay")));
        t.setSubjects(request.getParameter("subjects"));


        TeacherDao teacherDao = (TeacherDao)this.getServletContext()
                .getAttribute("teacherDao");
        
        
        try{
            teacherDao.insert(t);  
            response.sendRedirect("list");
        } catch (Exception e) {
            e.printStackTrace();
            response.setHeader("Refresh", "5;url=list");
            response.setContentType("text/html;charset=UTF-8");
            
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>선생관리</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>등록 중 오류 발생</h1>");
            out.printf("<p>%s</p>\n", e.getMessage());
            out.println("<p> 잠시 기다리면 목록페이지로 돌아갑니다</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
