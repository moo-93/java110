package bitcamp.java110.cms.web.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.service.StudentService;

@Component
public class StudentDeleteController {

    @Autowired
    StudentService studentService;
    
    @RequestMapping("/student/delete")
    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) {

        int no = Integer.parseInt(request.getParameter("no"));
        
        try {
            studentService.delete(no);
            return "redirect:list";
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("message", "학생 삭제 오류!");
            request.setAttribute("refresh", "3;url=list");
            return "/error.jsp";
        }
    }
}
