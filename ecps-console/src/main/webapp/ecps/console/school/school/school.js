
$(function() {
	
	
	
	$("#form111").submit(function() {
		//如果成功才去提交，否则禁用表单提交事件
		var isSubmit = true;
		
		var ss=$(this).find("[reg2]");
		//必填项
		$(this).find("[reg2]").each(function() {
			var strReg = $(this).attr("reg2");
			var tip = $(this).attr("tip");
			var val = $.trim($(this).val());
			//创建正则表达式的对象
			var reg = new RegExp(strReg);
			
			if(!reg.test(val)) {
				$(this).next().html("<font color='red'>"+tip+"</font>");
				isSubmit = false;
				//跳出循环
				return false;
			}
			else {
				
				if(val==""){
					$(this).next().html("<font color='red'>"+tip+"</font>");
					isSubmit = false;
					//跳出循环
					return false;
				}
				
			}
		});
		
		
		return isSubmit;
	});
	
	
	
	
	
	
});





function backList(back) {
	window.location.href=back;
}

function singleDel(schoolId) {
	
	if(confirm('确定要删除吗')==true){
		 $.ajax({
		    	url:path+"/school/deleteSchool.do",
		    	type:"post",
		    	dataType:"text",
		    	async:false,
		    	data:{schoolId:schoolId},
		    	success:function(responseText) {
		    		result = responseText;
		    		window.location.href=path+"/school/listSchool.do";
		    	},
		    	error:function(responseText) {
		    		alert("系统错误");
		    	}
		    });
	       return true;

	    }else{

	       return false;

	    }
}




















