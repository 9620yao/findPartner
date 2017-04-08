function loadFriendsInfo(){
	//以异步的方式取到个人的信息
	$.get("friend/list", function(data){
		//alert("请求响应成功。。"+data);
		//alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		var friendList="";
		for (var i = 0; i < data.length; i++) {
			friendList+='<div>'
				friendList+=data[i].picture==null?'<img onclick="showuser(\''+data[i].aid+'\')" src="images/not_pic.jpg">':'<img onclick="showuser(\''+data[i].aid+'\')" src='+data[i].picture+'>';
				friendList+='<h3>'+data[i].nickname+'</h3></div>';
		}
		$("#container")[0].innerHTML = friendList;


	}, "json");
}
loadFriendsInfo();

function showuser(date){
	if (date != null) {
		var url = "page/lw-index.jsp?aid=" + date;
		// window.open(url); //打开新的页面并带参数过去
		window.open(url);
	}
}
