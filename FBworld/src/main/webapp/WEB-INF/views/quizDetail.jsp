<%@page import="FBworld.models.quizboardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="dto" value="${quizboardDTO }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <table>
      <caption>${dto.title }</caption>
      <tr>
         <th>번호</th>
         <td>${dto.no }</td>
      </tr>
      <tr>
         <th>Quiz</th>
         <td>${dto.title }</td>
      </tr>
      <tr>
         <th>내용</th>
         <td>${dto.content }</td>
      </tr>
      <tr>
         <th>이미지</th>
         <td>${dto.imagepath }</td>
      </tr>
      <tr>
         <th>힌트1</th>
         <td>${dto.hint1 }</td>
      </tr>
      <tr>
         <th>힌트2</th>
         <td>${dto.hint2 }</td>
      </tr>
      <tr>
         <th>힌트3</th>
         <td>${dto.hint3 }</td>
      </tr>
      <tr>
         <th>힌트4</th>
         <td>${dto.hint4 }</td>
      </tr>
      <tr>
         <th>힌트5</th>
         <td>${dto.hint5 }</td>
      </tr>
      <tr>
         <th>정답</th>
         <td>${dto.answer }</td>
      </tr>
      <tr>
         <th>조회수</th>
         <td>${dto.readcount }</td>
      </tr>
      <tr>
         <th>마감일</th>
         <td>${dto.expdate }</td>
      </tr>
      
   </table>
   
	<a href="quizUpdate?no=${dto.no }">수정</a> |
	<a href="quizDelete?no=${dto.no }">삭제</a> |
	<a href="board">리스트</a>
</body>
</html>