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

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String s=req.getParameter("keyword");
        //System.out.println(s);
        //String ss=String.valueOf(req.getAttribute("keyword"));
        //System.out.println(ss);
        //req.setAttribute("keyword","我是中国人");
        //String sss=String.valueOf(req.getAttribute("keyword"));
        //System.out.println(sss);
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
        resp.setCharacterEncoding("gbk");
        PrintWriter pw=resp.getWriter();
        String table="<table border='1'><tr><td>学号</td><td>姓名</td><td>性别</td><td>年龄</td><td>院系</td><td>操作</td></tr>";
        for(User user:list){
            table+="<tr><td>"+user.getSNo()+"</td><td>"+user.getSN()+"</td><td>"+user.getSex()+"</td><td>"+user.getAge()+"</td><td>"+user.getDept()+"</td><td><a href='delete?SNo="+user.getSNo()+"'>删除</a></td></tr>";
        }
        table+="</table>";
        pw.write(table);
        pw.flush();
        pw.close();
    }
}
