<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="dto" value="${quizboardDTO }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quizUpdate</title>
</head>
<body>
	<form action="quizUpdateAction" method="post">
		<table>
			<caption>Quiz 수정</caption>
			<tr>
				<th>번호</th>
				<td>${dto.no}<input type="hidden" name="no" value="${dto.no}" /></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" autofocus="autofocus" required="required" value="${dto.title}" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea type="text" name="content" required="required" >${dto.content}</textarea></td>
			</tr>
			<tr>
				<th>힌트1</th>
				<td><input name="hint1" rows="5" cols="40" required="required" value="${dto.hint1}" /></td>
			</tr>
			<tr>
				<th>힌트2</th>
				<td><input name="hint2" rows="5" cols="40" required="required" value="${dto.hint2}" /></td>
			</tr>
			<tr>
				<th>힌트3</th>
				<td><input name="hint3" rows="5" cols="40" required="required" value="${dto.hint3}" /></td>
			</tr>
			<tr>
				<th>힌트4</th>
				<td><input name="hint4" rows="5" cols="40" required="required" value="${dto.hint4}" /></td>
			</tr>
			<tr>
				<th>힌트5</th>
				<td><input name="hint5" rows="5" cols="40" required="required" value="${dto.hint5}" /></td>
			</tr>
			<tr>
				<th>정답</th>
				<td><input name="answer" rows="5" cols="40" required="required" value="${dto.answer}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="완료" /></td>
			</tr>
		</table>
	</form>
</body>
</html>