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
<script src="${path}/ecps/console/school/user/addUser.js"></script>

</head>
<body id="main">
<div class="frameL"><div class="menu icon">
    <jsp:include page="/${system}/common/permissionmenu.jsp"/>
</div></div>

<div class="frameR"><div class="content">

	<c:url value="userlist.do" var="backurl"/>
	
	<div class="loc icon"><samp class="t12"></samp>当前位置：权限管理&nbsp;&raquo;&nbsp;<a href="<c:url value="/${system }/user/userlist.do"/>" title="用户管理">用户管理</a>&nbsp;&raquo;&nbsp;<span class="gray">编辑用户</span>
    <a href="<c:url value="userlist.do"/>" title="返回用户管理" class="inb btn80x20">返回用户管理</a>
    </div>
	<form id="form111" name="form111" action="${path}/user/editSaveUser.do" method="post" enctype="multipart/form-data">
		<div class="edit set">
		<input type="hidden" id="userId" name="userId" value="${userOne.userId}"/>
		<input type="hidden" id="createTime" name="createTime" value="${userOne.createTime}"/>	
			<p>
			    <label><samp>*</samp>登录名：</label>
			    <input type="text" id="loginName" name="loginName" class="text state" value="${userOne.loginName}" reg2="^(.|\n){0,300}$" tip="任意字符，长度0-300"/>
				<span></span>
			</p>
			<%-- <p>
			    <label><samp>*</samp>密码：</label>
			    <input type="text" id="password" name="password" class="text state" value="${userOne.password}"  reg2="^(.|\n){0,300}$" tip="任意字符，长度0-300"/>
				<span></span>
			</p> --%>
			<p>
			    <label><samp>*</samp>用户名：</label>
			    <input type="text" id="userName" name="userName" class="text state" value="${userOne.userName}" reg2="^(.|\n){0,300}$" tip="任意字符，长度0-300"/>
				<span></span>
			</p>
			<p>
			    <label><samp>*</samp>用户手机号：</label>
			    <input type="text" id="telephone" name="telephone" class="text state" value="${userOne.telephone}" reg2="^(.|\n){0,300}$" tip="任意字符，长度0-300"/>
				<span></span>
			</p>
			<p>
			    <label><samp>*</samp>用户地址：</label>
			    <input type="text" id="userAddress" name="userAddress" class="text state" value="${userOne.userAddress}" reg2="^(.|\n){0,300}$" tip="任意字符，长度0-300"/>
				<span></span>
			</p>
			<p>
			    <label><samp>*</samp>用户状态：</label>
			    <input type="text" id="status" name="status" class="text state" value="${userOne.status}" reg2="^(.|\n){0,300}$" tip="任意字符，长度0-300"/>
				<span></span>
			</p>
			<p>
			    <label><samp>*</samp>所属学校：</label>
			    
				
					<c:forEach items="${schoolListAllByUserId}" var="school">
					
					${school.schoolName}  ;
						
					</c:forEach>
				
				<span></span>
			</p>
			<p>
			    <label><samp>*</samp>所属角色：</label>
			    
				
					<c:forEach items="${roleListByOnlyUserId}" var="role">
					
					${role.roleName}  ;
						
					</c:forEach>
				
				<span></span>
			</p>
			<c:if test="${user.loginName=='develop'||schoolListAllByUserId==null}">
			<p>
			    <label><samp>*</samp>重新选所属学校：</label>
			    
				
					<c:forEach items="${schoolListAll}" var="school">
					
					<input type="checkbox" name="schoolId" value="${school.schoolId}">${school.schoolName}</input>
						
					</c:forEach>
				
				<span></span>
			</p>
			</c:if>
			
			<c:if test="${user.loginName=='develop'||roleListByUserId==null}">
			<p>
			    <label><samp>*</samp>重新选所属角色：</label>
			    
				
					<c:forEach items="${roleListByUserId}" var="role">
					
					<input type="checkbox" name="roleId" value="${role.roleId}">${role.roleName}</input>
						
					</c:forEach>
				
				<span></span>
			</p>
			</c:if>
			
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

