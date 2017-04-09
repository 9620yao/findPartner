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
			<ul class="am-nav am-nav-pills am-topbar-nav" id="head">
				<li class="am-active"><a class="homepage" href="page/lw-index.jsp">个人中心</a></li>
				<li><a class="myfriend" href="page/lw-friend.jsp">我的好友</a></li>
				<!-- <li><a href="page/message.jsp">日志</a></li> -->
				<li><a href="page/lw-speaks.jsp">说说</a></li>
				<li><a href="page/message.jsp">留言</a></li>
				<li><a href="page/lw-img.jsp">相册</a></li>
				<li><a class="updatepwd" href="page/lw-modifyPwd.jsp">修改密码</a></li>
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

	<div id="Userimag" style="margin-left: 7%">
		<label>个人照片</label>
		<p>
			<img src="assets/i/b3.jpg" width=100px; height=100px;>
		</p>
	</div>

	<!-- hostAll start -->
	<div id="hostAll" style="margin-top: 3%;">
		<!-- <hr>
		<div id="host">
			<div class="showwords">
				<ul id="everyLiTag">
					<li style="color: blue;" class="aaa26">用户头像</li>
					<li style="color: blue;" class="name">好友编号</li>
					<li style="color: grey;" class="wdate">留言时间</li>
					<li><span>留言内容</span></li>
				</ul>
			</div>
			<div class="showcomment">
				<ul class="pinglun">
					<li style="color: blue;" class="aaa29"></li>
					<li style="color: blue;" class="a29name">评论编号</li>
					<li style="color: grey;" class="wdate" id='aa29'>评论时间</li>
					<li><span class="wcontenta29">评论内容</span></li>
					<textarea class="wcontenta29">评论内容</textarea>
				</ul>
			</div>
			<div class="showreplys">
				<ul class="huifu">
					<li style="color: blue;" class="huiaa26"></li>
					<li style="color: blue;" class="huiaa26name">回复编号</li>
					<li style="color: grey;" class="huiaa26wdate">回复时间</li>
					<textarea id="edit" name="edit" class="huiaa26edit">回复内容</textarea>
				</ul>
			</div>
		</div> -->
		<a class="huibianjia26" href="javascript:void(0)" onclick="add();"
			style="color: black; margin-left: 20%;">评论</a>
	</div>
	<div id="page"></div>
	<!-- hostAll end -->


	<!-- <div id="leaveMsg">
		<label style="color: #9c9c9c">发表留言</label>
		<textarea type="text" style="width: 500px"></textarea>
		<button type="submit" class="fabiao-btn">发表</button>
		<button type="reset" class="quxiao_btn">取消</button>
	</div>
	<br>
	<div id="comWords">
		<label style="color: #9c9c9c">评论留言</label>
		<textarea type="text" style="width: 500px"></textarea>
		<button type="submit" class="fabiao-btn">发表</button>
		<button type="reset" class="quxiao_btn">取消</button>
	</div>
	<br>
	<div id="replyhost">
		<label style="color: #9c9c9c">回复评论</label>
		<textarea type="text" style="width: 500px"></textarea>
		<button type="submit" class="fabiao-btn">发表</button>
		<button type="reset" class="quxiao_btn">取消</button>
	</div> -->

	<footer class="blog-footer">
		<div
			class="am-g am-g-fixed blog-fixed am-u-sm-centered blog-footer-padding">
			<div class="am-u-sm-12 am-u-md-4- am-u-lg-4">
				<h3>模板简介</h3>
				<p class="am-text-sm">
					这是一个使用amazeUI做的简单的前端模板。<br> 博客/ 资讯类 前端模板 <br>
					支持响应式，多种布局，包括主页、文章页、媒体页、分类页等<br>嗯嗯嗯，不知道说啥了。外面的世界真精彩<br> <br>
					Amaze UI 使用 MIT 许可证发布，用户可以自由使用、复制、修改、合并、出版发行、散布、再授权及贩售 Amaze UI
					及其副本。
				</p>
			</div>
			<div class="am-u-sm-12 am-u-md-4- am-u-lg-4">
				<h3>社交账号</h3>
				<p>
					<a href=""><span
						class="am-icon-qq am-icon-fw am-primary blog-icon blog-icon"></span></a>
					<a href=""><span
						class="am-icon-github am-icon-fw blog-icon blog-icon"></span></a> <a
						href=""><span
						class="am-icon-weibo am-icon-fw blog-icon blog-icon"></span></a> <a
						href=""><span
						class="am-icon-reddit am-icon-fw blog-icon blog-icon"></span></a> <a
						href=""><span
						class="am-icon-weixin am-icon-fw blog-icon blog-icon"></span></a>
				</p>
				<h3>Credits</h3>
				<p>我们追求卓越，然时间、经验、能力有限。Amaze UI
					有很多不足的地方，希望大家包容、不吝赐教，给我们提意见、建议。感谢你们！</p>
			</div>
			<div class="am-u-sm-12 am-u-md-4- am-u-lg-4">
				<h1>我们站在巨人的肩膀上</h1>
				<h3>Heroes</h3>
				<p>
					<ul>
					<li>jQuery</li>
					<li>Zepto.js</li>
					<li>Seajs</li>
					<li>LESS</li>
					<li>...</li>
				</ul>
				</p>
			</div>
		</div>
		<div class="blog-text-center">© 2015 AllMobilize, Inc. Licensed
			under MIT license. Made with love By LWXYFER</div>
	</footer>
	
	<script src="assets/js/jquery.min.js"></script>
					<script type="text/javascript" charset="utf-8"
						src="rel/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8"
						src="rel/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" charset="utf-8"
						src="rel/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
	<script type="text/javascript" src="rel/js/message.js"></script>

				</body>
</html>