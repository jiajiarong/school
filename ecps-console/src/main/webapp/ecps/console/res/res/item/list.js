 $(function(){
	 
	
 }); 
































/*$(document).ready(function(){
    	var itemId = null;
    	var showStatus = null;
    	
    	$("a[group]").click(function(){
			tipShow('#addItemNote');
			itemId = $(this).attr("itemId");
			showStatus = $(this).attr("showStatus");
		});
    	$("#confirmDivOk").click(function(){
			var form = document.getElementById("form1");
            form.action = objDelUrl + "?itemId=" + objItemId;
            form.submit();
		});
    	$("#addItemNoteConfirm").click(function(){
	        window.location.href="${path}/item/show.do?itemId="+itemId+ "&showStatus="+showStatus;
    	});
    	
    	var currentPageNo = parseInt($("#currentPageNo").val());
    	var totalCount = parseInt($("#totalCount").val());
    	var totalPage = parseInt($("#totalPage").val());
    	 var prePage = $("#prePage").val();
    	var nextPage = $("#nextPage").val(); 
    	$("#pagePiece").html(totalCount);
    	$("#pageTotal").html(currentPageNo+"/"+totalPage);
    	 if(currentPageNo <= 1){
    		$("#previous").hide();
    	}else{
    		$("#previous").show();
    	}
    	if(currentPageNo >= totalPage){
    		$("#next").hide();
    	}else{
    		
    		$("#next").show();
    	} 
    	$("#next").click(function(){
    		$("#pageNo").val(parseInt(currentPageNo)+1);
    		$("#form1").submit();
    	});
    	$("#previous").click(function(){
    		$("#pageNo").val(parseInt(currentPageNo)-1);
    		$("#form1").submit();
    	});
    	
        
        if($("#showStatus").val()=='1'){
            $("#label4") .attr("class","here");
        }
       else  if($("#showStatus").val()=='0'){
            $("#label5") .attr("class","here");
        }
        else $("#label6") .attr("class","here");
    });
    
    function orderBy(orderBy,orderByStatus){
        $("#orderBy").val(orderBy);//代表按那个字段排序
        $("#orderByStatus").val(orderByStatus);//代表排序方式，即升序还是降序
        goSearch('#form1','#userSearch');
    }

    

    function showDeleteCheckRequest(formData, jqForm, options) {
        return true;
    }

    
    
	function publishContent(itemId){
    	$.ajax({
    		url:"${path}/item/publishItemById.do",
    		type:"get",
    		dataType:"text",
    		data:{
    			itemId:itemId
    		},
    		success:function(responseText){
    			if(responseText == "success"){
    				alert("发布成功");
    			}
    		},
    		error:function(){
    			alert("系统错误");
    		}
    		
    	});
    }
*/	