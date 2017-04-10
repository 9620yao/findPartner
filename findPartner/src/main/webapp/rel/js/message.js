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
			//$(".updatebtn").show();//修改个人信息按钮 index.jsp
			//$(".editdiv").show();//显示添加说说按钮	speaks.jsp
			$("#Userimag").show();//显示用户头像	message.jsp
		}else{
			$("#myfriend").hide();
			$(".updatepwd").hide();
			$(".homepage").attr("href","page/lw-index.jsp?aid="+data.finalaid);
			$(".homepage").html("他的主页");
			//$(".updatebtn").hide();
			//$(".editdiv").hide();
			$("#Userimag").hide();//显示用户头像	message.jsp
			
		}
	},"json")
}

/*function add(){
	UE.getEditor('edit');//<textarea>转变成副文本编辑工具
	$("#host").dialog("open", true);
}
$("#host").dialog("close", true);

$('#host').dialog({    
	width:100,
	height:300,
	left:300,
	top:200,
	title:'',
	border:false,
	modal: true
});*/
/*$(function(){
    $('#myForm').submit();
})*/
/*
window.onload= function(){
   document.getElementById('myForm').submit();
}*/
var currPage = 1;
listWords(currPage);
function listWords(currPage){
	$.post("words/list",{"currPage":currPage}, function(data){
		// alert(data);
		// alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
		// alert(JSON.stringify(data.rows));
		var wordsStr = "";
		for (var i = 0; i < data.rows.length; i++) {
			wordsStr+='<div id="host" style="margin-top: 3%;"><div class="showwords"><ul id="everyLiTag">';
			wordsStr+='<li style="color: blue;" class="aaa26">'+data.rows[i].waid+'</li>';
			wordsStr+='<li style="color: blue;" class="name">'+data.rows[i].wfrendid+'</li>';
			wordsStr+='<li style="color: grey;" class="wdate">'+data.rows[i].wdate+'</li>';
			wordsStr+='<li><span>'+data.rows[i].wcontent+'</span></li></ul></div>';
			wordsStr+='<div class="showcomment"></div><div class="showreplys"></div></div>';
			// alert(data.rows[i].wid);
			comments(data.rows[i].wid);//取到所有的说说编号
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
			commentStr+='<ul class="pinglun"><li style="color: blue;" class="aaa29"></li>';
			commentStr+='<li style="color: blue;" class="a29name">评论用户'+data[i].comuserid+'</li>';
			commentStr+='<li style="color: grey;" class="wdate" id="aa29">评论时间:'+data[i].comTime+'</li>';
			commentStr+='<li><span class="wcontenta29">'+data[i].detail+'</span></li></ul>';
			replys(data[i].cid);//取到所有的评论编号
			//alert(data[i].cid);
		}
		$(".showcomment")[0].innerHTML = commentStr;
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
			replysStr+='<ul class="huifu"><li style="color: blue;" class="huiaa26">'+data[i].ruserid+'</li>';
			replysStr+='<li style="color: blue;" class="huiaa26name"><a href="javascript:void(0)">@用户:'+data[i].rtargetid+'</a></li>';
			replysStr+='<li style="color: grey;" class="huiaa26wdate">回复时间:'+data[i].rtime+'</li>';
			replysStr+='<li><span id="edit" name="edit" class="huiaa26edit">'+data[i].rcontent+'</span></li></ul>';
			//replysStr+='<p><a href="">用户:'+data[i].ruserid+'</a><a href="">@用户:'+data[i].rtargetid+'</a></p>';
			//replysStr+='<p><h2>'+data[i].rcontent+'</h2> <span>回复时间:'+data[i].rtime+'</span></p>';
		}
		$(".showreplys")[0].innerHTML = replysStr;
	}, "json");
}



