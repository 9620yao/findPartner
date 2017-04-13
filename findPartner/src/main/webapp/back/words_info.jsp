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
	<table id="wordsInfo"></table>
	<div id="wordsDetail">
		<form action="#" method="post">
			<p>
				<label> 留言编号</label> <input id="iwid"/>
			</p>
			
			<p>
				<label> 留言人</label> <input id="iwfrendid" />
			</p>
			<p>
				<label> 留言内容 </label>
				<div id="iwcontent" style="width: 400px; height: 100px; border: 1px solid gray; overflow: scroll;"></div>
			</p>
			
			<p>
				<label> 留言地址 </label><input id="iwaddress" />
			</p>
			<p>
				<label> 留言日期 </label><input id="iwdate" />
			</p>
		</form>
	</div>
	<script src="assets/js/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="rel/js/words_info.js"></script>
</body>
</html>