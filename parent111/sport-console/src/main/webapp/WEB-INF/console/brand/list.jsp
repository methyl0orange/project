<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>品牌信息</title>

<script>
    function optDelete(){
    	
    	var i = $("input[type=checkbox][name=ids][checked=true]").size();
                     
    	 if(true){
    		if(confirm("您确定删除吗？")){
	    		$('#jvFormDel').submit();
	    	}
    	 }else{
    		alert("至少选择一项");
    	} 
    }
    
</script>

</head>		
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 品牌管理 - 列表</div>
	<form class="ropt">
		<input class="add" type="button" value="添加" onclick="javascript:window.location.href='toBrandAdd.do'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<form action="brandList.do" method="post" style="padding-top:5px;">
品牌名称: <input type="text" name="name" value="${name}"/>
	<select name="isDisplay">
		<option value="1" <c:if test="${isDisplay==1}">selected="checked"</c:if>>是</option>
		<option value="0" <c:if test="${isDisplay==0}">selected="checked" </c:if>>否</option>
	</select>
	<input type="submit" class="query" value="查询"/>
</form>
<form action="deleteBrands.do" method="post" id="jvFormDel">
<table cellspacing="1" cellpadding="0" border="0" width="100%" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onclick="Pn.checkbox('ids',this.checked)"/></th>
			<th>品牌ID</th>
			<th>品牌名称</th>
			<th>品牌图片</th> 
			<th>品牌描述</th>
			<th>排序</th>
			<th>是否可用</th>
			<th>操作选项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
	    <c:forEach items="${pagination.list }" var="brand">
	        <tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="${brand.id }" name="ids"/></td>
			<td align="center">${brand.id }</td>
			<td align="center">${brand.name }</td>
			<td align="center"><img width="40" height="40" src="${brand.imgUrl }"/></td>
			<td align="center">${brand.description }</td>
			<td align="center">${brand.sort }</td>
			<td align="center" ><c:if test="${brand.isDisplay}">是</c:if><c:if test="${!brand.isDisplay}">否</c:if></td>
			<td align="center">
			<a class="pn-opt" href="#">修改</a>  
			<c:if test="${brand.isDisplay}">
			| <a class="pn-opt" onclick="if(confirm('您确定删除吗？')) {window.location.href='deleteBrand.do?id=${brand.id}&name=${name }&isDisplay=${isDisplay }&pageNo=${pagination.pageNo }&pageSize=3';}" href="#">删除</a>
			</c:if>
			</td>
		</tr>
	    </c:forEach>

	</tbody>
</table>
<input type="hidden" value="${name }"  name="name" />
<input type="hidden" value="${isDisplay }"  name="isDisplay" />
<input type="hidden" value="${pagination.pageNo }"  name="pageNo" />
<input type="hidden" value="${pagination.pageSize }"  name="pageSize" />
</form>
<div class="page pb15">
	<span class="r inb_a page_b">
	  <c:forEach items="${pagination.pageView }" var="p">
	      ${p }
	  </c:forEach>
	</span>
</div>
<div style="margin-top:15px;"><input class="del-button" type="button" value="删除" onclick="optDelete();"/></div>
</div>
</body>
</html>