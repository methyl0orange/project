<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>车辆管理系统</title>
<link href="css/main.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>
</head>
  
<body class="content-pages-body">
<div class="content-pages-wrap">
    <div class="commonTitle"><h2>&gt;&gt; <a href="institution-list.html">车辆管理</a> - 添加车辆</h2></div>
     <form id="institutionCreat" name="institutionCreat" action="updateCar" method="post">
     <input type="hidden" name="carid" value="${car.carid }"/>
    <table border="0" cellspacing="1" cellpadding="0" class="commonTable">
        
        <tr>
         <td align="right"><span class="required">*</span>车辆名称：</td>
            <td align="left"><input name="name" type="text" class="inputTextMiddle" id="textfield" value="${car.name}"/></td>
             <td align="right"><span class="required">*</span>出厂日期：</td>
            <td align="left" colspan="3"><input name="birthday" type="text" class="inputTextMiddle" id="textfield" value="${car.birthday}"/></td>
        </tr>
        <tr>
            <td align="right"><span class="required">*</span>排量：</td>
            <td align="left"><input name="pailiang" type="text" class="inputTextMiddle" id="textfield2" value="${car.pailiang}"/></td>
            <td align="right"><span class="required">*</span>类型：</td>
            <td align="left" colspan="4">
            	<input type="radio" name="leixing" id="radio5" value="长城"  <c:if test="${car.leixing=='长城' }">checked="checked"</c:if> />长城
                <input type="radio" name="leixing" id="radio6" value="奇瑞" <c:if test="${car.leixing=='奇瑞' }">checked="checked"</c:if>/>奇瑞
                <input type="radio" name="leixing" id="radio7" value="红旗" <c:if test="${car.leixing=='红旗' }">checked="checked"</c:if>/>红旗
            </td>
        </tr>
        <tr>
            <td align="right">人数：</td>
            <td colspan="3" align="left"><input name="renshu" type="text" class="inputTextLong" id="textfield5" value="${car.renshu}"/></td>
            <td align="right">厢数：</td>
            <td align="left"><input name="jixiang" type="text" class="inputTextNormal" id="textfield4" value="${car.jixiang}"/></td>
        </tr>
        <tr>
       	     <td align="right"><span class="required">*</span>价格：</td>
            <td align="left"><input name="price" type="text" class="inputTextNormal" id="textfield6" value="${car.price}"/></td>
            <td align="right">图片：</td>
            <td align="left"><input name="imgurl" type="file" class="inputTextNormal" id="textfield6" value="${car.imgurl}"/></td>
          
        </tr>
       
       
    </table>
  
    <div id="formPageButton">
    	<ul>
        	<li><input type="submit" value="提交"/></li>
        </ul>
    </div>
   </form>
</div>
<!--//content pages wrap-->
</body>
</html>
