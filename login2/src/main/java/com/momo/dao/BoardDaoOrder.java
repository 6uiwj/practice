package com.momo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.common.DBConnPool;
import com.momo.dto.BoardDto;
import com.momo.dto.Criteria;
import com.momo.dto.MemberDto;

public class BoardDaoOrder extends DBConnPool {
	public List<BoardDto> getList(Criteria cri){
		List<BoardDto> list = new ArrayList<>();
		String sql="select * from (select rownum rnum, t.* from (select * from board order by num) t\r\n"
				+ ") where rnum between ? and ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cri.getStartNo());
			pstmt.setInt(2, cri.getEndNo());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				BoardDto dto = new BoardDto();
				dto.setNum(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setId(rs.getString(5));
				dto.setPostdate(rs.getString(6));
				dto.setVisitcount(rs.getString(7));
				list.add(dto);
			}
			System.out.println("boardDaoOrder - list : " +list);
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
	
	public int totalCnt() {
		int res=0;
		String sql = "select count(*) from board";
		try {
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				res= rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("BoardDao - totalCnt 쿼리 실행 실패");
			e.printStackTrace();
		}
		return res;
	}
}
