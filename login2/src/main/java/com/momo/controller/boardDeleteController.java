package com.momo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.momo.dao.BoardDao;


@WebServlet("/delete")
public class boardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		System.out.println("boardDeleteController-num값 :"+num);
		BoardDao dao = new BoardDao();
		int res = dao.deleteBoard(num);
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("<script>");
		response.getWriter().append("alert(res+'건이 삭제되었습니다.');");
		response.getWriter().append("history.back();");
		response.getWriter().append("</script>");

		response.sendRedirect("/list");

}
}