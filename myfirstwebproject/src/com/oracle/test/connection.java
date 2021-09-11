package com.oracle.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class connection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/teach_data?characterEncoding=UTF-8","root","123456");
        String sql="insert into user(username,password,email,telephone) values (?,?,?,?)";
        PreparedStatement ps=connection.prepareStatement(sql);
        ps.setString(1,"wxc");
        ps.setString(2,"123456");
        ps.setString(3,"624113791@qq.com");
        ps.setString(4,"122345");
        int i=ps.executeUpdate();
        connection.close();
        System.out.println(i);
    }
}
