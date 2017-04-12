<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployName }">
<meta charset="UTF-8">
<title>说说管理</title>
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet"
	href="easyui/themes/default/easyui.css">
</head>
<body>
	<table id="speaksInfo"></table>
	<div id="speaksDetail">
		<form action="#" method="post">
			<p>
				<label> 编号</label> <input id="isid"/>
			</p>
			
			<p>
				<label> 说说发表人 </label> <input id="ispeakman" />
			</p>
			<p>
				<label> 内容 </label>
				<div id="icontent" style="width: 700px; height: 200px; border: 1px solid gray; overflow: scroll;"></div>
			</p>
			
			<p>
				<label> 上传文件 </label><input id="ifiles" />
			</p>
			<p>
				<label> 日期 </label><input id="isenddate" />
			</p>
		</form>
	</div>
	<script src="assets/js/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="rel/js/speaks_info.js"></script>
</body>
</html>