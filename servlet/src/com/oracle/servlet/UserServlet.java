package com.oracle.servlet;

import com.oracle.po.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list=new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/teach_data?characterEncoding=UTF-8","root","123456");
            String sql="select * from s";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                User u=new User();
                u.setSNo(rs.getString("SNo"));
                u.setSN(rs.getString("SN"));
                u.setSex(rs.getString("Sex"));
                u.setAge(rs.getInt("Age"));
                u.setDept(rs.getString("Dept"));
                list.add(u);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("ulist",list);
        req.getRequestDispatcher("userList.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
