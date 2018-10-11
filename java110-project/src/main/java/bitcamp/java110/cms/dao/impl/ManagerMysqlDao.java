package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.util.DataSource;

public class ManagerMysqlDao implements ManagerDao{

    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int insert(Manager manager) throws DaoException{
        Connection con = null;
        Statement stmt = null;
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();

            String sql = "insert into p1_mgr(mrno,posi)"
                    + " values(" + manager.getNo()
                    + ",'" + manager.getPosition()
                    + "')";
            return stmt.executeUpdate(sql);

        } catch(Exception e) {
            throw new DaoException(e);
        } finally {
            try{stmt.close();} catch( Exception e) {}
        }
    }

    public List<Manager> findAll() throws DaoException{

        ArrayList<Manager> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery( 
                    "select "+ "m.mno" +
                            ",m.name" + 
                            ",m.email" + 
                            ",mr.posi" + 
                            " from p1_mgr mr join p1_memb m" + 
                    " on mr.mrno = m.mno" );

            while(rs.next()) {
                Manager m = new Manager();
                m.setNo(rs.getInt("mno"));
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
        }
        return list;
    }

    public Manager findByEmail(String email) throws DaoException{
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery( 
                    "select "+ "m.mno" +
                            ",m.name" + 
                            ",m.email" + 
                            ",m.tel" +
                            ",mr.posi" +
                            ",mp.filepath" + 
                            " from p1_mgr mr" +
                            " join p1_memb m on mr.mrno = m.mno" +
                            " left outer join p1_memb_phot mp on mr.mrno = mp.mno" +
                            " where m.email=" + "'" + email+"'");

            if(rs.next()) {
                Manager m = new Manager();
                m.setNo(rs.getInt("mno"));
                m.setEmail(rs.getString("email"));
                m.setName(rs.getString("name"));
                m.setTel(rs.getString("tel"));
                m.setPosition(rs.getString("posi"));
                m.setPhoto(rs.getString("filepath"));

                return m;
            }

            return null;

        } catch(Exception e) {
            throw new DaoException(e);
        } finally {
            try{rs.close();} catch( Exception e) {}
            try{stmt.close();} catch( Exception e) {}
        }
    }

    public Manager findByNo(int no) throws DaoException{
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery( 
                    "select "+ "m.mno" +
                            ",m.name" + 
                            ",m.email" + 
                            ",m.tel" +
                            ",mr.posi" +
                            ",mp.filepath" + 
                            " from p1_mgr mr" +
                            " join p1_memb m on mr.mrno = m.mno" +
                            " left outer join p1_memb_phot mp on mr.mrno = mp.mno" +
                            " where m.mno=" + no);

            if(rs.next()) {
                Manager m = new Manager();
                m.setNo(rs.getInt("mno"));
                m.setEmail(rs.getString("email"));
                m.setName(rs.getString("name"));
                m.setTel(rs.getString("tel"));
                m.setPosition(rs.getString("posi"));
                m.setPhoto(rs.getString("filepath"));

                return m;
            }

            return null;

        } catch(Exception e) {
            throw new DaoException(e);
        } finally {
            try{rs.close();} catch( Exception e) {}
            try{stmt.close();} catch( Exception e) {}
        }
    }

    public int deleteByNo(int no) throws DaoException{
        Connection con = null;
        Statement stmt = null;
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();
            String sql = "delete from p1_mgr where mrno= " + no;
            return stmt.executeUpdate(sql);

        } catch(Exception e) {
            throw new DaoException(e);
        } finally {
            try{stmt.close();} catch( Exception e) {}
        }
    }

    @Override
    public Manager findByEmailPassword(String email, String password) throws DaoException{
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery( 
                    "select "+ "m.mno" +
                            ",m.name" + 
                            ",m.email" + 
                            ",m.tel" +
                            ",mr.posi" + 
                            " from p1_mgr mr join p1_memb m" + 
                            " on mr.mrno = m.mno" +
                            " where m.email=" + "'" + email+
                            "' and m.pwd=password('" + password +
                    "')");

            if(rs.next()) {
                Manager m = new Manager();
                m.setNo(rs.getInt("mno"));
                m.setEmail(rs.getString("email"));
                m.setName(rs.getString("name"));
                m.setTel(rs.getString("tel"));
                m.setPosition(rs.getString("posi"));

                return m;
            }

            return null;

        } catch(Exception e) {
            throw new DaoException(e);
        } finally {
            try{rs.close();} catch( Exception e) {}
            try{stmt.close();} catch( Exception e) {}
        }
    }

}