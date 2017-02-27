/*
 * Copyright 2017 (C) <Centennial College> COMP303-assign3
 * 
 * Created on : 24-02-2017
 * Author     : Hao Jiang (300858525)
 *
 *-----------------------------------------------------------------------------
 * Revision History (Release 1.0.0.0)
 *-----------------------------------------------------------------------------
 */
package com.java.assignment.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.assignment.db.DatabaseDAO;
import com.java.assignment.db.DatabaseDAOImpl;
import com.java.assignment.domain.User;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("SignUp.html");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		String rePass = request.getParameter("repassword");
		String action = request.getParameter("action");
		String base = "/";
		String url = base + "Show.jsp";

		if (!pass.equals(rePass)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/SignUp.html");
			PrintWriter out = response.getWriter();
			out.println("password missmatch!");
			rd.include(request, response);
			return;

		}
		User user = new User();
		user.setUserName(username);
		user.setPassword(pass);
		RequestDispatcher rd = null;

		if (action != null) {
			switch (action) {
			case "Cancle":
				url = base + "Logout.jsp";
				rd = request.getRequestDispatcher(url);
				rd.include(request, response);
				break;
			case "Sign up":
				try {
					DatabaseDAO databaseDAO = new DatabaseDAOImpl();
					databaseDAO.insertUser(user);
					ServletContext sc = request.getServletContext();
					sc.setAttribute("username", username);
					rd = request.getRequestDispatcher(url);
					rd.include(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

}
