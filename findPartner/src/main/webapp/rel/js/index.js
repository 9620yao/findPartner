GetFinallyAid();
function GetFinallyAid() {
	$.post("friend/finalAid", function(data) {
		// alert(data);
		// alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
		// alert(data.finalaid);
		if (data.finalaid == "-1") {
			$("#myfriend").show();
			$(".updatepwd").show();
			$(".updatebtn").show();
			$(".homepage").attr("href", "page/lw-index.jsp");
			$(".homepage").val("个人中心");
		} else {
			$("#myfriend").hide();
			$(".updatepwd").hide();
			$(".updatebtn").hide();
			$(".homepage").attr("href",
					"page/lw-index.jsp?aid=" + data.finalaid);
			$(".homepage").html("他的主页");
		}
	}, "json")
}

var currPage = 1;
//显示个人中心--精简版
showhomepage(currPage);
function showhomepage(currPage) {
	$.post("homepage/list",
			{
		"currPage" : currPage
			},
			function(data) {
				if (data == null || data == "") {
					return false;
				}
				//alert(JSON.stringify(data)); // JSON.stringify()

				//取到编号和用户编号
				for(var i=0;i<data.rows.length;i++){
					findspeack(data.rows[i].hpid,data.rows[i].hpuseid,data.rows[i].hpdate);
					findalbumpic(data.rows[i].hpid,data.rows[i].hpuseid,data.rows[i].hpdate);
				}

				var pagination = "";
				pagination += '<label>当前第' + currPage + ' 页，共'
				+ data.totalPage + ' 页</label>';
				pagination += '<a href="javascript:void(0)" onclick="listSpeaks(1)">首页</a>';
				pagination += '<a href="javascript:void(0)" onclick="listSpeaks('
					+ (data.currPage == 1 ? 1 : (data.currPage - 1))
					+ ')">上一页</a>';
				pagination += '<a href="javascript:void(0)" onclick="listSpeaks('
					+ (data.currPage == data.totalPage ? data.currPage
							: (data.currPage + 1)) + ')">下一页</a>';
				pagination += '<a href="javascript:void(0)" onclick="listSpeaks('
					+ data.totalPage + ')">尾页</a>';
				$("#page")[0].innerHTML = pagination;
			}, "json");
}

//同步发送请求
function findspeack(sid,speakman,senddate){
	$.ajax({
		type: "POST",
		url: "speaks/hpspeaks",
		data:{"sid":sid,"speakman":speakman},
		async: false,//同步加载
		dataType: "json",
		success: function(data){
			if(data==null ||data ==""){
				//findalbumpic(sid,speakman,senddate);
				return false;
			}
			//console.info(data);
			var speaksStr = "";
			//alert(data);
			speaksStr+='<div><img style="width: 20px; height: 20px;" src="images/01.jpg">';
			speaksStr+='<a href="javascript:void(0)">'+data.speakman+'</a>';
			speaksStr+='<div class="demoEdit" contenteditable="true">'+data.content+'</div>';
			speaksStr+='<a style="margin-left: 28%;" href="javascript:void(0)">删除</a>';
			speaksStr+='<a onclick="addcom()" href="javascript:void(0)"style="margin-left: 5%;">评论</a></p>';
			speaksStr+='</div><div class="comment'+data.sid+'" style="margin-left: 5%;"><div>';
			speaksStr+='<div style="margin-top: 2%;display: none;" class="showcomment"><div class="demoEdit" contenteditable="true"></div><button onclick="closecom()">提交</button></div>';
			//alert(data[i].sid);
			comments(data.sid);//取到所有的说说编号
			//alert(speaksStr);
			$("#showspeak").append(speaksStr);
			//$("#showspeak")[0].innerHTML = speaksStr;
		}
	});
}

function comments(sid) {
	// alert(sid);
	$.post("comments/list", {
		"sid" : sid
	}, function(data) {
		if (data == null || data == "") {
			return false;
		}
		// alert(data);
		//alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
		var commentStr = "";
		for (var i = 0; i < data.length; i++) {
			commentStr += '<div><img style="width: 20px; height: 20px;" src="images/01.jpg">';
			commentStr += '<a href="javascript:void(0)">'+data[i].comuserid+'</a>';
			commentStr += '<div class="demoEdit" contenteditable="true">'+data[i].detail+'</div>';
			commentStr += '<a style="margin-left: 28%;" href="javascript:void(0)">删除</a>';
			commentStr += '<a onclick="addrep()" href="javascript:void(0)" style="margin-left: 5%;">回复</a>';
			commentStr += '</div><div class="reply'+data[i].cid+'" style="margin-left: 5%;"></div>';
			commentStr += '<div style="margin-top: 2%;display: none;" class="showreply">';
			commentStr += '<div class="demoEdit" contenteditable="true"></div>';
			commentStr += '<button onclick="closerep()">提交</button></div>';
			replys(data[i].cid);// 取到所有的评论编号
		}
		//alert($(".comment"+sid)[0].innerHTML);
		$(".comment"+sid)[0].innerHTML = commentStr;
	}, "json");
}

//根据评论编号，找到评论编号下的所有回复
function replys(cid) {
	// alert(cid);
	$.post("replys/list", {
		"cid" : cid
	}, function(data) {
		if (data == null || data == "") {
			return false;
		}
		// alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
		var replysStr = "";
		for (var i = 0; i < data.length; i++) {
			replysStr += '<div><img style="width: 20px; height: 20px;" src="images/01.jpg">';
			replysStr += '<a href="javascript:void(0)">用户名</a> 回复';
			replysStr += '<a href="javascript:void(0)">用户名</a>:';
			replysStr += '<div class="demoEdit" contenteditable="true">我是回复</div>';
			replysStr += '<a style="margin-left: 28%;" href="javascript:void(0)">删除</a>';
			replysStr += '<a onclick="addrep()" href="javascript:void(0)" style="margin-left: 5%;">回复</a></div>';
		}
		$(".reply"+cid)[0].innerHTML = replysStr;

	}, "json");
}

function findalbumpic(abid,speakman,apicdate){
	$.ajax({
		type: "POST",
		url: "albumpic/hpalbumpic",
		data:{"abid":abid,"apicdate":apicdate},
		async: false,//同步加载
		dataType: "json",
		success: function(data){
			if(data==null ||data ==""){
				//findspeack(abid,speakman,apicdate);
				return false;
			}
			//alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
			var imgpic = "";
			imgpic+='<div><img style="width: 20px; height: 20px;" src="images/01.jpg">';
			imgpic+='<a href="javascript:void(0)">用户名：</a>';
			imgpic+='<br><span style="margin-left: 5%;">'+data.apicdate+'</span>';
			imgpic+='<div id="imgs" class="imgs">';
			imgpic+='<img src="'+data.apic+'">';
			imgpic+='</div><p style="margin-left: 3%;">上传图片到《';
			imgpic+='<a  href="javascript:void(0)">相册'+data.abid+'</a>》</p></div>';
			$("#showspeak").append(imgpic);
		}
	});
}


UE.getEditor('fdesc');
function myadd() {
	alert(1111);
}

//点击提交的时候
function addSpeak() {
	alert(1111);
}

function loadAdminInfo() {
	// 以异步的方式取到个人的信息
	$.get("user/getByid", function(data) {
		// alert("请求响应成功。。"+data);
		// alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串

		showUserInfo(data);
		showUser(data);
	}, "json");
}
loadAdminInfo();

//显示个人信息
function showUserInfo(data) {
	$("#pictrue").val("");
	if (data.picture) {
		$(".pic").attr("src", data.picture);
	} else {
		$(".pic").attr("src", "images/not_pic.jpg");
	}
	$("#inickname").append(data.nickname);
	$("#iage").append(data.age);
	$("#ibirthday").append(data.birthday);
	$("#igender").append(data.partner.gender);
	$("#istar").append(data.star);
	$("#ihobby").append(data.hobby);
	$("#ijob").append(data.job);
	$("#icompany").append(data.company);
	$("#ischool").append(data.school);
	$("#iastate").append(data.astate);
	$("#iaddress").append(data.address);
	$("#ihometown").append(data.hometown);
	$("#iastate").append(data.astate);
}

//显示个人信息
function showUser(data) {
	$("#pictrue").val("");
	if (data.picture) {
		$(".pic").attr("src", data.picture);
	} else {
		$(".pic").attr("src", "images/not_pic.jpg");
	}
	// alert(data.aid)
	$("#aid").val(data.aid);
	$("#nickname").val(data.nickname);
	$("#age").val(data.age);
	$("#birthday").val(data.birthday);
	$("#gender").val(data.partner.gender);
	$("#star").val(data.star);
	$("#hobby").val(data.hobby);
	$("#job").val(data.job);
	$("#company").val(data.company);
	$("#school").val(data.school);
	$("#astate").val(data.astate);
	$("#address").val(data.address);
	$("#hometown").val(data.hometown);
	$("#astate").val(data.astate);
}

$('#addInfo').dialog({
	width : 380,
	height : 500,
	left : 500,
	top : 300,
	title : '',
	border : false,
	modal : true
});

$("#addInfo").dialog("close", true);

function add() {
	$("#aid").hide();
	$("#addInfo").dialog("open", true);
}

function addWinClose() {
	$("#addInfo").dialog("close", true);
	return false;
}

$(".updateBtn").linkbutton({
	iconCls : "icon-ok",
	onClick : function() {
		$("#updateUserInfo").submit();
	}
});

$("#updateUserInfo").form(
		{
			url : "user/update",
			success : function(data) {
				// alert(JSON.stringify(data));
				if (data == "") {
					$.messager.alert('用户修改主', '当前用户没有修改用户的权限 ！', 'warning');
					$("#addInfo").dialog("close"); // 关闭修改框
					return;
				}

				if (data.trim() == "true") {
					$("#addInfo").dialog("close"); // 关闭修改框
					loadAdminInfo();
				} else {
					$.messager.show({
						title : '修改信息',
						msg : '修改失败！！！',
						showType : 'show',
						style : {
							top : document.body.scrollTop
							+ document.documentElement.scrollTop,
						}
					});
				}
			}
		});
function chgPic(obj) {
	$(".pic").attr("src", window.URL.createObjectURL(obj.files[0]));
}

$(function() {
	$("#head li a").on("click", function() {
		$("#head li a").css("background-color", "white");
		$(this).css("background-color", "green");
	})
});

//进入index界面的时候
//$(".showreply").hide();
//$(".showcomment").hide();

///////////////////
function closecom() {
	$(".showcomment").hide();
}
function addcom() {
	$(".showcomment").show();
}

function closerep() {
	$(".showreply").hide();
}
function addrep() {
	$(".showreply").show();
}
