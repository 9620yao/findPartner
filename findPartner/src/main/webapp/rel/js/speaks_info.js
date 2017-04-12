$('#speaksInfo').datagrid({    
	url:'speaks/showSpeaks',  
	fitColumns:true,
	fit:true,
	singleSelect:true,
	border:false,
	pagination :true,
    columns:[[    
        {field:'sid',title:'编号',width:50,align:'center'},    
        {field:'speakman',title:'发表人',width:50,align:'center'},
        {field:'content',title:'内容',width:100,align:'center'},   
        {field:'files',title:'文件',width:100,align:'center'},
        {field:'senddate',title:'时间',width:100,align:'center'},
        
        {field:'operator',title:'操作',width:100,align:'center',
        	formatter: function(value,row,index){
				//alert(row + "==>" + JSON.stringify(row));
        		return '<a class="detailBtn" href="javascript:void(0)" onclick="showDetail('+row.sid+')">详情</a>' + 
        		'<script>$(".detailBtn").linkbutton({iconCls: "icon-search"});</script>';
			}
        }
    ]],
});  
$("#speaksDetail").dialog({
	title:"说说预览",
	left:10,
	closed:true,
});
/*function showDetail(id){
	//alert(id);
	$("#speaksDetail").dialog("open");
	$.post("speaks/get?sid="+id,function(data){
		alert(JSON.stringify(data));
		$("#ispeakman").val(data.speakman);
		$("#icontent").html(data.content);
		$("#ifiles").val(data.files);
		$("#isenddate").val(data.senddate);
	},"json");
}*/
