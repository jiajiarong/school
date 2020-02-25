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
<script src="${path}/ecps/console/school/role/role.js"></script>

</head>
<body id="main">
<div class="frameL"><div class="menu icon">
    <jsp:include page="/${system}/common/permissionmenu.jsp"/>
</div></div>

<div class="frameR"><div class="content">

	<c:url value="listRole.do" var="backurl"/>
	
	<div class="loc icon"><samp class="t12"></samp>当前位置：权限管理&nbsp;&raquo;&nbsp;<a href="<c:url value="/${system }/role/listRole.do"/>" title="用户管理">用户管理</a>&nbsp;&raquo;&nbsp;<span class="gray">添加用户</span>
    <a href="<c:url value="listRole.do"/>" title="返回用户管理" class="inb btn80x20">返回用户管理</a>
    </div>
	<form id="form111" name="form111" action="${path}/role/saveRole.do" method="post" enctype="multipart/form-data">
		<div class="edit set">
			<p>
			    <label><samp>*</samp>角色名：</label>
			    <input type="text" id="roleName" name="roleName" class="text state" reg2="^(.|\n){0,300}$" tip="任意字符，长度0-300"/>
				<span></span>
			</p>
			<p>
			    <label><samp>*</samp>角色描述：</label>
			    <input type="text" id="roleAddress" name="roleAddress" class="text state" reg2="^(.|\n){0,300}$" tip="任意字符，长度0-300"/>
				<span></span>
			</p>
			
			<p>
			    <label><samp>*</samp>所属学校：</label>
			    
				
				
					<c:forEach items="${schoolListAll}" var="school">
					
					<input type="checkbox" name="schoolId" value="${school.schoolId}">${school.schoolName}</input>
						
					</c:forEach>
				
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

