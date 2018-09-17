package bitcamp.java110.cms.control.manager;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class ManagerListController {

    ManagerDao managerDao;
    Response response;
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
    
    @RequestMapping("manager/list")
    public void list(Request request, Response response) {
        List<Manager> managers = managerDao.findAll();
        PrintWriter out = response.getWriter();
        for(Manager m : managers){
            out.printf("%d %s, %s, %s, %s, %s\n"
                    ,m.getNo()
                    ,m.getName()
                    ,m.getEmail()
                    ,m.getPassword()
                    ,m.getTel()
                    ,m.getPosition());
        }
    }
}
