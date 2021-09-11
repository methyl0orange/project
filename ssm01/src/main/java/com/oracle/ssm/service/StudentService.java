package com.oracle.ssm.service;

import com.oracle.ssm.po.Student;

import java.util.List;

public interface StudentService {

    List<Student> selectStudents();

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}
