GetFinallyAid();//判断是否隐藏
function GetFinallyAid(){
	$.post("friend/finalAid",function(data){
		//alert(data);
		//alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		//alert(data.finalaid);
		if(data.finalaid=="-1"){
			$("#myfriend").show();
			$(".updatepwd").show();//修改密码按钮
			$(".homepage").attr("href","page/lw-index.jsp");
			$(".homepage").val("个人中心");
			$("#divword").hide();//显示留言添加按钮	message.jsp
		}else{
			$("#myfriend").hide();
			$(".updatepwd").hide();
			$(".homepage").attr("href","page/lw-index.jsp?aid="+data.finalaid);
			$(".homepage").html("他的主页");
			//$(".updatebtn").hide();
			//$(".editdiv").hide();
			$("#divword").show();//隐藏留言添加按钮	message.jsp
			
		}
	},"json")
}

var currPage = 1;
listWords(currPage);
function listWords(currPage){
	$.post("words/list",{"currPage":currPage}, function(data){
		// alert(data);
		// alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
		//alert(JSON.stringify(data.rows));
		var wordsStr = "";
		for (var i = 0; i < data.rows.length; i++) {
			wordsStr+='<div style="margin-left: 2%;margin-top: 3%;">';
			wordsStr+='<img onclick="showuser(\''+data.rows[i].wfrendid+'\')" style="width: 20px; height: 20px;" src="images/timg.jpg"  class="picSize" />';
			wordsStr+='<a onclick="showuser(\''+data.rows[i].wfrendid+'\')" class="uname'+data.rows[i].wfrendid+'" href="javascript:void(0)">'+data.rows[i].wfrendid+'</a>';
			wordsStr+='<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'+data.rows[i].wcontent+'</div>';
			wordsStr+='<span style="color: grey;margin-left: 5%;" class="wdate">'+data.rows[i].wdate+'</span>';
			wordsStr+='<a class="name" onclick="addcomment(\''+data.rows[i].wid+'\')" href="javascript:void(0)" style="margin-left: 5%;" data-toggle="modal" data-target="#addcoment">评论</a>';
			wordsStr+='<div style="margin-left: 7%;margin-top: 3%;" class="showcomment'+data.rows[i].wid+'"></div><hr style="border:1 dotted" id="link"></div>';
			// alert(data.rows[i].wid);
			comments(data.rows[i].wid);//取到所有的说说编号
			openPicture(''+data.rows[i].wfrendid+'');
		}
		//alert(wordsStr);
		$("#hostAll")[0].innerHTML = wordsStr;
		var pagination="";
		pagination+='<label>每页5条，当前第'+currPage+' 页，共'+data.totalPage+' 页</label>';
		pagination+='<a href="javascript:void(0)" onclick="listWords(1)">首页</a>';
		pagination+='<a href="javascript:void(0)" onclick="listWords('+(data.currPage==1?1:(data.currPage-1))+')">上一页</a>';
		pagination+='<a href="javascript:void(0)" onclick="listWords('+(data.currPage==data.totalPage?data.currPage:(data.currPage+1))+')">下一页</a>';
		pagination+='<a href="javascript:void(0)" onclick="listWords('+data.totalPage+')">尾页</a>';
		$("#page")[0].innerHTML = pagination;
	}, "json");
}
//根据说说编号去查说说下的评论
function comments(sid){
	//alert(sid);
	$.post("comments/list",{"sid":sid}, function(data){
		if(data==null || data==""){
			return false;
		}
		//alert(data);
		//alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		var commentStr = "";
		for (var i = 0; i < data.length; i++) {
			commentStr+='<div><img onclick="showuser(\''+data[i].comuserid+'\')" class="uPic'+data[i].comuserid+'" style="width: 20px; height: 20px;" src="images/timg.jpg">';
			commentStr+= '<a onclick="showuser(\''+data[i].comuserid+'\')" class="uname'+data[i].comuserid+'" href="javascript:void(0)">'+data[i].comuserid+'</a>';
			commentStr+='<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'+data[i].detail+'</div>';
			commentStr+='<span style="color: grey;" class="commTime" id="commTime">'+data[i].comTime+'</span>';
			commentStr+='<a class="name" onclick="addcr(\''+data[i].cid+'\',\''+data[i].comuserid+'\')" href="javascript:void(0)" style="margin-left: 5%;" data-toggle="modal" data-target="#addreply">&nbsp;回复</a>';
			commentStr+='<div style="margin-left: 7%;margin-top: 3%;" class="showreplys'+data[i].cid+'"></div></div>';
			replys(data[i].cid);//取到所有的评论编号
			//alert(data[i].cid);
			openPicture(''+data[i].comuserid+'');
		}
		$(".showcomment"+sid)[0].innerHTML = commentStr;
	}, "json");
}

//根据评论编号，找到评论编号下的所有回复
function replys(cid){
	//alert(cid);
	$.post("replys/list",{"cid":cid}, function(data){
		if(data==null || data==""){
			return false;
		}
		//alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		var replysStr = "";
		for (var i = 0; i < data.length; i++) {
			replysStr += '<div><img onclick="showuser(\''+data[i].ruserid+'\')" class="uPic'+data[i].ruserid+'" style="width: 20px; height: 20px;" src="images/timg.jpg">';
			replysStr += '<a onclick="showuser(\''+data[i].ruserid+'\')" class="uname'+data[i].ruserid+'" href="javascript:void(0)">'+data[i].ruserid+'</a> 回复';
			replysStr +='<span style="color: #CC8F14;" class="commId name">'+data[i].rtargetid+'</span>&nbsp;:<br>';
			replysStr += '<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'+data[i].rcontent+'</div>';
			replysStr +='<span style="color: grey;" class="replayTime">'+data[i].rtime+'</span>';
			replysStr += '<a onclick="addreplys(\''+data[i].rid+'\',\''+data[i].ruserid+'\')"  href="javascript:void(0)" style="margin-left: 5%;"  data-toggle="modal"';
			replysStr += ' data-target="#addreply">回复</a></div>';
			
			replys(data[i].rid);
			openPicture(''+data[i].ruserid+'');
		}
		$(".showreplys"+cid)[0].innerHTML = replysStr;
		
	}, "json");
}


var ue = UE.getEditor('ueditor');
//添加留言点击提交
function addword() {
	// alert(ue.getContentTxt());
	$("#wcontent").val(ue.getContentTxt());
	$("#myword").submit();
}
//点击评论
function addcomment(obj){
	//alert(obj);
	//$(".callid").attr("value",sid);
	$(".callid").attr("value",obj);
}

//点击提交
function Getdetail(){
	var text = $(".democomment").text();
	//alert(text);
	$(".detail").attr("value",text);
	$("#faddcomment").submit();
}

//点击评论的回复
function addcr(cid,comuserid){
	//alert(JSON.stringify(obj)); //JSON.stringify() ,把json对象转换成json字符串
	$(".rcid").val(cid);
	$(".rtargetid").val(comuserid);
}

//点击回复的回复
function addreplys(rid,ruserid){
	//alert(JSON.stringify(obj)); //JSON.stringify() ,把json对象转换成json字符串
	$(".rcid").val(rid);
	$(".rtargetid").val(ruserid);
}

function Getrcontent(){
	var text = $(".democomment").text();
	//alert(text);
	$(".rcontent").val(text);
	$("#rform").submit();
}

//获取用户头像，昵称
function openPicture(aid){
	//alert(date);
	$.post("user/aid",{"aid":aid},function(data){
		if(data==null||data==""){
			return false;
		}
		//alert(JSON.stringify(data));
		//alert($(".uname"+data.aid).val(data.nickname));
		$(".uPic"+data.aid).attr("src",data.picture==null||data.picture==""?"images/timg.jpg":data.picture);
		$(".uname"+data.aid).html(data.nickname);
	},"JSON")
}

//点击用户头像 用户昵称 进入他的主页
function showuser(date){
	if (date != null) {
		var url = "page/lw-index.jsp?aid=" + date;
		// window.open(url); //打开新的页面并带参数过去
		window.open(url);
	}
}