UE.getEditor('fdesc');
function myadd(){
	alert(1111);
}


//点击提交的时候
function addSpeak(){
	alert(1111);
}

function loadAdminInfo(){
	//以异步的方式取到个人的信息
	$.get("user/getByid", function(data){
		//alert("请求响应成功。。"+data);
		//alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		$("#pictrue").val("");
		if(data.picture){
			$(".pic").attr("src", data.picture);
		}else{
			$(".pic").attr("src", "images/not_pic.jpg");
		}
		showUser(data);
		showUserinfo(data);
	}, "json");
}
loadAdminInfo();

function showUser(data){
	//$("#inickname").append("<h2>1111</h2>");
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
	$("astate").append(data.astate);
}


function showUserinfo(data){
	//$("#inickname").append("<h2>1111</h2>");
	$("#nickname").append(data.nickname);
	$("#age").append(data.age);
	$("#birthday").append(data.birthday);
	$("#gender").append(data.partner.gender);
	$("#star").append(data.star);
	$("#hobby").append(data.hobby);
	$("#job").append(data.job);
	$("#company").append(data.company);
	$("#school").append(data.school);
	$("#astate").append(data.astate);
	$("#address").append(data.address);
	$("#hometown").append(data.hometown);
	$("astate").append(data.astate);
}

$('#addInfo').dialog({    
	width:380,
	height:500,
	left:500,
	top:800,
	title:'',
	border:false,
	modal: true
});   


$("#addInfo").dialog("close", true);


function add(){
	showUserinfo();
	$("#addInfo").dialog("open", true);
}

function addWinClose(){
	$("#addInfo").dialog("close", true);
	return false;
}

$(".updateBtn").linkbutton({
	iconCls: "icon-ok",
	onClick: function(){
		$("#updateUserInfo").submit();
	} 	
});


$("#updateUserInfo").form({
	url:"user/update",    
    success:function(data){
    	alert(JSON.stringify(data));
    	if(data == ""){
    		$.messager.alert('用户修改主','当前用户没有修改用户的权限 ！','warning');
    		$("#addInfo").dialog("close"); //关闭修改框
    		return ;
    	}

    	if(data.trim() == "true"){
    		$("#addInfo").dialog("close"); //关闭修改框
    		$("#myself").datagrid("reload"); //刷新修改数据
    	}else{
    		$.messager.show({
    			title:'修改信息',
    			msg:'修改失败！！！',
    			showType:'show',
    			style:{
    				top:document.body.scrollTop+document.documentElement.scrollTop,
    			}
    		});
    	}
    } 
});
function chgPic(obj){
	$(".pic").attr("src", window.URL.createObjectURL(obj.files[0]));
}