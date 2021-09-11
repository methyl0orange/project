<%@ page import="com.oracle.po.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 吴新成
  Date: 2021/5/23
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
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
%>
<a href="#">add</a>
<table>
    <tr>
        <th>SNo</th>
        <th>SN</th>
        <th>Sex</th>
        <th>Age</th>
        <th>Dept</th>
        <th>operation</th>
    </tr>
<%
    for(User user:list){
        %>
        <tr>
            <td><%=user.getSNo()%></td>
            <td><%=user.getSN()%></td>
            <td><%=user.getSex()%></td>
            <td><%=user.getAge()%></td>
            <td><%=user.getDept()%></td>
            <td><a href="deleteUser?SNo=<%=user.getSNo()%>">delete</a>&nbsp;&nbsp;&nbsp;<a href="updateUser">change</a></td>
        </tr>
        <%
    }
%>
</table>
</body>
</html>
