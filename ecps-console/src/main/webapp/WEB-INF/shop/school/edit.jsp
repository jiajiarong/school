<%@ include file="/ecps/console/common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<title>添加用户_权限管理_用户管理</title>
<meta name="heading" content="用户管理"/>
<meta name="tag" content="tagName"/>
<script type="text/javascript" src="<c:url value='/${system}/res/js/jquery.form.js'/>"></script>
<script> 
    var path = "${path}"
</script>
<script src="${path}/ecps/console/school/school/school.js"></script>

</head>
<body id="main">
<div class="frameL"><div class="menu icon">
    <jsp:include page="/${system}/common/permissionmenu.jsp"/>
</div></div>

<div class="frameR"><div class="content">

	<c:url value="listSchool.do" var="backurl"/>
	
	<div class="loc icon"><samp class="t12"></samp>当前位置：权限管理&nbsp;&raquo;&nbsp;<a href="<c:url value="/${system }/user/userlist.do"/>" title="用户管理">学校管理</a>&nbsp;&raquo;&nbsp;<span class="gray">编辑学校</span>
    <a href="<c:url value="listSchool.do"/>" title="返回学校管理" class="inb btn80x20">返回学校管理</a>
    </div>
	<form id="form111" name="form111" action="${path}/school/editSaveSchool.do" method="post" enctype="multipart/form-data">
		<div class="edit set">
		<input type="hidden" id="schoolId" name="schoolId" value="${schoolOne.schoolId}"/>
		<input type="hidden" id="createTime" name="createTime" value="${schoolOne.createTime}"/>	
			<p>
			    <label><samp>*</samp>学校名称：</label>
			    <input type="text" id="schoolName" name="schoolName" class="text state" value="${schoolOne.schoolName}" reg2="^(.|\n){0,300}$" tip="任意字符，长度0-300"/>
				<span></span>
			</p>
			<p>
			    <label><samp>*</samp>负责人-园长：</label>
			    <input type="text" id="schoolAdminName" name="schoolAdminName" class="text state" value="${schoolOne.schoolAdminName}"  reg2="^(.|\n){0,300}$" tip="任意字符，长度0-300"/>
				<span></span>
			</p>
			<p>
			    <label><samp>*</samp>负责人手机号：</label>
			    <input type="text" id="schoolAdminTelephone" name="schoolAdminTelephone" class="text state" value="${schoolOne.schoolAdminTelephone}" reg2="^(.|\n){0,300}$" tip="任意字符，长度0-300"/>
				<span></span>
			</p>
			<p>
			    <label><samp>*</samp>学校地址：</label>
			    <input type="text" id="schoolAddress" name="schoolAddress" class="text state" value="${schoolOne.schoolAddress}" reg2="^(.|\n){0,300}$" tip="任意字符，长度0-300"/>
				<span></span>
			</p>
			<p>
			    <label><samp>*</samp>学校状态：</label>
			    <input type="text" id="status" name="status" class="text state" value="${schoolOne.status}" reg2="^(.|\n){0,300}$" tip="任意字符，长度0-300"/>
				<span></span>
			</p>
			<p>
			    <label>&nbsp;</label>
			    <input type="submit" name="button1"  class="hand btn83x23" value="完成" />
			    <input type="button" class="hand btn83x23b" id="reset1" value='取消' onclick="backList('${backurl}')"/>
			</p>
		</div>
	</form>
    <div class="loc">&nbsp;</div>

</div></div>
</body>

