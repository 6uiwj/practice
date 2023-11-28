package com.momo.dao;

import java.sql.SQLException;

import com.login.common.DBConnPool;
import com.momo.dto.MemberDto;

public class MemberDao extends DBConnPool{

		public MemberDto login(String id, String pw) {
			MemberDto memberDto = new MemberDto();
			String sql = "select  * \r\n"
					+ "from    member\r\n"
					+ "where   id = ?\r\n"
					+ "and     pass = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					memberDto.setId(rs.getString(1));
					memberDto.setPass(rs.getString(2));
				
					return memberDto;
				} else {
					System.out.println("DB에 정보가 없어요!!!");
					return null;
				}
			} catch (SQLException e) {
				System.out.println("MemberDao - 응 니쿼리 망했어");
				e.printStackTrace();
				return null;
			}
			
		
		}
}
