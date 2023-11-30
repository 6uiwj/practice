package com.momo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.common.DBConnPool;
import com.momo.dto.BoardDto;

public class BoardDao extends DBConnPool{
	public List<BoardDto> getList(){
		List<BoardDto> list = new ArrayList<>();
		String sql="select * from board";
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				BoardDto dto = new BoardDto();
				dto.setNum(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setId(rs.getString(4));
				dto.setPostdate(rs.getString(5));
				dto.setVisitcount(rs.getString(6));
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("BoardDao - 쿼리조졌어..또...");
			e.printStackTrace();
			return null;
		}
		return list;
		
	}
	
	public BoardDto getOnt(String num) {
		BoardDto dto = new BoardDto();
		String sql = "select * from board where num=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setNum(rs.getString("num"));
				dto.setPostdate(rs.getString("postdate"));
				dto.setVisitcount(rs.getString("visitcount"));

			}
			
		} catch (SQLException e) {
			System.out.println("쿼리조회가 실패했습니다.");
			e.printStackTrace();
		}
		return dto;
	}
	
	public int deleteBoard(String num) {
		String sql = "delete board where num=?";
		int res = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			res = pstmt.executeUpdate();
			System.out.println("BoardDao -" +res+"건이 삭제되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	
	
}
