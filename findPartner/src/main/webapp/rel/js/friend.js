function loadFriendsInfo(){
	//以异步的方式取到个人的信息
	$.get("friend/list", function(data){
		//alert("请求响应成功。。"+data);
		alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		var friendList="";
		for (var i = 0; i < data.length; i++) {
			friendList+='<div>'
			friendList+=data[i].picture==null?'<img src="images/not_pic.jpg">':'<img src='+data[i].picture+'>';
			friendList+='<h3>'+data[i].nickname+'</h3></div>';
		}
		$("#container")[0].innerHTML = friendList;

		
	}, "json");
}
loadFriendsInfo();