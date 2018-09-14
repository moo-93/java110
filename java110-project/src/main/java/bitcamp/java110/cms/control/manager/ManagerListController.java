package bitcamp.java110.cms.control.manager;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerListController {

    ManagerDao managerDao;

    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
    
    @RequestMapping("manager/list")
    public void list(Scanner KeyIn) {
        List<Manager> managers = managerDao.findAll();
        for(Manager m : managers){
            System.out.printf("%d %s, %s, %s, %s, %s\n"
                    ,m.getNo()
                    ,m.getName()
                    ,m.getEmail()
                    ,m.getPassword()
                    ,m.getTel()
                    ,m.getPosition());
        }
    }
}
