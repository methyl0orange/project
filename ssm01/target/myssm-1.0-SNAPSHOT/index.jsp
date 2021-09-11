<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>学生系统</title>
</head>
<body>
<a href="add.jsp">添加</a>
<table>
    <tr>
        <td>id</td>
        <td>manager</td>
        <td>name</td>
        <td>pay</td>
        <td>remark</td>
        <td>operation</td>
    </tr>
    <c:forEach items="${slist}" var="student">
        <tr>
            <td>${student.id }</td>
            <td>${student.manger}</td>
            <td>${student.name}</td>
            <td>${student.pay}</td>
            <td>${student.remark}</td>
            <td><a href="delete?id=${student.id}">删除</a>&nbsp;&nbsp;<a href="selectStudentById?id=${student.id}">修改</a></td>
        </tr>

    </c:forEach>
</table>
</form>
</body>
</html>
