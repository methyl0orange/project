package com.oracle.jdbc;

import com.oracle.mymybatis.JDBCTemplete;
import com.oracle.po.s;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class TestJDBCTemplete {
    public static void main(String[] args) throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        /*JDBCTemplete jt=new JDBCTemplete();
        String sql="update s set Age=? where SNo=?";
        int i= jt.insertDeleteAndUpdate(sql,21,"S2");
        System.out.println(i);*/

        //查询
        JDBCTemplete jt=new JDBCTemplete();
        String sql="select * from s";
        List<Object> list=jt.selectList(sql, s.class);
        System.out.println(list);

    }
}
