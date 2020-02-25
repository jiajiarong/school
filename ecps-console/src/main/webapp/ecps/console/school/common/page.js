


$(function() {
	
	 
	 var pageNo = parseInt($("#currentPageNo").val());
	 var totalPage = parseInt($("#totalPage").val());
	 
	 if(pageNo == 1 && totalPage == 1) {
		 $("#first").hide();
		 $("#previous").hide();
		 $("#next").hide();
		 $("#last").hide();
	 }
	 else if(pageNo == 1 && totalPage > pageNo) {
		 $("#first").hide();
		 $("#previous").hide();
		 $("#next").show();
		 $("#last").show();
	 }
	 else if(pageNo > 1 && totalPage > pageNo) {
		 $("#first").show();
		 $("#previous").show();
		 $("#next").show();
		 $("#last").show();
	 }
	 else if(pageNo == totalPage && totalPage > 1) {
		 $("#first").show();
		 $("#previous").show();
		 $("#next").hide();
		 $("#last").hide();
	 }
	 
	 
	 $("#next").click(function() {
		 pageNo++;
		 $("#pageNo").val(pageNo);
		 $("#form1").submit();
	 });
	 $("#first").click(function() {
		 $("#pageNo").val(1);
		 $("#form1").submit();
	 });
	 $("#previous").click(function() {
		 pageNo--;
		 $("#pageNo").val(pageNo);
		 $("#form1").submit();
	 });
	 
	 $("#last").click(function() {
		 $("#pageNo").val(totalPage);
		 $("#form1").submit();
	 });
	
	
	
	 
});




