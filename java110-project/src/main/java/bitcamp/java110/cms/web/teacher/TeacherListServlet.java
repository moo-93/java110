package bitcamp.java110.cms.web.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.service.TeacherService;

@Component
public class TeacherListServlet {
    
    @Autowired
    TeacherService teacherService;
    
    @RequestMapping("/teacher/list")
    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {

        int pageNo = 1;
        int pageSize = 10;
        
        if (request.getParameter("pageNo") != null) {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
            if (pageNo < 1)
                pageNo = 1;
        }
        
        if (request.getParameter("pageSize") != null) {
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
            if (pageSize < 3 || pageSize > 10)
                pageSize = 3;
        }
        
        
        List<Teacher> list = teacherService.list(pageNo, pageSize);
        request.setAttribute("list", list);
        
        response.setContentType("text/html;charset=UTF-8");
        return "/teacher/list.jsp";
    }
}
