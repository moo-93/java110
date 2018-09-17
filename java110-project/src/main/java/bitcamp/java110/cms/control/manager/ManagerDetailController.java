package bitcamp.java110.cms.control.manager;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class ManagerDetailController {

    ManagerDao managerDao;

    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
    @RequestMapping("manager/detail")
    public void detail(Request request, Response response) {
        int no = Integer.parseInt(request.getParameter("no"));
        Manager m = managerDao.findByNo(no);
        
        PrintWriter out = response.getWriter();
        
        if(m==null) {
            out.println("해당 매니져의 번호가 존재하지 않습니다.");
            return;
        }

        out.printf("이름 : %s\n", m.getName());
        out.printf("이메일 : %s\n", m.getEmail());
        out.printf("암호 : %s\n", m.getPassword());
        out.printf("전화 : %s\n", m.getTel());
        out.printf("강의과목 : %s\n", m.getPosition());
    }
}
