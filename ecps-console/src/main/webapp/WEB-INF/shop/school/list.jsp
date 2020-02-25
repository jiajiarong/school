<%@ include file="/ecps/console/common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<title>权限管理_用户管理</title>
<meta name="heading" content="<fmt:message key='mainMenu.heading'/>"/>
<meta name="brand" content="brandName"/>
</head>
<body id="main">
<div class="frameL"><div class="menu icon">
    <jsp:include page="/${system}/common/permissionmenu.jsp"/>
</div></div>

<script> 
    var path = "${path}"
</script>
<script src="${path}/ecps/console/school/school/school.js"></script>
<script src="${path}/ecps/console/school/common/page.js"></script>
<div class="frameR"><div class="content">

<div class="loc icon"><samp class="t12"></samp>当前位置：权限管理&nbsp;&raquo;&nbsp;<span class="gray">学校管理</span></div>

<form id="form1" name="form1" action="${path}/school/listSchool.do" method="post">
    <div class="page_c">
        
        <span class="r inb_a">
            <a href="${path}/school/addSchool.do" title="添加" class="btn80x20">添加</a>
        </span>
    </div>

	<table cellspacing="0" summary="" class="tab">
	    
		<thead>
		<tr>
			<th>学校名称</th>
            <th>负责人-园长</th>
			<th>负责人手机号</th>
			<th>学校地址</th>
			<th>学校状态</th>
			<th>创建时间</th>
			
			<th width="10%">操作</th>
	    </tr>
		</thead>
		<tbody>
		
		  <c:forEach var="school" items="${schoolList}">
			   <tr>
					<td>${school.schoolName}</td>
	                <td>${school.schoolAdminName}
					</td>
					<td>${school.schoolAdminTelephone}</td>
					<td>${school.schoolAddress}</td>
					<td>${school.status}</td>
					<td>${school.createTime}</td>
					<td>
						<a href="${path }/school/editSchool.do?schoolId=${school.schoolId}">编辑</a>
	                    <a href="#" onclick="singleDel(${school.schoolId})">删除</a>
					</td>
				</tr>
		    </c:forEach> 
			
		</tbody>
	</table>
<jsp:include page="/${system}/common/page.jsp"/>
</form>
</div></div>
</body>


