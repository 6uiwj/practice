package com.momo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.login.common.DBConnectionMain;

public class TestData extends DBConnectionMain {

	
	public int seqVal() {
		String sql = "select seq_board_num.nextval from dual";
		int num = 0;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			//System.out.println("seq nextVarl : " +rs.getString(1));
				
			
		} catch (SQLException e) {
			System.out.println("testData - seqVal담기 실패");
			e.printStackTrace();
		}
		return num;
	}
	
	public int dummy() {
	TestData td = new TestData();	
	String sql = "insert into board  (num, title, content, id, postdate, visitcount) \r\n"
			+ "	values (seq_board_num.nextval, ?, ?, 'test', sysdate, 0)\r\n"
			+ "";
	int res=0;
	try {
		pstmt = con.prepareStatement(sql);
		for(int i = seqVal(); i<seqVal()+1; i++ ) {
			String t1 = "제목";
			String num = String.valueOf(i);
			String t2 = "입니다";
			String title = t1+num+t2;
			//System.out.println("title : "+ title);
			
			String c1="내용";
			String c2="입니다";
			String content = c1+num+c2;
			//System.out.println("content : " + content);
		pstmt.setString(1,title );
		pstmt.setString(2, content);
		res = pstmt.executeUpdate();
		
	} 
		System.out.println(res+"건이 업데이트 되었습니다.");
	}catch (SQLException e) {
		System.out.println("dummy생성실패");
		e.printStackTrace();
	}
	return res;
	}

	public static void main(String[] args) {
		TestData td = new TestData();
		for(int i=0; i<50; i++) {
		td.dummy();
		}
	}
}
