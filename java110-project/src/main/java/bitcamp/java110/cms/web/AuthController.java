package bitcamp.java110.cms.web;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Member;
import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.service.AuthService;

@Component
public class AuthController {

    @Autowired
    AuthService authService;
    
    @RequestMapping("/auth/login")
    public String login(
            HttpServletRequest request, 
            HttpServletResponse response) { 

        if(request.getMethod().equals("GET")) {
            return "/auth/form.jsp";
        }
        String type = request.getParameter("type");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String save = request.getParameter("save");

        ArrayList<Cookie> cookies = new ArrayList<>();

        if (save != null) {// 이메일 저장하기를 체크했다면,
            Cookie cookie = new Cookie("email", email);
            cookie.setMaxAge(60 * 60 * 24 * 15);
            response.addCookie(cookie);
        } else {// 이메일을 저장하고 싶지 않다면,
            Cookie cookie = new Cookie("email", "");
            cookie.setMaxAge(0);
            cookies.add(cookie);
        }

        Member loginUser = authService.getMember(email, password, type);

        HttpSession session = request.getSession();
        if (loginUser != null) {
            // 회원 정보를 세션에 보관한다.
            session.setAttribute("loginUser", loginUser);
            String redirectUrl = null;
            switch (type) {
            case "student":
                redirectUrl = "../student/list";
                break;
            case "teacher":
                redirectUrl = "../teacher/list";
                break; 
            case "manager":
                redirectUrl = "../manager/list";
                break; 
            }
            return "redirect:" + redirectUrl;
        } else {
            session.invalidate();
            return "redirect:login";
        }
    }
    
    @RequestMapping("/auth/logout")
    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) {
        
        HttpSession session = request.getSession();
        session.invalidate();

        return "redirect:login";
    }
}
