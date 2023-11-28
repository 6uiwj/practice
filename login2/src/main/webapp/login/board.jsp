<%@page import="com.momo.dao.BoardDao"%>
<%@page import="com.momo.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

<title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<style>
	#container {
	width: 90%;
	margin :auto;
	}

</style>


</head>
<body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

<script type="text/javascript">
window.onload = function() {
	let logoutBtn = document.querySelector("#logoutBtn");
	if(logoutBtn != null) {
		logoutBtn.onclick = function() {
			location.href="/logoutAction";
		}
	}
	
	let loginBtn = document.querySelector("#loginBtn");
	if(loginBtn != null) {
		loginBtn.addEventListener('click', function(){
			location.href="/login/loginForm.jsp";
			
		});
	}
}

</script>







<h4>접속 정보</h4>

<c:if test="${not empty id }">
${id}님 환영합니다! 
<br>
	<button id=logoutBtn>로그아웃</button>
</c:if>

<c:if test="${empty id }">
로그인이 필요합니다.
<button id=loginBtn>로그인</button>	
</c:if>

<h2>게시글 목록</h2>

<div id="container">
<table class="table table-dark table-striped">
  <thead>
    <tr>
      <th scope="col">게시글 번호</th>
      <th scope="col">제목</th>
      <th scope="col">작성자</th>
      <th scope="col">등록일</th>
    </tr>
  </thead>
  <tbody>
  <%
List<BoardDto> list = (List<BoardDto>)request.getAttribute("list");
 
if( list!=null) {
	for(BoardDto dto : list){

%>
    <tr>
      <th scope="row"><%=dto.getNum() %></th>
      <td><a href = "/view?num=<%=dto.getNum()%>"><%=dto.getTitle() %></a></td>
      <td><%=dto.getId() %></td>
      <td><%=dto.getPostdate() %></td>
    </tr>
 <% 	} 
} else {
	out.print("<tr><td colspan='3'>조회 결과가 없습니다.</td></tr>");
	
} %>
  </tbody>
</table>

</div>

</body>
</html>