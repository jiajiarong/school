<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="taglibs.jsp"%>
<head>
<meta name="menu" content="permission"/>
</head>
<h2><samp class="t03"></samp>权限管理</h2>
<ul class="ul">
<li><a href="${path}/user/userlist.do"><samp class="t05"></samp>用户管理</a></li>
<li><a href="${path}/role/listRole.do"><samp class="t05"></samp>角色管理</a></li>
<li><a href="${path}/school/listSchool.do"><samp class="t05"></samp>学校管理</a></li>
<li><a href="${path}/permission/perm/listPerm.do"><samp class="t05"></samp>摄像头配置</a></li>
</ul>
