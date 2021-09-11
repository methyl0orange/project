<%--
  Created by IntelliJ IDEA.
  User: 吴新成
  Date: 2021/6/20
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
   <form action="update" method="post">
       <input type="text" name="id" value="${Student.id}">
       <input type="text" name="manger" value="${Student.manger}">
       <input type="text" name="name" value="${Student.name}">
       <input type="text" name="pay" value="${Student.pay}">
       <input type="text" name="remark" value="${Student.remark}">
       <input type="submit" value="提交">
   </form>

</body>
</html>
