package com.oracle.service.impl;

import com.oracle.dao.StudentDao;
import com.oracle.po.Student;
import com.oracle.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return studentDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Student record) {
        return studentDao.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return studentDao.insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKey(Integer id) {
        return studentDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentDao.updateByPrimaryKey(record);
    }

    @Override
    public List<Student> selectAll() {
        return studentDao.selectAll();
    }
}
