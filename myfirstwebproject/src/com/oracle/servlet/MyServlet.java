package com.oracle.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String repassword=req.getParameter("repassword");
        String email=req.getParameter("email");
        String telephone=req.getParameter("telephone");
        boolean result=false;
        if(password.equals(repassword)){
            Connection connection=null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/teach_data?characterEncoding=UTF-8","root","123456");
                String sql="insert into user(username,password,email,telephone) values (?,?,?,?)";
                PreparedStatement ps=connection.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,password);
                ps.setString(3,email);
                ps.setString(4,telephone);
                int i=ps.executeUpdate();
                if(i>0){
                    result=true;
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        if(result){
            req.getRequestDispatcher("success.html").forward(req,resp);
        }else {
            req.getRequestDispatcher("error.html").forward(req,resp);
        }
    }
}
