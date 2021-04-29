<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="dto" value="${quizboardDTO}" />
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="" href="">
<meta charset="UTF-8">
<title>quizDelete</title>
</head>
<body>
<form action="quizDeleteAction" method="post">
		<table>
			<caption>게시물 삭제</caption>
			<tr>
				<th>번호</th>
				<td>${dto.no}<input type="hidden" name="no" value="${dto.no}" /></td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="password" required="required" /><br/>
					* 관리자 계정 비밀번호를 입력하세요
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="완료" /></td>
			</tr>
		</table>
	</form>
</body>
</html>