package com.dao;

import com.po.Student;

import java.util.List;

public interface StudentMapper {
    Student selectById(Integer id);
    int insert(Student student);
    List<Student> select();

}
