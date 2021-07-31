package com.example.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.dto.UserData;
import com.example.models.DataBase;

/**
 * Servlet implementation class Welcome
 */

public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserData udDb= new UserData();;
	DataBase db;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		int age = 23;
		String place = "namakkal";
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		// for get entered user name
		UserData udlogin = new UserData();
		// for get details from database
		
		// set name to user data(udlogin)
		udlogin.setUser(name);
		db=new DataBase();
		//System.out.println("user name  "+udlogin.getUser());

		udDb=db.UserLogDetails(udlogin.getUser());
		//System.out.println("user "+udDb.getUser());
		
		// get data from db
		String nameDb = udDb.getUser();
		String passDb = udDb.getPassWord();
		//System.out.println("nameDb "+nameDb);
	//	System.out.println(passDb);
		if ((name.equals(nameDb)) && (pass.equals(passDb))) {
			rd = request.getRequestDispatcher("Index.jsp");
			// System.out.println("user correct " + name);
			// System.out.println("password correct " + pass);
			session.setAttribute("name", name);
			session.setAttribute("age", age);
			session.setAttribute("place", place);
			Cookie c1 = new Cookie("cook", "work");
			Cookie c2 = new Cookie("Develope", "job");
			c1.setSecure(true);
			c1.setMaxAge(5 * 60);
			response.addCookie(c1);
			response.addCookie(c2);
			rd.forward(request, response);
		} else {
			//System.out.println(nameDb);
			//System.out.println(passDb);
			rd = request.getRequestDispatcher("Index.html");
			pw.write("<html>");
			pw.write("<head>");
			pw.write("</head>");
			pw.write("<body>");
			pw.write("<h1 style='color:Maroon'>");
			pw.write("invalid UserName and Password !!!");
			pw.write("</h1>");
			pw.write("</body>");
			pw.write("</html>");
			rd.include(request, response);
		}
	}

}
