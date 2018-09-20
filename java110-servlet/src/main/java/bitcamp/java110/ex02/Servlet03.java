package bitcamp.java110.ex02;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 서블릿 만들기 3
 * - javax.servlet.HttpServlet 구현
 * 
 */

@WebServlet("/ex02/servlet03")
public class Servlet03 extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("Servlet03.doGet() 호출됨.");
    }    
}