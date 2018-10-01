//세션 사용 후 - HttpSession 보관소에 데이터 저장하기 
package bitcamp.java110.ex11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex11/servlet04")
public class Servlet04 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String tel = request.getParameter("tel");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>non-session</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>최종 페이지</h1>");
        out.printf("<h2>이름: %s</h2>\n", name);
        out.printf("<h2>나이: %s</h2>\n", age);
        out.printf("<h2>전화: %s</h2>\n", tel);
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}