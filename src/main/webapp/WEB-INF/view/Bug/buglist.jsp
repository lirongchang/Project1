<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCuser html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-user" content="text/html; charset=UTF-8">
<title>DMS缺陷管理系统</title>
<base href="<%=basePath%>" />
<link rel="stylesheet" user="text/css" href="static/css/sm-default.css" />
<link rel="stylesheet" user="text/css" href="static/css/styles.css" />
<meta name="description" content="软件测试技术案例" />
<meta name="keywords" content="software testing, SpringMVC,Testing" />

</head>
<body>
	<table width="100%">
		<tr>
			<td>缺陷列表</td>
			<td><a href="to_addbug" target="_self">新增</a></td>
		</tr>
	</table>
	<table>
	<tr align="center">
				<td>序号</td>
				<td>名称  </td>
				<td>描述 </td>
				<td>系统 </td>
				<td>严重级别 </td>
				<td>所属项目 </td>
				<td>缺陷状态 </td>
                <td>提交人 </td>
                <td>处理人  </td>
				<td>评论 </td>
				<td>优先级 </td>
			<!-- 	<td>提交时间: </td> -->
                 <td> 操作</td>
			     <td> 操作</td>
			</tr>
		<c:forEach items="${list}" var="bug" varStatus="bugs">
	 	<tr align="center">
				<td>${bugs.index+1}</td>
				<td> ${bug.bug_summary}</td>
				<td> ${bug.bug_description}</td>
				<td> ${bug.bug_os}</td>
				<td> ${bug.pon_id}</td>
			  	 
				<c:forEach items="${pros}" var="pro" varStatus="users">
				 
					<c:if test="${bug.pro_id==pro.pro_id}">
						<td> ${pro.pro_name}</td>
					</c:if>
				</c:forEach>
                
				
				<td> ${bug.bug_status}</td>
             
				<c:forEach items="${users}" var="user" varStatus="users">
			 
					<c:if test="${bug.reporter_id==user.id}">
						<td> ${user.name}</td>
					</c:if>
				</c:forEach>

            
				<c:forEach items="${users}" var="user" varStatus="users">
		 
					<c:if test="${bug.handler_id==user.id}">
						<td> ${user.name}</td>
					</c:if>
				</c:forEach>
                 
				<td> ${bug.bug_comment}</td>
				<td> ${bug.bug_priority}</td>
				 
                 <td><a href ="deletebug?bug_id=${bug.bug_id}" >删除</a></td>
			     <td><a href ="to_updatebug?bug_id=${bug.bug_id}" >更新</a></td>
			</tr>
	 
	 
		</c:forEach>
	</table>
</body>
</html>