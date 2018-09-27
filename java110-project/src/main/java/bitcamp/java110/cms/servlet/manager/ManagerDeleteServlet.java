package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.ManagerDao;

@WebServlet("/manager/delete")
public class ManagerDeleteServlet extends HttpServlet{ 

private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException{
       
        response.setContentType("text/plain;charset=UTF-8");
        int no = Integer.parseInt(request.getParameter("no"));
        PrintWriter out = response.getWriter();
        
        ManagerDao managerDao = (ManagerDao)this.getServletContext()
                                    .getAttribute("managerDao");
        
        if (managerDao.deleteByNo(no) > 0) {
            out.println("삭제하였습니다.");
        } else {
            out.println("해당 이메일의 매니저가 없습니다!");
        }
    }
}