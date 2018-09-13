package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerJdbcDao implements ManagerDao{

    public int insert(Manager manager) {
        return 0;
    }

    public List<Manager> findAll() {

        ArrayList<Manager> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // => java.sql.Driver 구현체를 로딩
            // => 해당 클래스의 객체를 만들어 DriverManager에 등록한다.
            Class.forName("org.mariadb.jdbc.Driver");

            // => DriverManager에게 java.sql.Connection 객체를 요구한다.
            // => DriverMAnager는 등록된 Driver 들 중에서 요구 사항에 맞는
            //    드라이버를 찾아 connect()를 호출한다.
            //    그리고 connect() 메서드의 리턴 값을 그대로 리턴해 준다.
            con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb","study","1111");

            // => 질의문을 작성할 객체를 준비한다.
            stmt = con.createStatement();

            // => select 질의를 한다.
            /*
          select m.name
                 ,m.email
                 ,mr.posi
          from p1_mgr mr right join p1_memb m
           on mr.mrno = m.mno;
             */

            rs = stmt.executeQuery( 
                    "select m.name\r\n" + 
                            "                 ,m.email\r\n" + 
                            "                 ,mr.posi\r\n" + 
                            "          from p1_mgr mr join p1_memb m\r\n" + 
                    "           on mr.mrno = m.mno" );
            // 서버에 생성된 질의 결과를 한 개씩 가져온다.
            while(rs.next()) {
                Manager m = new Manager();
                m.setEmail(rs.getString("email"));
                m.setName(rs.getString("name"));
                m.setPosition(rs.getString("posi"));

                list.add(m);
            }

        } catch(Exception e) {
            throw new DaoException(e);
        } finally {
            try{rs.close();} catch( Exception e) {}
            try{stmt.close();} catch( Exception e) {}
            try{con.close();} catch( Exception e) {}
        }
        return list;
    }

    public Manager findByEmail(String email) {
        return null;
    }

    public int delete(String email) {
        return 0;
    }
}
