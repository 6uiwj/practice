package com.login.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.momo.dao.BoardDao;

/**
 * Servlet implementation class boardListController
 */
@WebServlet("/list")
public class boardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao dao = new BoardDao();
		request.setAttribute("list", dao.getList());
		dao.close();
		//response.sendRedirect("/login/board.jsp");
		request.getRequestDispatcher("/login/board.jsp").forward(request, response);
	}



}
