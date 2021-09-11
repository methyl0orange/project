<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 吴新成
  Date: 2021/5/21
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  JSP-java server page
  <%=((List)request.getAttribute("list")).size()%><!--输出-->
  <%!int a=20;
     String s="asd";
     public void test(){}
     %><!--定义变量，方法-->
   <%=a%>>

  <%
     int b=50;
     if(b>60){
       %>
      <%="及格"%>
      <%
     }else {
      %>
      <%="不及格"%>
      <%
     }
  %>
  <!--java-->
  </body>
</html>
