package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.domain.Teacher;


public interface TeacherDao {
    public int insert(Teacher teacher)
            throws MandatoryValueDaoException, DuplicationDaoException;
    public List<Teacher> findAll();
    public Teacher findByEmail(String email);
    public int delete(String email);
}
