<%@page import="FBworld.models.memberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>
<link rel="icon" type="image/png" sizes="" href="">
<meta charset="UTF-8">
<title>login</title>
<script type="text/javascript">

</script>
</head>
<body>
<div class="container">
	<div class="innerContainer">
		<div class="tableContainer">
			<img align="center" src="${pageContext.request.contextPath}/images/손흥민.jpg"width="100%" height="500px">
			<form action="loginAction" method="post">
				<table>
					<caption><h3>Football World</h3></caption>
					
					<tr>
						<th>ID</th>
						<td><input type = "text" name ="id" autofocus="autofocus" required ="required"/></td>
					</tr>
					
					<tr>
						<th>PW</th>
						<td><input type = "password" name ="password" required ="required"/></td>
					</tr>
					
					<tr>
						<th></th>
						<td><input type ="submit" value="로그인"> <button type="button" onclick="location.href='join'">회원가입</button> </td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>
	
</body>
</html>