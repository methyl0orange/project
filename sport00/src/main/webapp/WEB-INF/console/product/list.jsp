<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>babasport-list</title>
<script type="text/javascript">
//上架
function isShow1(){
	//请至少选择一个
	var size = $("input[name='ids']:checked").size();
	if(size == 0){
		alert("请至少选择一个");
		return;
	}
	//你确定删除吗
	if(!confirm("你确定上架吗")){
		return;
	}
	//提交 Form表单
	$("#jvForm").attr("action","updateProducts1.do");
	$("#jvForm").attr("method","post");
	$("#jvForm").submit();
	
}
//上架
function isShow0(){
	//请至少选择一个
	var size = $("input[name='ids']:checked").size();
	if(size == 0){
		alert("请至少选择一个");
		return;
	}
	//你确定删除吗
	if(!confirm("你确定下架吗")){
		return;
	}
	//提交 Form表单
	$("#jvForm").attr("action","updateProducts0.do");
	$("#jvForm").attr("method","post");
	$("#jvForm").submit();
	
}
//去修改页面
    function toUpdatePage(id,pageNo,pageSize){
	    
	     window.location.href="toUpdatePage.do?id="+id+"&amp;pageNo="+pageNum+"&amp;size="+pageSize;
	
    }
    //批量删除
    function optDelete(){
    	var size = $("input[name='ids']:checked").size();
    	if(size == 0){
    		alert("请至少选择一个");
    		return;
    	}
    	//你确定删除吗
    	if(confirm("你确定删除吗？")){
    		$('#jvForm').attr("action","deleteProducts.do").submit();
    	}
    }
</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 商品管理 - 列表</div>
	<form class="ropt">
		<input class="add" type="button" value="添加" onclick="window.location.href='toProductAdd.do'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<form action="productList.do?pageSize=8&pageNo=1" method="post" style="padding-top:5px;">
名称: <input type="text" name="name" value="${product.name }"/>
	<select name="brandId">
		<option value="">请选择品牌</option>
		<c:forEach items="${brandList }" var="brand" >
		    <option value="${brand.id }" <c:if test="${product.brandId==brand.id }"> selected="selected"</c:if>>${brand.name }</option>
		</c:forEach>
		
	</select>
	<select name="isShow">
	    <option value="1">请选择</option>
		<option value="1" <c:if test="${product.isShow==1 }"> selected="selected"</c:if>>上架</option>
		<option value="0" <c:if test="${product.isShow==0 }"> selected="selected"</c:if>>下架</option>
	</select>
	<input type="submit" class="query" value="查询"/>
</form>
<form id="jvForm">
<table cellspacing="1" cellpadding="0" width="100%" border="0" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onclick="Pn.checkbox('ids',this.checked)"/></th>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>图片</th>
			<th width="4%">新品</th>
			<th width="4%">热卖</th>
			<th width="4%">推荐</th>
			<th width="4%">上下架</th>
			<th width="12%">操作选项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
	    <c:forEach items="${page.list }" var="product">
		<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
			<td><input type="checkbox" name="ids" class="ids" value="${product.id }"/></td>
			<td>${product.id }</td>
			<td align="center">${product.name }</td>
			<td align="center"><img width="50" height="50" src="${product.imgUrl }"/></td>
			<td align="center"><c:if test="${product.isNew}">是</c:if><c:if test="${!product.isNew}">否</c:if></td>
			<td align="center"><c:if test="${product.isHot}">是</c:if><c:if test="${!product.isHot}">否</c:if></td>
			<td align="center"><c:if test="${product.isCommend}">是</c:if><c:if test="${!product.isCommend}">否</c:if></td>
			<td align="center"><c:if test="${product.isShow}">上架</c:if><c:if test="${!product.isShow}">下架</c:if></td>
			<td align="center">
			<a href="#" class="pn-opt">查看</a> | <a href="javascript:;" class="pn-opt" onclick="toUpdatePage(${product.id },${page.pageNum},${page.pageSize })">修改</a> | <a href="javascript:;" onclick="if(confirm('您确定删除吗？')) {window.location.href='deleteProduct.do?id=${product.id}&pageNo=${page.pageNum}&size=${page.pageSize }'}" class="pn-opt">删除</a> | <a href="javascript:;" onclick="window.location.href='skuList.do'" class="pn-opt">库存</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
	<div class="page pb15">
	<span class="r inb_a page_b">
		<a class="page-link" href="productList.do?pageNo=1&pageSize=8">首页</a>
		<a <c:if test="${!page.isFirstPage}">href="productList.do?pageNo=${page.prePage}&pageSize=8" </c:if>>上一页</a>
		<a>${page.pageNum}</a>
		<a <c:if test="${page.hasNextPage}">href="productList.do?pageNo=${page.nextPage}&pageSize=8" </c:if>>${page.pageNum+1}</a>
        <a <c:if test="${!page.isLastPage}">href="productList.do?pageNo=${page.nextPage}&pageSize=8" </c:if>>下一页</a>
		<a class="page-link" href="productList.do?pageNo=${page.pages}&pageSize=8">尾页</a>
		<a>共${page.pages}页</a>
	</span>
	</div>
<div style="margin-top:15px;"><input class="del-button" type="button" value="删除" onclick="optDelete();"/><input class="add" type="button" value="上架" onclick="isShow1();"/><input class="del-button" type="button" value="下架" onclick="isShow0();"/></div>
</form>
</div>

</body>
</html>