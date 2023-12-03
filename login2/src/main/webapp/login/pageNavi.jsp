<%@page import="com.momo.dto.PageDto"%>
<%@page import="com.momo.dto.Criteria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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


</style>

</head>
<body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

<!-- 페이지 네비게이션작성 -->
<%
	//int totalCnt =100;
	//Criteria cri = new Criteria();
//	int blockStartNo = 0;
//	int blockEndNo = 0;
	//cri.setPageNo(13);
	PageDto pageDto = null;

	if(request.getAttribute("pageDto")!=null
			&& !"".equals(request.getAttribute("pageDto"))) {
		pageDto = (PageDto)request.getAttribute("pageDto");
	} else {
		//pageDto에 설정값이 없다면 기본으로 지정해줄 default값 지정?
		pageDto = new PageDto(0, new Criteria());
	}
		
	//

	
//	if(request.getAttribute("cri")!= null && !"".equals(request.getAttribute("cri"))){
//		cri = (Criteria)request.getAttribute("cri");
		//out.print("<br>요청 페이지 번호 - pageNo : " + cri.getPageNo());
		//out.print("<br>페이지당 게시물 수 - amount : " + cri.getAmount());

//	}
	
//	if(request.getAttribute("totalCnt")!= null && !"".equals(request.getAttribute("totalCnt"))){
//		totalCnt = Integer.parseInt(request.getAttribute("totalCnt").toString());
		//out.print("<br>총 게시물의 수 - totalCnt : " + totalCnt);

	
//
//		out.print("<a href = '/list?pageNo="+i+"'>"+i+"</a>"+" ");
//	}
%> 
	<nav aria-label="Page navigation example">
	  <ul class="pagination">
	  <!-- prev버튼 -->
	    <li class="page-item <%= pageDto.isPrev()? "" : "disabled" %>">
	    	<a class="page-link" href="/list?pageNo=<%=pageDto.getBlockStartNo()-1%>">Previous</a></li>
	  <!-- prev버튼 끝 -->
<% 
	for(int i=pageDto.getBlockStartNo(); i<=pageDto.getBlockEndNo(); i++){
			  
		  out.print("<li class='page-item'>");
	  out.print("<a class = 'page-link' href='/list?pageNo="+i+"'>"+i+"</a>");
			out.print("</li>");
	
}
	//for(i=페이지블럭의 시작번호 ; i<= 페이지블럭의 끝번호 ;i++) {
	//	<a href=/boardList?pageNo=페이지넘버>i</a>
	//}
%>
	<!-- next버튼 -->
	    <li class="page-item <%=pageDto.isNext()? "" : "disabled"%>">
	    	<a class="page-link" href="/list?pageNo=<%=pageDto.getBlockEndNo()+1%>">Next</a></li>
	  </ul>
	<!--  next버튼 끝 -->
	</nav>

</body>
</html>