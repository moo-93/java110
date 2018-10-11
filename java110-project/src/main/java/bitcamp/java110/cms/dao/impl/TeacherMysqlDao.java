package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.util.DataSource;

public class TeacherMysqlDao implements TeacherDao {

    DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public int insert(Teacher teacher) throws DaoException{
        Statement stmt = null;
        Connection con = null;
        try {
            con = dataSource.getConnection();
            con.setAutoCommit(false);
            stmt = con.createStatement();
            
            String sql = "insert into p1_tchr(tno,hrpay,subj)"
                    + " values(" + teacher.getNo()
                    + ", " + teacher.getPay()
                    + ", '" + teacher.getSubjects()
                    + "')";
            
            return stmt.executeUpdate(sql);

        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try{stmt.close();} catch(Exception e) {}
        }
    }


    public List<Teacher> findAll() throws DaoException{
        ArrayList<Teacher> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery(
                    "select m.mno "
                            + " ,m.name"
                            + " ,m.email"
                            + " ,tc.hrpay"
                            + " ,tc.subj"
                            + " from p1_memb m join p1_tchr tc"
                            + " on m.mno = tc.tno");

            while(rs.next()) {
                Teacher t = new Teacher();
                t.setNo(rs.getInt("mno"));
                t.setName(rs.getString("name"));
                t.setEmail(rs.getString("email"));
                t.setPay(rs.getInt("hrpay"));
                t.setSubjects(rs.getString("subj"));

                list.add(t);
            }

        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try{rs.close();} catch(Exception e) {}
            try{stmt.close();} catch(Exception e) {}
        }
        return list;
    }

    public Teacher findByEmail(String email) {
        return null;
    }
    
    public Teacher findByNo(int no) throws DaoException{
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery(
                    "select m.mno "
                            + " ,m.name"
                            + " ,m.email"
                            + " ,tc.hrpay"
                            + " ,tc.subj"
                            + " ,mp.filepath"
                            + " from p1_memb m join p1_tchr tc"
                            + " on m.mno = tc.tno"
                            + " left outer join p1_memb_phot mp on tc.tno = mp.mno"
                            + " where m.mno = " + no);

            if(rs.next()) {
                Teacher t = new Teacher();
                t.setNo(rs.getInt("mno"));
                t.setName(rs.getString("name"));
                t.setEmail(rs.getString("email"));
                t.setPay(rs.getInt("hrpay"));
                t.setSubjects(rs.getString("subj"));
                t.setPhoto(rs.getString("filepath"));
                
                return t;
            }
            return null;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try{rs.close();} catch(Exception e) {}
            try{stmt.close();} catch(Exception e) {}
        }
    }

    public int deleteByNo(int no) throws DaoException{
        Connection con = null;
        Statement stmt = null;
        
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();
            String sql = "delete from p1_tchr where tno = " + no;
            return stmt.executeUpdate(sql);
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try{stmt.close();} catch(Exception e) {}
        }
    }
    
    @Override
    public Teacher findByEmailPassword(String email, String password) throws DaoException{
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery(
                    "select m.mno "
                            + " ,m.name"
                            + " ,m.email"
                            + " ,m.tel"
                            + " ,tc.hrpay"
                            + " ,tc.subj"
                            + " from p1_memb m join p1_tchr tc"
                            + " on m.mno = tc.tno"
                            + " where m.email = "+ "'" + email +
                              "' and m.pwd=password('" + password +
                              "')");

            if(rs.next()) {
                Teacher t = new Teacher();
                t.setNo(rs.getInt("mno"));
                t.setName(rs.getString("name"));
                t.setEmail(rs.getString("email"));
                t.setPay(rs.getInt("hrpay"));
                t.setSubjects(rs.getString("subj"));
                
                return t;
            }
            return null;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try{rs.close();} catch(Exception e) {}
            try{stmt.close();} catch(Exception e) {}
        }
    }
}
