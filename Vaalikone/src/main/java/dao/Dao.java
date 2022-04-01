package dao;

import java.sql.DriverManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.questions;

import java.sql.Connection;

public class Dao {
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public Dao(String url, String user, String pass) {
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
	@SuppressWarnings("deprecation")
	public boolean getConnection() {
		try {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	                throw new SQLException(e);
	            }
	            conn = DriverManager.getConnection(url, user, pass);
	        }
	        return true;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public ArrayList<questions> readAllQuestions() {
		ArrayList<questions> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from kysymys");
			while (RS.next()){
				questions f=new questions();
				f.setId(RS.getInt("id"));
				f.setQuestion(RS.getString("kysymykset"));
				list.add(f);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}


//	public questions readQuestion(String id) {
//		questions f=null;
//		try {
//			String sql="select * from kysymys where id=?";
//			PreparedStatement pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			ResultSet RS=pstmt.executeQuery();
//			while (RS.next()){
//				f=new questions();
//				f.setId(RS.getInt("id"));
//				f.setQuestion(RS.getString("kysymys"));
//			}
//			return f;
//		}
//		catch(SQLException e) {
//			return null;
//		}
//	}
}