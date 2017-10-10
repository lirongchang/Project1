<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DMS缺陷管理系统</title>
<base href="<%=basePath%>" />
<link rel="stylesheet" type="text/css" href="static/css/sm-default.css" />
<link rel="stylesheet" type="text/css" href="static/css/styles.css" />
<meta name="description" content="软件测试技术案例" />
<meta name="keywords" content="software testing, SpringMVC,Testing" />

</head>
<body>
	<form method="post" action="updateproject">
		<table class="loginTable" align="center">
			<tbody>
				<tr>
					<td colspan="2" class="loginHeader">请输入修改信息</td>
				</tr>
				<input name="pro_id" type="hidden" value=${pro.pro_id}  />
				<tr>
					<td class="loginLabel" align="right">项目名称</td>
					<td align="right"><input name="pro_name" type="text"
						value=${pro.pro_name } /></td>
				</tr>
				<tr>
					<td class="loginLabel" align="right">项目细节</td>
					<td align="right"><input name="pro_details" type="text"
						value=${pro.pro_details }  /></td>
				</tr>
				<tr>
					<td class="loginLabel" align="right">项目经理</td>
					<td align="right"><select name="manage_id">
							<option value=${pro.manage_id}>${myusalign="centeralign="centername}</option>
							<c:forEach items="${users}" var="user" varStatus="users">
								<option value=${user.id} >${user.name}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right"><br /> <input value="注册" type="submit" /></td>
				</tr>
			</tbody>
 
		</table>

	</form>
</body>
</html>