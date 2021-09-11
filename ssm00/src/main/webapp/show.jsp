<%--
  Created by IntelliJ IDEA.
  User: 吴新成
  Date: 2021/6/19
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>共青团收费管理系统</title>
</head>
<body>
<a href="add.jsp">添加</a>
<table>
    <tr>
        <td>编号</td>
        <td>团支部</td>
        <td>姓名</td>
        <td>团费</td>
        <td>身份</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${slist}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.manger}</td>
            <td>${student.name}</td>
            <td>${student.pay}</td>
            <td>${student.remark}</td>
            <td><a href="delete?id=${student.id}">删除</a> &nbsp;&nbsp;<a href="selectStudentById?id=${student.id}">修改</a> </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
