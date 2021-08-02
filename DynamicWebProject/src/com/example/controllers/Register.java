package com.example.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dto.UserData;
import com.example.models.DataBase;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String place = request.getParameter("place");
		String work = request.getParameter("work");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String accNo = request.getParameter("accNo");
		System.out.println(userId+" | "+name+" | "+place+" | "+work+" | "+age+" | "+gender+" | "+accNo);
		UserData udReg=new UserData();
		udReg.setUser(userId);
		udReg.setPassWord(name);
		udReg.setPlace(place);
		udReg.setWork(work);
		udReg.setAge(age);
		udReg.setGender(gender);
		udReg.setAccNo(accNo);
		DataBase db=new DataBase();
		db.doRegister(udReg);
		
		RequestDispatcher rd = request.getRequestDispatcher("Index.html");
		rd.forward(request, response);
		
	}

}
