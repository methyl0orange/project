package com.oracle.ssm.service.Impl;

import com.oracle.ssm.dao.StudentMapper;
import com.oracle.ssm.po.Student;
import com.oracle.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> selectStudents() {
        return studentMapper.selectStudents();
    }

    public int deleteByPrimaryKey(Integer id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    public Student selectByPrimaryKey(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }
}
