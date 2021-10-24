package com.oracle.jdbc;

//import com.mysql.jdbc.ResultSet;
import com.oracle.po.s;

import java.sql.*;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        //1,导jar 包  2.创建驱动 3,创建链接
        Class.forName("com.mysql.jdbc.Driver");
        try {
            /*Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/teach_data?characterEncoding=UTF-8","root","123456");
            //4.创建状态参数
            Statement statement=connection.createStatement();
            //执行 sql*/
            //String sql="insert into s values ('S1','赵艺','女',17,'计算机')";
            //int i=statement.executeUpdate(sql);
            //System.out.println(i);
            //查询
            /*String sql="select count(*) from s";
            ResultSet rs= (ResultSet) statement.executeQuery(sql);
            if(rs.next()){
                System.out.println(rs.getInt(1));
            }*/
            /*String sql="select * from s";
            ResultSet rs= (ResultSet) statement.executeQuery(sql);
            if(rs.next()){
                System.out.println(rs.getString("SNo"));
                System.out.println(rs.getString("SN"));
            }*/
            /*String sql="select * from s";
            ResultSet rs= (ResultSet) statement.executeQuery(sql);
            s ss=null;
            ArrayList<s> arrayList=new ArrayList<>();
            while(rs.next()){
                ss=new s();
                ss.setSNo(rs.getString("SNo"));
                ss.setSN(rs.getString("SN"));
                ss.setSex(rs.getString("Sex"));
                ss.setAge(rs.getInt("Age"));
                ss.setDept(rs.getString("Dept"));
                arrayList.add(ss);
            }
            System.out.println(arrayList);*/
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/teach_data?characterEncoding=UTF-8","root","123456");
            String sql="delete from s where SNo=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,"S1");
            int i=preparedStatement.executeUpdate();
            System.out.println(i);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
