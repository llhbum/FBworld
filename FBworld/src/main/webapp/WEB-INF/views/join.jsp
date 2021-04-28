<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="" href="">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>

</div>
<form action="joinAction" method="post">
		<table>
			<caption>회원가입</caption>
			<tr>
				<th>아이디</th>
				<td><input type = "text" name ="id" autofocus="autofocus" required ="required"/></td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type = "password" name ="password" autofocus="autofocus" required ="required"/></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td><input type = "text" name ="nickname" autofocus="autofocus" required="required"/></td>
			</tr>
			<tr>
				<td colspan="2"  align ="center" ><input type ="submit" value="Join"> </td>
			</tr>
		</table>
	</form>
</body>
</html>