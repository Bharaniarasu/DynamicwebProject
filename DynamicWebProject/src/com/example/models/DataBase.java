package com.example.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.dto.UserData;

public class DataBase {
	private String USER = "root";
	private String PASSWORD = "wolF";
	private String URL = "jdbc:mysql://localhost:3306/login";
	UserData udlogin = new UserData();
	UserData udDb = new UserData();

	public UserData UserLogDetails(String userName) {
		String user;String pass;
		Connection conn;
		Statement st;
		ResultSet rs;
		udDb = new UserData();
		//System.out.println(userName);
		// System.out.println(user);
		String query = "select * from data" + " where userdata ='" + userName + "';";
		//System.out.println(query);
		try {
			//System.out.println(query);
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println(query);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			//System.out.println(query);
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				//System.out.println(query);
				user=rs.getString("userdata");
				udDb.setUser(user);
				pass=rs.getString("password");
				udDb.setPassWord(pass);
				//System.out.println(udDb.getUser() + " |  " + udDb.getPassWord());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL exception");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return udDb;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DataBase db = new DataBase();
		db.UserLogDetails("user");
		//System.out.println(udDb.getUser() + "| " + udDb.getPassWord());

	}

}
