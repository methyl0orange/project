package com.oracle.ssm.dao;

import com.oracle.ssm.po.Student;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public interface StudentMapper {
    List<Student> selectStudents();

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}