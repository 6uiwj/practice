package com.login.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.momo.dao.BoardDao;
import com.momo.dao.BoardDaoOrder;
import com.momo.dto.BoardDto;
import com.momo.dto.Criteria;

/**
 * Servlet implementation class boardListController
 */
@WebServlet("/list")
public class boardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Criteria cri = new Criteria(request.getParameter("pageNo"), request.getParameter("amount"));

		//페이지 블럭을 생성하기 위해 필요한 정보를 저장
		BoardDaoOrder dao = new BoardDaoOrder();
		request.setAttribute("list", dao.getList(cri));
		//List<BoardDto> list = dao.getList(cri);		
		//request.setAttribute("list", list);
		request.setAttribute("cri", cri);
		request.setAttribute("totalCnt", dao.totalCnt());
		System.out.println("boardListController - dao list생성성공");
		dao.close();
		//response.sendRedirect("/login/board.jsp");
		request.getRequestDispatcher("/login/board.jsp").forward(request, response);
	}



}
