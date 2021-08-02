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
		String user;
		String name;
		Connection conn;
		Statement st;
		ResultSet rs;
		udDb = new UserData();
		// System.out.println(userName);
		// System.out.println(user);
		String query = "select * from userInfo" + " where userid ='" + userName + "';";
		System.out.println(query);
		try {
			// System.out.println(query);
			Class.forName("com.mysql.cj.jdbc.Driver");
			// System.out.println(query);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// System.out.println(query);
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				// System.out.println(query);
				user = rs.getString("userid");
				udDb.setUser(user);
				name = rs.getString("name");
				udDb.setPassWord(name);
				udDb.setName(name);
				udDb.setPlace(rs.getString("place"));
				udDb.setWork(rs.getString("work"));
				udDb.setAge(rs.getString("age"));
				udDb.setGender(rs.getString("gender"));
				udDb.setAccNo(rs.getString("accNo"));
				System.out.println(udDb.getUser() + "  " + udDb.getPassWord() + "  " + udDb.getName() + "  "
						+ udDb.getPlace() + "  " + udDb.getWork() + "  " + udDb.getGender() + "  " + udDb.getAge()
						+ "  " + udDb.getAccNo());

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

	public void doRegister(UserData udReg) {
		Connection conn;
		Statement st;
		// System.out.println(userName);
		// System.out.println(user);
		String query = "insert into userInfo values('" + udReg.getUser() + "','" + udReg.getPassWord() + "','"
				+ udReg.getPlace() + "','" + udReg.getWork() + "','" + udReg.getAge() + "','" + udReg.getGender()
				+ "','" + udReg.getAccNo() + "');";
		System.out.println(query);
		try {
			// System.out.println(query);
			Class.forName("com.mysql.cj.jdbc.Driver");
			// System.out.println(query);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// System.out.println(query);
			st = conn.createStatement();
			st.execute(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL exception");
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not found exception");
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DataBase db = new DataBase();
		// db.UserLogDetails("11022");
		UserData udReg = new UserData();
		udReg.setUser("userId");
		udReg.setPassWord("name");
		udReg.setPlace("place");
		udReg.setWork("work");
		udReg.setAge("age");
		udReg.setGender("gender");
		udReg.setAccNo("accNo");
		db.doRegister(udReg);
		
		// System.out.println(udDb.getUser() + "| " + udDb.getPassWord());

	}

}
