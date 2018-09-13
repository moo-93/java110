package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherJdbcDao implements TeacherDao {

    public int insert(Teacher teacher) {

        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/studydb"
                    ,"study","1111");
            
            con.setAutoCommit(false);
            
            stmt = con.createStatement();
            
            String sql = "insert into p1_memb(name,email,pwd,tel,cdt)"
                    + " values('" + teacher.getName()
                    + "', '" + teacher.getEmail()
                    + "',password('" + teacher.getPassword()
                    + "'),'"+ teacher.getTel()
                    + "', now())"; 
            
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet autogeneratedKeys = stmt.getGeneratedKeys();
            autogeneratedKeys.next();
            int memberNo = autogeneratedKeys.getInt(1);
           
            String sql2 = "insert into p1_tchr(tno,hrpay,subj)"
                    + " values(" + memberNo
                    + ", " + teacher.getPay()
                    + ", '" + teacher.getSubjects()
                    + "')";
            
            stmt.executeQuery(sql2);
            con.commit();
            return 1;

        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try{stmt.close();} catch(Exception e) {}
            try{con.close();} catch(Exception e) {}
        }
    }


    public List<Teacher> findAll() {
        ArrayList<Teacher> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/studydb"
                    ,"study","1111");
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
            try{con.close();} catch(Exception e) {}
        }
        return list;
    }

    public Teacher findByEmail(String email) {
        return null;
    }
    
    public Teacher findByNo(int no) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/studydb"
                    ,"study","1111");
            stmt = con.createStatement();

            rs = stmt.executeQuery(
                    "select m.mno "
                            + " ,m.name"
                            + " ,m.email"
                            + " ,tc.hrpay"
                            + " ,tc.subj"
                            + " from p1_memb m join p1_tchr tc"
                            + " on m.mno = tc.tno"
                            + " where m.mno = " + no);

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
            try{con.close();} catch(Exception e) {}
        }
    }

    public int deleteByNo(int no) {
        Connection con = null;
        Statement stmt = null;
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/studydb"
                    ,"study","1111");
            
            con.setAutoCommit(false);
            
            stmt = con.createStatement();
            
            String sql = "delete from p1_tchr where tno = " + no;
            int count = stmt.executeUpdate(sql);
            
            if(count == 0)
                return 0;
            
            String sql2 = "delete from p1_memb where mno = " + no;
            stmt.executeUpdate(sql2);
        
            con.commit();
            return 1;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try{stmt.close();} catch(Exception e) {}
            try{con.close();} catch(Exception e) {}
        }
        
    }
}
