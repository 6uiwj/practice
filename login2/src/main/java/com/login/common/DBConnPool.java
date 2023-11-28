package com.login.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnPool {
	public Connection con;
	public Statement stmt;
	public PreparedStatement pstmt;
	public ResultSet rs;
	public DBConnPool() {
	try {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		
		con = ds.getConnection();
		System.out.println("DB연결 성공");
	} catch (NamingException e) {
		System.out.println("DBConnPool - NamingException 발생");
		e.printStackTrace();
	} catch (SQLException e) {
		System.out.println("DBConnPool - SQLExeption발생");
		e.printStackTrace();
	}
}
	
	public void close() {
			try {
				if(rs != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
				System.out.println("ConnPool 자원반납성공");
			} catch (SQLException e) {
				System.out.println("ConnPool 자원반납 중 오류 발생");
				e.printStackTrace();
			}
		
	}
	


}
