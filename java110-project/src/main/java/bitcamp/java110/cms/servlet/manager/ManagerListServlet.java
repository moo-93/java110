package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.impl.ManagerMysqlDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.util.DataSource;

@WebServlet("/manager/list")
public class ManagerListServlet extends HttpServlet{ 

    private static final long serialVersionUID = 1L;
    ManagerMysqlDao managerDao;
    
    // HttpServlet은 ioc 컨테이너를 관리하지 않기 때문에 dao를 수동으로 연결해줘야 한다.
    @Override
    public void init() throws ServletException {
        DataSource dataSource = new DataSource();
        managerDao = new ManagerMysqlDao();
        managerDao.setDataSource(dataSource);
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException{
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<Manager> list = managerDao.findAll();

        for (Manager s : list) {
            out.printf("%d, %s, %s, %s, %s, %s\n",
                    s.getNo(),
                    s.getName(), 
                    s.getEmail(), 
                    s.getPassword(), 
                    s.getTel(),
                    s.getPosition());
        }
    }
}