<%@page import="com.momo.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
window.onload=function(){
let deleteBtn = document.querySelector("#deleteBtn");
deleteBtn.addEventListener('click',function() {
	alert('정말 삭제하시겠습니까!!!!!');
	viewForm.action='/delete';
	viewForm.submit();
});

let goList = document.querySelector("#goList");
goList.addEventListener('click',function(){
	location.href='/list';
});
}
</script>



<h3>상세페이지야~</h3>
요청 게시글 번호 : <%=request.getParameter("num") %>
<br>
<button id="goList">리스트로 이동</button>
<form method="post" name="viewForm">
	<input type="text" name="num" value=<%=request.getParameter("num") %>>
 </form>
<%
if(session.getAttribute("id") != null) {
out.print("<button id='modityBtn'>수정</button>");
out.print("<button id='deleteBtn'>삭제</button>");
	
}
%>
<br>
<% if(request.getAttribute("detail") != null){
	BoardDto dto = (BoardDto)request.getAttribute("detail");
	System.out.println("boardView.jsp에 detail 정보 가져옴");

%>
<ul>
	<li>제목 : <%=dto.getTitle() %></li>
	<li>내용 : <%=dto.getContent() %></li>
	<li>작성자 : <%=dto.getId() %></li>
	<li>작성일 : <%=dto.getPostdate() %></li>
	<li>조회수 :<%=dto.getVisitcount() %></li>
		
</ul>

<%} %>
</body>
</html>