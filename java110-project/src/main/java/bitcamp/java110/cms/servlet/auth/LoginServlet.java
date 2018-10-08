package bitcamp.java110.cms.servlet.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Member;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request
            , HttpServletResponse response)
                    throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher rd = request.getRequestDispatcher("/auth/login.jsp");
        rd.include(request, response);
    }
    
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {

        String type = request.getParameter("type");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String save = request.getParameter("save");

        // radio나 checked가 체크 되어 있지 않으면 null 
        // 체크된경우 value값 반환  (기본값 on)
        // 이메일 저장하기를 체크했다면 ,
        if(save != null) {
            Cookie cookie = new Cookie("email", email);
            cookie.setMaxAge(60 * 60 * 24 * 15);
            response.addCookie(cookie);
        } else { // 이메일을 저장하고 싶지 않다면
            Cookie cookie = new Cookie("email", "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        
        Member loginUser = null;

        if(type.equals("manager")) {
            ManagerDao managerDao = (ManagerDao)this.getServletContext()
                    .getAttribute("managerDao");
            loginUser = managerDao.findByEmailPassword(email, password);
        } else if(type.equals("student")) {
            StudentDao studentDao = (StudentDao)this.getServletContext()
                    .getAttribute("studentDao");
            loginUser = studentDao.findByEmailPassword(email, password);
        } else if (type.equals("teacher")) {
            TeacherDao teacherDao = (TeacherDao)this.getServletContext()
                    .getAttribute("teacherDao");
            loginUser = teacherDao.findByEmailPassword(email, password);
        }
        
        HttpSession session = request.getSession();
        if(loginUser != null) {
            // 회원 정보를 세션에 보관한다.
            session.setAttribute("loginUser", loginUser);
            
            response.sendRedirect("../manager/list");
        } else {
            // 로그인 된 상태에서 다른 사용자로 로그인을 시도하다가
            // 실패한다면 무조건 세션을 무효화 시킨다.
            session.invalidate();
            
            response.sendRedirect("login");
        }
    }
}
