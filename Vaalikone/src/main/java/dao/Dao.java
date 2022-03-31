package dao;

import java.sql.DriverManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.User;
import data.MD5;
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
}