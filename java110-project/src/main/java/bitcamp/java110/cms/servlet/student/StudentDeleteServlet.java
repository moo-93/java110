package bitcamp.java110.cms.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.StudentDao;

@WebServlet("/student/delete")
public class StudentDeleteServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {

        int no = Integer.parseInt(request.getParameter("no"));

        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        StudentDao studentDao = (StudentDao)this.getServletContext()
                .getAttribute("studentDao");
        
        if(studentDao.deleteByNo(no)> 0) {
            out.println("삭제 완료");
        } else {
            out.println("해당 학생번호가 존재하지 않습니다.");
        }
    }
}
