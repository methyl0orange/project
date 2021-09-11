package com.test;

import com.dao.StudentMapper;
import com.po.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        Reader reader=Resources.getResourceAsReader("mybatis.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sqlSessionFactory.openSession(true);
//        Student student= session.getMapper(StudentMapper.class).selectById(2);
//        System.out.println(student);
//        Student student=new Student();
//        student.setId(50);
//        student.setManager("dfghjk");
//        int i=session.getMapper(StudentMapper.class).insert(student);
//        System.out.println(i);
        List<Student> studentList=session.getMapper(StudentMapper.class).select();
        System.out.println(studentList);
    }
}
