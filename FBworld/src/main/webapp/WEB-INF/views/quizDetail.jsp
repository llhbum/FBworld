<%@page import="FBworld.models.quizboardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="quizboardDTO" value="${quizboardDTO }"></c:set>
<!DOCTYPE html>
<head>
  <title>quizDetail</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<script type="text/javascript">
	var score = 6;
	
	function btnclick(hintId, hintBtnId){
		document.getElementById(hintId).setAttribute( 'type', 'text' );
		document.getElementById(hintBtnId).setAttribute( 'type', 'hidden' );
		score = score - 1;
		document.getElementById('post_score').setAttribute( 'value', score );
	}
	
	var expirecheck = "<c:out value='${quizboardDTO.expirecheck}'></c:out>";
	
	$(document).ready(function(){
		if(expirecheck === '1'){
			 document.getElementById('image_1').style.display="none";
			 document.getElementById('image_2').style.display="block";
			 document.getElementById('answer').setAttribute('readonly','readonly');
		}
		
	});

</script>
<body>
	<div class="container">
		 <div class="innerContainer">
			   <table>
			      <h1>${quizboardDTO.title }</h1>
    			  <tr>
			         <th>마감여부</th>
    					<td style="color:red">
							<c:choose>
								<c:when test="${quizboardDTO.expirecheck eq 1 }">
									마감
								</c:when>	
								
								<c:when test="${quizboardDTO.expirecheck eq 0 }">
									진행중
								</c:when>		
							</c:choose>
						</td>
			      </tr>
			      
			      <tr>
			         <th>번호</th>
			         <td>${quizboardDTO.no }</td>
			      </tr>
			      <tr>
			         <th>선수사진</th>
			         <td>
			         	 <img style="display:block" id="image_1" align="center" src="${pageContext.request.contextPath}/images/물음표.jpg"width="100%" height="500px">
			         	 <img style="display:none"  id="image_2" align="center" src="${quizboardDTO.imagepath }"width="100%" height="500px">	
			         </td>
			      </tr>
			      
   			      <tr>
			         <th>내용</th>
			         <td>${quizboardDTO.content }</td>
			      </tr>
			      
			      <tr>
			         <th>[힌트1] 포지션</th>
			         <td><input type="hidden" id="hint1" value="${quizboardDTO.hint1 }" readonly="readonly" /><input type="button" value="오픈" id="hintBtn1" onclick="btnclick('hint1','hintBtn1')"/></td>
			      </tr>
			      <tr>
			         <th>[힌트2] 태어난 년도</th>
			         <td><input type="hidden"  id="hint2"  value="${quizboardDTO.hint2 }" readonly="readonly" /><input type="button" value="오픈" id="hintBtn2" onclick="btnclick('hint2','hintBtn2')"/></td>
			      </tr>
			      <tr>
			         <th>[힌트3] 국적</th>
			         <td><input type="hidden"  id="hint3"   value="${quizboardDTO.hint3 }" readonly="readonly"  /><input type="button" value="오픈" id="hintBtn3" onclick="btnclick('hint3','hintBtn3')"/></td>
			      </tr>
			      <tr>
			         <th>[힌트4] 소속팀1</th>
			         <td><input type="hidden"  id="hint4"   value="${quizboardDTO.hint4 }" readonly="readonly"  /><input type="button" value="오픈" id="hintBtn4" onclick="btnclick('hint4','hintBtn4')"/></td>
			      </tr>
			      <tr>
			         <th>[힌트5] 소속팀2</th>
			         <td><input type="hidden"  id="hint5"  value="${quizboardDTO.hint5 }" readonly="readonly" /><input type="button" value="오픈" id="hintBtn5" onclick="btnclick('hint5','hintBtn5')"/></td>
			      </tr>
			      
			      <tr>
			         <th>정답</th>
			         <td>
				         <form action="answer" method="post">
					          <input id="answer" type="text" value="" name ="answer" >
					          <input type="hidden" value="${quizboardDTO.no }"  name ="no">
					          <input type="hidden" value="6" id="post_score" name ="score">
					          <input type ="submit" value="제출">
	         			</form>
         			</td>
			      </tr>
			      <tr>
			         <th>조회수</th>
			         <td>${quizboardDTO.readcount }</td>
			      </tr>
			      <tr>
			         <th>마감일</th>
			         <td>${quizboardDTO.expdate }</td>
			      </tr>
			   </table>
			   
				<a href="quizUpdate?no=${quizboardDTO.no }">수정</a> |
				<a href="quizDelete?no=${quizboardDTO.no }">삭제</a> |
				<a href="board">리스트</a>
			</div>
	</div>
</body>
</html>