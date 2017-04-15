
$("#findFriendForm").form({
	url:"friend/findFriend",
	success:function(data){
		//alert(data);
		var data = eval('(' + data + ')');  // change the JSON string to javascript object    
		//alert(data.picture);
		var findFriendStr="";
		findFriendStr+='<div class="testdiv" style="float:left;">';
		findFriendStr+=data.picture==null?'<img style="width:100px;height:100px;border:none;" src="images/not_pic.jpg">':'<img style="width:100px;height:100px;border:none;" src="'+data.picture+'">';
		findFriendStr+='</div><div style="float:left;margin-left:5px;"><h3>昵称：'+data.nickname+'</h3><span>现居地址：'+data.address+'</span><br>';
		findFriendStr+='<a href="javascript:void(0)" onclick="addFriend(\''+data.aid+'\')" style="color:red;">添加</a>';
		findFriendStr+='<a href="javascript:void(0)" style="color:green;margin-left:8px;">取消</a></div>';
		$("#friend")[0].innerHTML = findFriendStr;
	}
});

function addFriend(aid){
	alert(aid);
	$.post("friend/add",{"aid" : aid},function(data){
		if (data) {
			var url = "page/lw-findFriend.jsp";
			// window.open(url); //打开新的页面并带参数过去
			self.location = url;//挑战页面
		}
	},"json");
}

function friendReq(){
	$.get("friend/reqAdd", function(data){
		//alert("请求响应成功。。"+data);
		alert(JSON.stringify(data));
		var friendReqStr="";//JSON.stringify() ,把json对象转换成json字符串
		if(data!=null){
			for (var i = 0; i < data.length; i++) {
				friendReqStr+='<div class="testdiv" style="float:left;">';
				friendReqStr+=data[i].picture==null?'<img style="width:100px;height:100px;border:none;" src="images/not_pic.jpg">':'<img style="width:100px;height:100px;border:none;" src="'+data[i].picture+'">';
				friendReqStr+='</div><div style="float:left;margin-left:5px;"><h3>昵称：'+data[i].nickname+'</h3><span>现居地址：'+data[i].address+'</span><br>';
				friendReqStr+='<a href="javascript:void(0)" onclick="addFriend(\''+data[i].aid+'\')" style="color:red;">添加</a>';
				friendReqStr+='<a href="javascript:void(0)" style="color:green;margin-left:8px;">拒绝</a></div>';
			}
			$("#friend")[0].innerHTML = friendReqStr;
		}
	}, "json");
}

function friendIntro(){
	$.get("friend/introFriend", function(data){
		//alert("请求响应成功。。"+data);
		alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		var friendIntoStr="";
		if(data!=null){
			for (var i = 0; i < data.length; i++) {
				friendIntoStr+='<div class="testdiv" style="float:left;">';
				friendIntoStr+=data[i].picture==null?'<img style="width:100px;height:100px;border:none;" src="images/not_pic.jpg">':'<img style="width:100px;height:100px;border:none;" src="'+data.picture+'">';
				friendIntoStr+='</div><div style="float:left;margin-left:5px;"><h3>昵称：'+data[i].nickname+'</h3><span>现居地址：'+data[i].address+'</span><br>';
				friendIntoStr+='<a href="javascript:void(0)" onclick="addFriend(\''+data[i].aid+'\')" style="color:red;">添加</a>';
				friendIntoStr+='<a href="javascript:void(0)" style="color:green;margin-left:8px;">取消</a></div>';
			}
			//$("#friend").append(friendIntoStr);
			$("#friend")[0].innerHTML = friendIntoStr;
		}
	}, "json");
	
	
}
