function add(){
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
});
/*$(function(){
    $('#myForm').submit();
})*/
/*
window.onload= function(){
   document.getElementById('myForm').submit();
}*/