package bitcamp.java110.cms.web.teacher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.service.TeacherService;

@Component
public class TeacherDeleteServlet {

    @Autowired
    TeacherService teacherService;
    
    @RequestMapping("/teacher/delete")
    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) {

        int no = Integer.parseInt(request.getParameter("no"));
        
        try {
            teacherService.delete(no);
            return "redirect:list";
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("message", "강사 삭제 오류!");
            request.setAttribute("refresh", "3;url=list");
            return "/error.jsp";
        }
        
    }

}
