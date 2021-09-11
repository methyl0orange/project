package com.oracle.service;


import com.oracle.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("ds")
public class DeptService {
    /*public static void main(String[] args) {
        //手动加载配置文件
        ClassPathXmlApplicationContext cp=new ClassPathXmlApplicationContext("spring-config.xml");


        //从容器中获取dao对象

        //DeptDao deptDao=(DeptDao)cp.getBean("deptDao");
        DeptDao deptDao=(DeptDao)cp.getBean("dd");
        deptDao.dao();
    }*/
    @Autowired
    private DeptDao deptDao;
    public void service(){
        deptDao.dao();
    }
}
