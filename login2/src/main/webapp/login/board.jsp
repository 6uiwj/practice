<%@page import="com.momo.dao.BoardDaoOrder"%>
<%@page import="com.momo.dto.Criteria"%>
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
	
.page-link {
    display: block;
    padding: 10px;
    background-color: #35363a; /* 페이지 링크의 배경색 */
    color: #c4c4c4; /* 페이지 링크의 텍스트 색상 */

}
nav {
    display: flex;
    justify-content: center;
}
.container-fluid {
   background-color: #35363a; /* 페이지 링크의 배경색 */
    color: #c4c4c4; /* 페이지 링크의 텍스트 색상 */
}

</style>


</head>
<body style ="background-color :#31333a;" >
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






<br>
<p style ="color: #b6b6b6;">
<form action="" method="get" name="loginForm">
<h6 style ="color: #b6b6b6;">&nbsp&nbsp&nbsp&nbsp접속 정보
<c:if test="${not empty id }">
${id}님 환영합니다! 
	<button id=logoutBtn>로그아웃</button>
</c:if>
&nbsp&nbsp&nbsp&nbsp로그인이 필요합니다.

<c:if test="${empty id }">
<button id=loginBtn>로그인</button>	
</c:if>
</form>
</h6>
</p>
<br>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">MING</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Notice</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Category
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
       
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
<br>
<h4 style ="color: #d2d3d6;">&nbsp&nbsp&nbsp&nbsp게시글 목록</h4>
<div id="container">
<table class="table table-dark table-striped">
  <thead>
    <tr>
      <th scope="col">게시글 번호</th>
      <th scope="col">제목</th>
      <th scope="col">내용</th>     
      <th scope="col">작성자</th>
      <th scope="col">등록일</th>
      <th scope="col">조회수</th>
      
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
	  <td><%= dto.getContent()%></td>
      <td><%=dto.getId() %></td>
      <td><%=dto.getPostdate() %></td>
      <td><%= dto.getVisitcount()%></td>      
    </tr>
 <% 	} 
} else {
	out.print("<tr><td colspan='6'>조회 결과가 없습니다.</td></tr>");
	
} %>
  </tbody>
</table>

</div>

<%@include file="pageNavi.jsp" %>

</body>
</html>