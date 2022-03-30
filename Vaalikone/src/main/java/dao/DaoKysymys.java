package dao;

import java.sql.DriverManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.kysymys;

import java.sql.Connection;

public class DaoKysymys {
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public DaoKysymys(String url, String user, String pass) {
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
	public ArrayList<kysymys> readAllkysymys() {
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

}
