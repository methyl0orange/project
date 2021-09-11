package com.oracle.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受数据
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        //去数据库比较
        System.out.println(username+"   "+password);
        if("admin".equals(username)&&"123".equals(password)){
            req.getSession().setAttribute("username",username);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
        //跳转页面

    }
}
