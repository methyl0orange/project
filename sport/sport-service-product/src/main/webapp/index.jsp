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
    <c:forEach items="${blist}" var="brand">
        <tr>
            <td>${brand.id}</td>
            <td>${brand.name}</td>
            <td>${brand.description}</td>
            <td>${brand.imgUrl}</td>
            <td>${brand.webSite}</td>
            <td><a href="delete?id=${brand.id}">删除</a>&nbsp;&nbsp;<a href="selectBrands?id=${brand.id}">修改</a></td>
        </tr>

    </c:forEach>
</table>
</form>
</body>
</html>