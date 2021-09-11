<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>租车系统</title>
<link href="css/main.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>
</head>

<body class="content-pages-body">
<div class="content-pages-wrap">
	<div class="commonTitle">
	  <h2>&gt;&gt;车辆管理</h2>
	</div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="commonTableSearch">
       	<form id="form-search" name="form-search" action="carList" method="post">
        <tr>
            <th align="right">车辆名称：</th>
            <td><input  type="text" class="inputTextNormal" id="textfield63" <c:if test="${name!='null' }">value="${name }"</c:if> name="name"/></td>
            <th align="right">排量：</th>
            <td><input  type="text" class="inputTextNormal" id="textfield63" <c:if test="${pailiang!='null' }">value="${pailiang }"</c:if> name="pailiang"/></td>
            <th align="right">厢数：</th>
            <td><input  type="text" class="inputTextNormal" id="textfield63" <c:if test="${jixiang!='null' }">value="${jixiang }"</c:if> name="jixiang"/></td>
            <td align="right">&nbsp;</td>
            <td align="right"><input type="submit" value="检索"/></td>
        </tr>
       	</form>
    </table>
    <!--//commonTableSearch-->
    <div class="btnBar">
    	<ul class="clearfix">
        	<li><a href="toAddCar" title="新增车辆" class="btnNormal" target="mainiframe">新增</a></li>
        </ul>
    </div>
    <table border="0" cellspacing="1" cellpadding="0" class="commonTable">
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>类型</th>
            <th>人数</th>
            <th>价格</th>
            <th width="10%">操作</th>
        </tr>
       
       <c:forEach items="${clist }" var="car">
       
       <tr>
            <td align="center">${car.carid }</td>
            <td align="center">${car.name }</td>
            <td align="center">${car.leixing }</td>
            <td align="center">${car.renshu }</td>
            <td align="center">${car.price }</td>
            <td align="center">
            	<a href="institution-view.html" class="btnIconView" title="查看详情"></a>
            	<a href="toUpdateCar?carid=${car.carid }" class="btnIconEdit" title="更新"></a> 
            	<a href="carDelete?carid=${car.carid }&pageNo=${pageNo }&size=${size }&name=${name }&pailiang=${pailiang}&jixiang=${jixiang}" class="btnIconDel" title="删除"></a> </td>
        </tr>
        
        
       </c:forEach>
        
        
    </table>
    <!--//commonTable-->
    <div id="pagelist">
    	${str }
    </div>
</div>
<!--//content pages wrap-->
</body>
</html>
    