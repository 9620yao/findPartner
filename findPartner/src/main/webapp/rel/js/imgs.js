GetFinallyAid();// 判断是否隐藏
function GetFinallyAid() {
	$.post("friend/finalAid", function(data) {
		// alert(data);
		// alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
		// alert(data.finalaid);
		if (data.finalaid == "-1") {
			$(".myfriend").show();
			$(".updatepwd").show();// 修改密码按钮
			$(".homepage").attr("href", "page/lw-index.jsp");
			$(".homepage").val("个人中心");
			// $(".updatebtn").show();//修改个人信息按钮 index.jsp
			// $(".editdiv").show();//显示添加说说按钮 speaks.jsp
			// $("#Userimag").show();//显示用户头像 message.jsp
			$(".addimgs").show();//添加相册按钮 imgs.jsp
		} else {
			$(".myfriend").hide();
			$(".updatepwd").hide();
			$(".homepage").attr("href",
					"page/lw-index.jsp?aid=" + data.finalaid);
			$(".homepage").html("他的主页");
			// $(".updatebtn").hide();
			// $(".editdiv").hide();
			// $("#Userimag").hide();//显示用户头像 message.jsp
			$(".addimgs").hide();
		}
	}, "json")
}

//加载所有相册
function showalbum() {
	$.post("album/list", function(data) {
		// alert("请求响应成功。。"+data);
		// alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
		if (data == null || data == "") {//当用户没有相册的时候
			return false;
		}
		var album = '';
		var imgsrc = '';
		//album += '<div><img onclick="addImgs()" src="images/01.jpg"></div>'
		for (var i = 0; i < data.length; i++) {
			album += '<div><img onclick="openpic(\'' + data[i].abid
			+ '\')" src="' + ((data[i].aheader==null || data[i].aheader=="")?"images/pic-none.png":data[i].aheader) + '"><h2>'
			+ data[i].abname + '</h2></div>';
		}
		$("#container").html(album);
	}, "json");
}
showalbum();

//点击相册
function openpic(date) {
	if (date != null) {
		var url = "page/albumpic.jsp?abid=" + date;
		// window.open(url); //打开新的页面并带参数过去
		self.location = url;// 挑战页面
	}
}

//点击添加相册
function addImgs(){
	var url = "page/new-imgs.jsp";
	// window.open(url); //打开新的页面并带参数过去
	self.location = url;// 挑战页面
}