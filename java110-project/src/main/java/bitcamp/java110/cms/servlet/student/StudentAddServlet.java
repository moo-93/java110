package bitcamp.java110.cms.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@WebServlet("/student/add")
public class StudentAddServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Student s = new Student();
        s.setName(request.getParameter("name"));
        s.setEmail(request.getParameter("email"));
        s.setPassword(request.getParameter("password"));
        s.setSchool(request.getParameter("school"));
        s.setWorking(Boolean.parseBoolean(request.getParameter("working")));
        s.setTel(request.getParameter("tel"));


        StudentDao studentDao = (StudentDao)this.getServletContext()
                .getAttribute("studentDao");

        try{
            studentDao.insert(s);  
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
            out.println("<title>학생관리</title>");
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
