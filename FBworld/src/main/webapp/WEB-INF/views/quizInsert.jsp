<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert.jsp</title>
</head>
<body>
	<form action="quizInsertAction" method="post" enctype="multipart/form-data">
		<table>
			<caption>Quiz등록</caption>
			<tr>
				<th>제목</th>
				<td><input type = "text" name ="title" autofocus="autofocus" required ="required"/></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea name ="content" rows="5" cols="40"></textarea></td>
			</tr>
			
			<tr>
				<th>이미지</th>
				<td><input type="file" name="imagepath" ><br></td>
			</tr>
			
			<tr>
				<th>힌트1</th>
				<td><input type = "text" name ="hint1"/></td>
			</tr>
			
			<tr>
				<th>힌트2</th>
				<td><input type = "text" name ="hint2"/></td>
			</tr>
			
			<tr>
				<th>힌트3</th>
				<td><input type = "text" name ="hint3"/></td>
			</tr>
			
			<tr>
				<th>힌트4</th>
				<td><input type = "text" name ="hint4"/></td>
			</tr>
			
			<tr>
				<th>힌트5</th>
				<td><input type = "text" name ="hint5"/></td>
			</tr>
			
			<tr>
				<th>정답</th>
				<td><input type = "text" name ="answer"/></td>
			</tr>
			
			<tr>
				<td colspan="2"  align ="center" ><input type ="submit" value="완료"> </td>
			</tr>
		</table>
	</form>
</body>
</html>