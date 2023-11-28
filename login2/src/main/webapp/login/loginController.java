package com.momo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.momo.dao.BoardDao;
import com.momo.dao.MemberDao;
import com.momo.dto.BoardDto;
import com.momo.dto.MemberDto;

@WebServlet("/loginProcess")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//폼을 통해 아이디 비밀번호 정보를 받아와
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		System.out.println("서버전송성공 - id : " + id);
		System.out.println("pw : " + pw);
		
		MemberDao memberDao = new MemberDao();
		//Dao.login 메서드에 id,pw를 넣은 결과를 dto객체에 저장한다.
		MemberDto memberDto =memberDao.login(id, pw);
		memberDao.close();
		//DB에 id, pw와 일치하는 정보가 있다면 session에 담는다.
		
		if(memberDto != null) {
			session.setAttribute("memberDto", memberDto);
			session.setAttribute("id", memberDto.getId());
			
			//게시글 조회 후 request에 담아주기
		//	BoardDao boardDao = new BoardDao();
		//	request.setAttribute("list", boardDao.getList());
			
			
			
			System.out.println("loginController에서 데이터 session에 담기 성공");
			//request.getRequestDispatcher("/list").forward(request, response);
			response.sendRedirect("/list");
		} else {
			System.out.println("loginController에서 데이터 session에 담기 실패");
			//request.getRequestDispatcher("/login/loginForm.jsp?isError=1").forward(request, response);
			System.out.println("로그인 실패");
			
			//방법1
			response.setContentType("text/html; charset=UTF-8");			
			
			response.getWriter().append("<script>");
			response.getWriter().append("	alert('아이디 비밀번호를 확안해주세요');");
			response.getWriter().append("history.back();");
			response.getWriter().append("</script>");
			

		}
		memberDao.close();
		
	
	}

}
