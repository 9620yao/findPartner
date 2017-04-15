<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployName }">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>image | Amaze UI Examples</title>
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<meta name="mobile-web-app-capable" content="yes">
<link rel="icon" sizes="192x192" href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png">
<meta name="msapplication-TileImage"
	content="assets/i/app-icon72x72@2x.png">
<meta name="msapplication-TileColor" content="#0e90d2">
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet"
	href="easyui/themes/default/easyui.css">
<link rel="stylesheet" href="assets/css/amazeui.min.css">
<link rel="stylesheet" href="assets/css/app.css">
</head>

<body id="blog-article-sidebar">
	<!-- header start -->
	<header class="am-g am-g-fixed blog-fixed blog-text-center blog-header">
		<div class="am-u-sm-8 am-u-sm-centered">
			<img width="200" src="assets/i/amazeui-b.png" alt="Amaze UI Logo" />
			<h2 class="am-hide-sm-only">中国首个开源 HTML5 跨屏前端框架</h2>
		</div>
	</header>
	<!-- header end -->
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
				<li class="am-active"><a class="homepage"
					href="page/lw-index.jsp">个人中心</a></li>
				<li id="myfriend" class="am-dropdown" data-am-dropdown><a
					class="am-dropdown-toggle" data-am-dropdown-toggle
					href="javascript:;">好友信息 <span class="am-icon-caret-down"></span>
				</a>
					<ul class="am-dropdown-content">
						<li><a href="page/lw-friend.jsp">我的好友</a></li>
						<li><a href="page/lw-findFriend.jsp">添加好友</a></li>
					</ul></li>
				<li><a href="page/lw-speaks.jsp">说说</a></li>
				<li><a href="page/message.jsp">留言</a></li>
				<li><a href="page/lw-img.jsp">相册</a></li>
				<li><a class="updatepwd" href="page/lw-modifyPwd.jsp">修改密码</a></li>
			</ul>
			<form class="am-topbar-form am-topbar-right am-form-inline"
				id="findFriendForm" role="search" method="POST">
				<div class="am-form-group">
					<input type="text" class="am-form-field am-input-sm" id="aid"
						name="aid" placeholder="请输入对方账号">
					<button>查找</button>
				</div>
			</form>
		</div>
	</nav>
	<!-- nav end -->
	<hr>
	<!-- content srart -->
	<a href="javascript:void(0)" style="margin-left: 100px; color: red;" onclick="friendIntro()">系统推荐好友</a><br/>
	<a href="javascript:void(0)" style="margin-left: 100px; color: red;" onclick="friendReq()">好友请求</a>
	<div style="margin-left: 400px;">
		<!-- 推荐好友 -->
		
		<div id="friend" style="width:500px;height:800px;">
			<!-- <div class="testdiv" style="float:left;"><img src="images/not_pic.jpg" style="border:none;"></div><div style="float:left;margin-left:5px;"><h3>昵称：aa</h3>
			<span>现居地：湖南长沙</span><br><a href="javascript:void(0)" onclick="addFriend(\''+data[i].aid+'\')" style="color:red;">添加</a><a href="javascript:void(0)" style="color:green;margin-left:8px;">取消</a></div> -->
		</div>
	</div>
	<!-- content end -->
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


	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="assets/js/jquery.min.js"></script>
	<!--<![endif]-->
	<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/pinto.min.js"></script>
	<script src="assets/js/img.js"></script>
	<script type="text/javascript" src="rel/js/findFriends.js"></script>
</body>
</html>
