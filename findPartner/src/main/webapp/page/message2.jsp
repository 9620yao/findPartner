<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<base href="${deployName}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>留言板</title>
<link rel="stylesheet" href="assets/css/message.css">
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<link rel="stylesheet" href="assets/css/amazeui.min.css">
<link rel="stylesheet" href="assets/css/app.css">
</head>
<body>
	<header class="am-g am-g-fixed blog-fixed blog-text-center blog-header">
		<div class="am-u-sm-8 am-u-sm-centered">
			<!-- <img width="200" src="assets/i/amazeui-b.png" alt="Amaze UI Logo" /> -->
			<h2 class="am-hide-sm-only">findPartner | 校园首个交互网站</h2>
		</div>
	</header>
	<hr>
	<!-- nav start -->
	<nav class="am-g am-g-fixed blog-fixed blog-nav">
		<button
			class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only blog-button"
			data-am-collapse="{target: '#blog-collapse'}">
			<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
		</button>

		<div class="am-collapse am-topbar-collapse" id="blog-collapse">
			<ul class="am-nav am-nav-pills am-topbar-nav">
				<li class="am-active"><a href="page/lw-index.jsp">个人中心</a></li>
				<li><a href="javascript:void(0)">发现好友</a></li>
				<li><a href="page/lw-speaks.jsp">说说</a></li>
				<li><a href="page/message.jsp">留言</a></li>
				<li><a href="page/lw-img.jsp">相册</a></li>
			</ul>
			<form class="am-topbar-form am-topbar-right am-form-inline"
				role="search">
				<div class="am-form-group">
					<input type="text" class="am-form-field am-input-sm"
						placeholder="搜索">
				</div>
			</form>
		</div>
	</nav>
	<hr>
	<!-- nav end -->

	<div id="Userimag">
		<label>个人照片</label><img src="assets/i/b3.jpg" width=200px;
			height=200px;>
	</div>

	<div id="host">
		<form action="words/findWords" method="POST" id="myForm">
			<label>显示您的留言</label>
			<%-- <c:forEach var="k" items="${ws}">
				<p>${k.wcontent}</p>
			</c:forEach> --%>
			<!-- <input type=text style="display:none">input标签隐藏 -->

			<ul  id="everyLiTag">
				<c:forEach var="k" items="${ws}">
					<li style="color:blue;" class="a26">${k.wfrendid}</li>
					<li style="color:grey;" class="wdate">${k.wdate}</li>
					<%-- <li>${k.waddress}</li> --%>
					<div style="width:800px" class="wcontent">${k.wcontent}</div>
					<a class="bianji"  href="javascript:void(0)" onclick="add();" style="color:red;">编辑</a>
					<a class="fabiao" href="javascript:void(0)" " style="color:red;">发表</a>
						<ul>
							<c:forEach var="s" items="${k.comments}">
								<li style="color:blue;">${s.comuserid}</li>
								<li style="color:grey;">${s.comTime}</li>
								<textarea style="width:500px">${s.detail}</textarea>
								<a href="javascript:void(0)" onclick="add();" style="color:red;">编辑</a>
								<a href="javascript:void(0)"  style="color:red;">发表</a>
							</c:forEach>
						</ul>
						<br>
						<label>显示您的回复</label>
						<ul>
							<c:forEach var="r" items="${k.replys}">
								<li style="color:blue;">${r.ruserid}</li>
								<li style="color:grey;">${r.rtime}</li>
								<textarea id="edit" name="edit" style="width:300px;height:150px;">${r.rcontent}</textarea>
								<a href="javascript:void(0)" onclick="add();" style="color:red;">编辑</a>
								<a href="javascript:void(0)" style="color:red;">发表</a>
							</c:forEach>
						</ul>
				</c:forEach>
			</ul>
			<button type="submit" width=100px; height=40px>查看留言以及回复评论</button>
		</form>
	</div>
	<br>
	<br>
	<div id="leaveMsg">
		<label>发表留言</label>
		<textarea type="text" width=600px height=100px></textarea>
		<button type="submit">发表</button>
		<button type="reset">取消</button>
	</div>
	<br>
	<div id="comWords">
		<label>评论留言</label>
		<textarea type="text" width=600px height=100px></textarea>
		<button type="submit">发表</button>
		<button type="reset">取消</button>
	</div>
	<br>
	<div id="replyhost">
		<label>回复评论</label>
		<textarea type="text" width=600px height=100px></textarea>
		<button type="submit">发表</button>
		<button type="reset">取消</button>
	</div>
	<script src="assets/js/jquery.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="rel/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="rel/ueditor/ueditor.all.min.js"> </script>
	<script type="text/javascript" charset="utf-8" src="rel/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
	<script type="text/javascript" src="rel/js/message.js"></script>
</body>
</html>