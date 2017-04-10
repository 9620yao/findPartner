
$("#findFriendForm").form({
	url:"friend/findFriend",
	success:function(data){
		alert(data);
		var data = eval('(' + data + ')');  // change the JSON string to javascript object    
		alert(data.picture);
		var findFriendStr="";
		findFriendStr+='<div>';
		findFriendStr+=data.picture==null?'<img style="width:100px;height:100px;padding-left:20px;" src="images/not_pic.jpg">':'<img style="width:100px;height:100px;" src="'+data.picture+'">';
		findFriendStr+='<h3>'+data.nickname+'</h3><a href="javascript:void(0)" onclick="addFriend(\''+data.aid+'\')" style="color:red;">添加</a></div>';
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
		alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		if(data!=null){
			for (var i = 0; i < data.length; i++) {
				var friendReqStr="";
				friendReqStr+='<div>';
				friendReqStr+=data[i].picture==null?'<img style="width:100px;height:100px;padding-left:20px;" src="images/not_pic.jpg">':'<img style="width:100px;height:100px;" src="'+data.picture+'">';
				friendReqStr+='<h3>'+data[i].nickname+'</h3><a href="javascript:void(0)" onclick="addFriend(\''+data[i].aid+'\')" style="color:red;">添加</a></div>';
			}
			$("#friend")[0].innerHTML = friendReqStr;
		}
	}, "json");
}

function friendIntro(){
	$.get("friend/introFriend", function(data){
		//alert("请求响应成功。。"+data);
		alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		if(data!=null){
			for (var i = 0; i < data.length; i++) {
				var friendIntoStr="";
				friendIntoStr+='<div>';
				friendIntoStr+=data[i].picture==null?'<img style="width:100px;height:100px;padding-left:20px;" src="images/not_pic.jpg">':'<img style="width:100px;height:100px;" src="'+data.picture+'">';
				friendIntoStr+='<h3>'+data[i].nickname+'</h3><h3>'+data[i].address+'</h3><a href="javascript:void(0)" onclick="addFriend(\''+data[i].aid+'\')" style="color:red;">添加</a></div>';
			}
			$("#friend")[0].innerHTML = friendIntoStr;
		}
	}, "json");
}
