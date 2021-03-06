<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
  <title>quizBoard</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="table_1_container">
			<table border="1">
				<caption>Quiz 리스트</caption>
				
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>시작일</th>
					<th>종료일</th>
					<th>조회수</th>
					<th>마감여부</th>
				</tr>
				
				<c:forEach var="quizBoardDto" items="${quizBoardDto }">
					<tr>
						<td>${quizBoardDto.no }</td>
						<td><a href="quizDetail?no=${quizBoardDto.no}">${quizBoardDto.title }</a></td>
						<td>${quizBoardDto.regdate }</td>
						<td>${quizBoardDto.expdate }</td>
						<td>${quizBoardDto.readcount }</td>
						<td id="exprirecheck" style="color:red">
							<c:choose>
								<c:when test="${quizBoardDto.expirecheck eq 1 }">
									마감
								</c:when>	
								
								<c:when test="${quizBoardDto.expirecheck eq 0 }">
									진행중
								</c:when>		
							</c:choose>
						</td>
					</tr>
				</c:forEach>
				<a href="quizInsert">글쓰기</a>
			</table>
		</div>
		
		<div class="table_2_container">
			<table border="1">
				<caption>Quiz Ranking</caption>
				
				<tr>
					<th>등수</th>
					<th>닉네임</th>
					<th>점수</th>
				</tr>
				
				<c:forEach var="memberDto" items="${memberDto }">
					<tr>
						<th><c:set var="n" value="${n+1 }"></c:set>${n }</th>
						<th>${memberDto.nickname }</th>
						<th>${memberDto.score }</th>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>