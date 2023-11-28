package com.login.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.momo.dao.BoardDao;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/view")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		BoardDao dao = new BoardDao();
		request.setAttribute("detail",dao.getOnt(num));
		dao.close();
		System.out.println("BoardDetailController - getOne 조회 성공");
		request.getRequestDispatcher("/login/boardView.jsp").forward(request, response);
	}



}
