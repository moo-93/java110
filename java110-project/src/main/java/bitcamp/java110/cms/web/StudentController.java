package bitcamp.java110.cms.web;

import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.service.StudentService;

@Component
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    ServletContext sc;

    @RequestMapping("/student/detail")
    public String detail(
            HttpServletRequest request) {

        int no = Integer.parseInt(request.getParameter("no"));

        Student s = studentService.get(no);
        request.setAttribute("student", s);
        return "/student/detail.jsp";
    }

    @RequestMapping("/student/list")
    public String list(
            HttpServletRequest request) {

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

        List<Student> list = studentService.list(pageNo, pageSize);

        request.setAttribute("list", list);
        return "/student/list.jsp";
    }

    @RequestMapping("/student/delete")
    public String delete(
            HttpServletRequest request) {

        int no = Integer.parseInt(request.getParameter("no"));

        studentService.delete(no);
        return "redirect:list";

    }

    @RequestMapping("/student/add")
    public String add(
            HttpServletRequest request) throws Exception{ 

        if(request.getMethod().equals("GET")) {
            return "/student/form.jsp";
        }

        request.setCharacterEncoding("UTF-8");

        Student s = new Student();
        s.setName(request.getParameter("name"));
        s.setEmail(request.getParameter("email"));
        s.setPassword(request.getParameter("password"));
        s.setTel(request.getParameter("tel"));
        s.setSchool(request.getParameter("school"));
        s.setWorking(Boolean.parseBoolean(request.getParameter("working")));


        // 사진 데이터 처리
        Part part = request.getPart("file1");
        if (part.getSize() > 0) {
            String filename = UUID.randomUUID().toString();
            part.write(sc.getRealPath("/upload/" + filename));
            s.setPhoto(filename);
        }
        studentService.add(s);
        return "redirect:list";
    }
}

