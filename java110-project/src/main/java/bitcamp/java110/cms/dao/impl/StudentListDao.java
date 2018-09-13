package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentListDao implements StudentDao{

    public int insert(Student student) {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/studydb"
                    ,"study","1111");

            con.setAutoCommit(false);

            stmt = con.createStatement();
            String sql = ("insert into p1_memb(name,email,pwd,tel,cdt)"
                    + " values('" + student.getName()
                    + "','" + student.getEmail()
                    + "',password('" + student.getPassword()
                    + "'),'" + student.getTel()
                    + "', now())");

            stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);

            ResultSet autogeneratedKeys = stmt.getGeneratedKeys();
            autogeneratedKeys.next();
            int memberNo = autogeneratedKeys.getInt(1);

            String work = "";
            if(student.isWorking())
                work = "Y";
            else work = "N";
//            System.out.println(work);
            String sql2 = "insert into p1_stud(sno,schl,work)"
                    + " values(" + memberNo
                    + ",'" + student.getSchool()
                    + "','" + work 
                    +"')";
//            System.out.println(sql2);
            stmt.executeUpdate(sql2);

            con.commit();
            return 1;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try {stmt.close();} catch(Exception e) {}
            try {con.close();} catch(Exception e) {}
        }
    }

    public List<Student> findAll(){
        ArrayList<Student> list = new ArrayList<>();
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
                            + " ,st.schl"
                            + " ,st.work"
                            + " from p1_memb m join p1_stud st"
                            + " on m.mno = st.sno");

            while(rs.next()) {
                Student s = new Student();
                s.setNo(rs.getInt("mno"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setSchool(rs.getString("schl"));
                if(rs.getString("work").equals("Y")) 
                    s.setWorking(true);
                else s.setWorking(false);

                list.add(s);
            }
        } catch(Exception e) {
            throw new DaoException(e);
        } finally {
            try {rs.close();} catch(Exception e) {}
            try {stmt.close();} catch(Exception e) {}
            try {con.close();} catch(Exception e) {}
        }
        return list;
    }

    public Student findByEmail(String email) {
        return null;
    }

    public Student findByNo(int no) {
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
                            + " ,m.tel"
                            + " ,st.schl"
                            + " ,st.work"
                            + " from p1_memb m join p1_stud st"
                            + " on m.mno = st.sno"
                            + " where m.mno = "+ no);

            if(rs.next()) {
                Student s = new Student();
                s.setNo(rs.getInt("mno"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setTel(rs.getString("tel"));
                s.setSchool(rs.getString("schl"));
                s.setWorking(rs.getBoolean("work"));

                return s;
            }
            return null;
        } catch(Exception e) {
            throw new DaoException(e);
        } finally {
            try {rs.close();} catch(Exception e) {}
            try {stmt.close();} catch(Exception e) {}
            try {con.close();} catch(Exception e) {}
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
            
            String sql = "delete from p1_stud where sno= " + no;
            int count = stmt.executeUpdate(sql);

            if(count == 0)
                return 0;

            String sql2 ="delete from p1_memb where mno=" + no;
            stmt.executeUpdate(sql2);
            
            con.commit();
            return 1;      

        } catch(Exception e) {
            throw new DaoException(e);
        } finally {
            try{stmt.close();} catch( Exception e) {}
            try{con.close();} catch( Exception e) {}
        }
    }
}
