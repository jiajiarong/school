function submitUpload() {
	var options = {
			url:path+"/upload/uploadPic.do",
			dataType:"text",
			success:function(responseText) {
				//把字符串的json转换成json对象
				var jsonObj = $.parseJSON(responseText);
				$("#imgsImgSrc").attr("src", jsonObj.realPath);
				$("#imgs").val(jsonObj.relativePath);
				$("#lastFilePath").val(jsonObj.realPath);
			},
			error:function(responseText) {
				alert("系统错误");
			}
			
	};
	$("#form111").ajaxSubmit(options);
}

$(function() {
	$("#form111").submit(function() {
		//如果成功才去提交，否则禁用表单提交事件
		var isSubmit = true;
		
		
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
				var brandName = $(this).attr("name");
				if(brandName == "brandName") {
					var result = vaidBrandName(val);
					if(result == "no") {
						$(this).next().html("<font color='red'>该商品已经存在</font>");
						isSubmit = false;
						return false;   //跳出循环
					}
					else {
						$(this).next().html("");
					}
				}
				else {
					$(this).next().html("");
				}
			}
		});
		
		//非必填项
		
		$(this).find("[reg1]").each(function() {
			var strReg = $(this).attr("reg1");
			var tip = $(this).attr("tip");
			var val = $.trim($(this).val());
			//创建正则表达式的对象
			var reg = new RegExp(strReg);
			if(val != null && val != '' &&  !reg.test(val)) {
				$(this).next().html("<font color='red'>"+tip+"</font>");
				isSubmit = false;
				//跳出循环
				return false;
			}
			else {
				$(this).next().html("");
			}
		});
		return isSubmit;
	});
	
	
	//blur验证Reg2
	$("input[reg2]").blur(function () {
		var strReg = $(this).attr("reg2");
		var tip = $(this).attr("tip");
		var val = $.trim($(this).val());
		//创建正则表达式的对象
		var reg = new RegExp(strReg);
		if(!reg.test(val)) {
			$(this).next().html("<font color='red'>"+tip+"</font>");
		}
		else {
			var brandName = $(this).attr("name");
			if(brandName == "brandName") {
				var result = vaidBrandName(val);
				if(result == "no") {
					$(this).next().html("<font color='red'>该商品已经存在</font>");
				}
				else {
					$(this).next().html("");
				}
			}
			else {
				$(this).next().html("");
			}
		}
		
	});
	
	
	//blur验证Reg1
	$("input[reg1]").blur(function() {
		var strReg = $(this).attr("reg1");
		var tip = $(this).attr("tip");
		var val = $.trim($(this).val());
		//创建正则表达式的对象
		var reg = new RegExp(strReg);
		if(val != null && val != '' &&  !reg.test(val)) {
			$(this).next().html("<font color='red'>"+tip+"</font>");
		}
		else {
			$(this).next().html("");
		}
	});
});




function vaidBrandName(brandName) {
    var result = "yes";
    $.ajax({
    	url:path+"/item/vaidBrandName.do",
    	type:"post",
    	dataType:"text",
    	async:false,
    	data:{brandName:brandName},
    	success:function(responseText) {
    		result = responseText;
    	},
    	error:function(responseText) {
    		alert("系统错误");
    	}
    });
    return result;
}



























/*$(function(){
	$("#form111").submit(function(){
		
		var isSubmit = true;
		//获得去到每一个input输入框
		$(this).find("[reg2]").each(function(){
			
			var regStr = $(this).attr("reg2");
			var reg = new RegExp(regStr);
			var tip = $(this).attr("tip");
			var val = $.trim($(this).val());
			var input = $(this);
			var name = $(this).attr("name");
			if(!reg.test(val)){
				$(this).next("span").html(tip);
				//中断each使用return false,不能使用return;和break;
				isSubmit = false;
				return false;
			}else{
				//如果是品牌名称需要做服务器端的品牌名称的重复验证
				if(name == "brandName"){
					$.ajax({
						url:"${path}/brand/validateBrandName.do",
						type:"post",
						dataType:"text",
						data:{
							brandName:val
						},
						success:function(responseText){
							if(responseText == "no"){
								input.next("span").html("品牌名称不能重复");
								isSubmit = false;
								return false;
							}
						},
						error:function(){
							alert("系统错误");
						}
					});
				}
				
				$(this).next("span").html("");
			}
		});
		
		$(this).find("[reg1]").each(function(){
			
			var regStr = $(this).attr("reg1");
			var reg = new RegExp(regStr);
			var tip = $(this).attr("tip");
			var val = $.trim($(this).val());
			if(val != null && val != ""){
				if(!reg.test(val)){
					$(this).next("span").html(tip);
					//中断each使用return false,不能使用return;和break;
					isSubmit = false;
					return false;
				}else{
					$(this).next("span").html("");
				}
			}
			
		});
		
		if(isSubmit){
			tipShow("staticLoadDiv");
			//$("#button1").attr("disabled","disabled");
		}
		return isSubmit;
	});
	
	$("#form111").find("[reg2]").blur(function(){
		var regStr = $(this).attr("reg2");
		var reg = new RegExp(regStr);
		var tip = $(this).attr("tip");
		var val = $.trim($(this).val());
		var name = $(this).attr("name");
		var input = $(this);
		if(!reg.test(val)){
			$(this).next("span").html(tip);
			//中断each使用return false,不能使用return;和break;
		}else{
			if(name == "brandName"){
				$.ajax({
					url:"${path}/brand/validateBrandName.do",
					type:"post",
					dataType:"text",
					data:{
						brandName:val
					},
					success:function(responseText){
						if(responseText == "no"){
							input.next("span").html("品牌名称不能重复");
							isSubmit = false;
							return false;
						}
					},
					error:function(){
						alert("系统错误");
					}
				});
			}
			$(this).next("span").html("");
		}
	});
	$("#form111").find("[reg1]").blur(function(){
		var regStr = $(this).attr("reg1");
		var reg = new RegExp(regStr);
		var tip = $(this).attr("tip");
		var val = $.trim($(this).val());
		if(val != null && val != ""){
			if(!reg.test(val)){
				$(this).next("span").html(tip);
				//中断each使用return false,不能使用return;和break;
			}else{
				$(this).next("span").html("");
			}
		}else{
			$(this).next("span").html("");
		}
	});
});

function submitUpload(){
	
	var opt = {
		//重新指定form的action的值
		url:"${path}/upload/uploadPic.do",
		type:"post",
		dateType:"text",
		data:{
			fileName:"imgsFile"
		},
		success:function(responseText){
			var obj = $.parseJSON(responseText);
			$("#imgsImgSrc").attr("src",obj.fullPath);
			$("#imgs").val(obj.fileName);
			
		},
		error:function(){
			alert("系统错误");
		}
		
	};
	$("#form111").ajaxSubmit(opt);
	
}*/