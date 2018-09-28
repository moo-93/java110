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

@WebServlet("/student/detail")
public class StudentDetailServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        
        int no = Integer.parseInt(request.getParameter("no"));

        StudentDao studentDao = (StudentDao)this.getServletContext()
                .getAttribute("studentDao");
        Student s = studentDao.findByNo(no);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>학생 관리</title>");
        out.println("<style>");
        out.println("table{");
        out.println("border-collapse : collapse;");
        out.println("}");
        out.println("th, td { ");
        out.println(" border : 1px solid red;");
        out.println(" } ");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");
        out.println("<h1>학생 상세정보</h1>");
        
        if (s == null) {
            out.println("<p>해당 번호의 학생이 없습니다!</p>");
        } else {
            out.println("<table>");
            out.println("<tbody>");
            out.printf("<tr><th>번호</th> <th>%d</th></tr>\n", s.getNo());
            out.printf("<tr><th>이름</th> <th>%s</th></tr>\n", s.getName());
            out.printf("<tr><th>이메일</th> <th>%s</th></tr>\n",s.getEmail());
            out.printf("<tr><th>암호</th> <th>%s</th></tr>\n", s.getPassword());
            out.printf("<tr><th>전화</th> <th>%s</th></tr>\n", s.getTel());
            out.printf("<tr><th>최종학력</th> <th>%s</th></tr>\n", s.getSchool());
            out.printf("<tr><th>재직여부</th> <th>%b</th></tr>\n", s.isWorking());
            out.printf("</tbody>");
            out.printf("</table>");
            
            out.println("<button type='button' onclick='remove()'>삭제</button>");
        }
        out.println("<script>");
                out.println("function remove() {");
                        out.printf("location.href = 'delete?no=%d'\n",s.getNo());
                out.println("}");
        out.println("</script>");
        
        out.println("</body>");
        out.println("</html>");
    }
}
