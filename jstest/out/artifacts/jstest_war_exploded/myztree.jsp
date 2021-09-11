
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<HTML>
<HEAD>
	<TITLE> ZTREE DEMO - Standard Data </TITLE>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/demo.css" type="text/css">
	<link rel="stylesheet" href="css/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="jquery-1.11.3.js"></script>
	<script type="text/javascript" src="js/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="js/jquery.ztree.excheck.js"></script>
	<script type="text/javascript" src="js/jquery.ztree.exedit.js"></script>
	<SCRIPT type="text/javascript">

		var setting = {	};
		console.log('${sessionScope.str}' );
		var zNodes = eval('${sessionScope.str}');



		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});

	</SCRIPT>
</HEAD>

<BODY>
<h1>最简单的树 -- 标准 JSON 数据</h1>
<h6>[ 文件路径: core/standardData.html ]</h6>
<div class="content_wrap">
	<div class="zTreeDemoBackground left">
		<ul id="treeDemo" class="ztree"></ul>
	</div>

</div>
</BODY>
</HTML>