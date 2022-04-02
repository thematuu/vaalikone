package dao;

import java.sql.DriverManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.questions;
import data.User;
import java.sql.Connection;
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
	public String readUser(String username) {
		String f=null;
		try {
			String sql="select * from adminlogin where username=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				f = RS.getString("password");
			}
			return f;
		}
		catch(SQLException e) {
			return null;
		}
	}
	
//	public ArrayList<kysymys> readAllKysymys() {
//		ArrayList<kysymys> list=new ArrayList<>();
//		try {
//			Statement stmt=conn.createStatement();
//			ResultSet RS=stmt.executeQuery("select * from kysymys");
//			while (RS.next()){
//				kysymys k=new kysymys();
//				k.setId(RS.getInt("id"));
//				k.setkysymykset(RS.getString("kysymykset"));
//				list.add(k);
//			}
//			return list;
//		}
//		catch(SQLException e) {
//			return null;
//		}
//	}
	public ArrayList<questions> updateQuestion(questions q) {
		try {
			System.out.println(q.getQuestion());
			System.out.println(q.getId());
			String sql="update kysymys set kysymykset=? where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, q.getQuestion());
			pstmt.setInt(2, q.getId());
			pstmt.executeUpdate();
			return readAllQuestions();
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<questions> deleteQuestion(String id) {
		try {
			String sql="delete from kysymys where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			return readAllQuestions();
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	public ArrayList<questions> showCandidates() {
		ArrayList<questions> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from ehdokas");
			while (RS.next()){
				questions f=new questions();
				f.setId(RS.getInt("id"));
				f.setQuestion(RS.getString("ehdokas"));
				list.add(f);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<questions> AddQuestion(String question) {
		try {
			String sql="INSERT INTO kysymys (kysymykset) values(?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, question);
			pstmt.executeUpdate();
			return readAllQuestions();
		}
		catch(SQLException e) {
			return null;
		}
}
}
