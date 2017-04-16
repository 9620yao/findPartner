GetFinallyAid();//判断是否隐藏
function GetFinallyAid(){
	$.post("friend/finalAid",function(data){
		//alert(data);
		//alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		//alert(data.finalaid);
		if(data.finalaid=="-1"){
			$(".myfriend").show();
			$(".updatepwd").show();//修改密码按钮
			$(".homepage").attr("href","page/lw-index.jsp");
			$(".homepage").val("个人中心");
			//$(".updatebtn").show();//修改个人信息按钮 index.jsp
			//$(".editdiv").show();//显示添加说说按钮	speaks.jsp
			$("#Userimag").show();//显示用户头像	message.jsp
		}else{
			$(".myfriend").hide();
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
$(function(){
    $('#myForm').submit();
})

window.onload= function(){
   document.getElementById('myForm').submit();
}
var currPage = 1;
listWords(currPage);
function listWords(currPage){
	$.post("words/list",{"currPage":currPage}, function(data){
		// alert(data);
		// alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
		// alert(JSON.stringify(data.rows));
		var wordsStr = "";
		for (var i = 0; i < data.rows.length; i++) {
			wordsStr+='<div class="showwords"><img src="images/01.jpg"  class="wordUserPic picSize" />';
			wordsStr+='<span class="name">'+data.rows[i].wid+'</span>&nbsp;:';
			wordsStr+='<br><p class="wContent fontColor">'+data.rows[i].wcontent+'</p>';
			wordsStr+='<span style="color: grey;" class="wdate">'+data.rows[i].wdate+'</span>';
			wordsStr+='<a href="javascript:void(0)" class="name">&nbsp;回复</a></div>';
			wordsStr+='<hr style="border:1 dotted" id="link"><div class="showcomment'+data.rows[i].wid+'"></div>';
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
			commentStr+='<div>';
			commentStr+='<img src="images/02.jpg"  class="comUserPic picSize" />';
			commentStr+='<span style="color: #CC8F14;" class="commId name">'+data[i].comuserid+'</span>&nbsp;:';
			commentStr+='<br><p class="commContent fontColor">'+data[i].detail+'</p>';
			commentStr+='<span style="color: grey;" class="commTime" id="commTime">'+data[i].comTime+'</span>';
			commentStr+='<a href="javascript:void(0)" class="name">&nbsp;回复</a></div><br><div class="showreplys"></div>';
			replys(data[i].cid);//取到所有的评论编号
			//alert(data[i].cid);
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
			replysStr+='<div><img src="images/03.jpg"  class="replyUserPic picSize"/>';
			replysStr+='<span style="color: #CC8F14;" class="replayId name">'+data[i].ruserid+'</span> &nbsp;回复';
			replysStr+='<span style="color: #CC8F14;" class="commId name">'+data[i].rtargetid+'</span>&nbsp;:<br>';
			replysStr+='<p id="edit" name="edit" class="replayContent fontColor">'+data[i].rcontent+'</p>';
			replysStr+='<span style="color: grey;" class="replayTime">'+data[i].rtime+'</span>';
			replysStr+='<a href="javascript:void(0)" class="name">&nbsp;回复</a>';
			replysStr+='</div><hr style="border:1 dotted red" id="link" class="link">';
		}
		$(".showreplys")[0].innerHTML = replysStr;
	}, "json");
}

function myadd() {
	alert(1111);
}
var ue = UE.getEditor('fdesc');

//点击提交的时候
function addSpeak() {
	$("#content").val(ue.getContentTxt());
	$("#myspeak").submit();
}