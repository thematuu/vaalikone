package dao;

import java.sql.DriverManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.questions;
import data.User;
import data.kysymys;
import data.MD5;
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
	
	public ArrayList<kysymys> readAllKysymys() {
		ArrayList<kysymys> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from kysymys");
			while (RS.next()){
				kysymys k=new kysymys();
				k.setId(RS.getInt("id"));
				k.setkysymykset(RS.getString("kysymykset"));
				list.add(k);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<kysymys> updateKysymys(kysymys k) {
		try {
			System.out.println(k.getkysymykset());
			System.out.println(k.getId());
			String sql="update kysymys set kysymykset=? where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, k.getkysymykset());
			pstmt.setInt(2, k.getId());
			pstmt.executeUpdate();
			return readAllKysymys();
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<kysymys> deleteKysymys(String id) {
		try {
			String sql="delete from kysymys where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			return readAllKysymys();
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	public ArrayList<kysymys> AddKysymys(String question) {
		try {
			String sql="INSERT INTO kysymys (kysymykset) values(?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, question);
			pstmt.executeUpdate();
			return readAllKysymys();
		}
		catch(SQLException e) {
			return null;
		}
	}
}
