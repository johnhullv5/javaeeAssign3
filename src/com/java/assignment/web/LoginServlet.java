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
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.assignment.db.DatabaseDAO;
import com.java.assignment.db.DatabaseDAOImpl;
import com.java.assignment.domain.UserInfo;
import com.java.assignment.helper.Helper;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @see HttpServlet#HttpServlet()
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		DatabaseDAO databaseDAO = new DatabaseDAOImpl();
		// calling DAO method to retrieve bookList from Database
		List<UserInfo> users = databaseDAO.getAllUsers();

		Map<String, String> usersMap = Helper.mapListUsersToMap(users);
		ServletContext context = config.getServletContext();
		context.setAttribute("users", usersMap);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("LoginForm.jsp");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		System.out.println(action);
		String base = "/";
		String url = "";

		if (action != null) {
			switch (action) {
			case "LoginServlet":
				url = loginIntoSystem(request, response,base);
				
				break;
			case "SignUpServlet":
				url = base + "SignUp.html";
				break;
			case "cancleServlet":
				 url = base + "Logout.jsp";
				break;
			}
		}
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
		requestDispatcher.forward(request, response);

		// if(request.getParameter("signIn")!=null)
		// {
		// if (dataLayer.containUser(username) &&
		// dataLayer.checkPasswd(username, pass)) {
		// Cookie loginCookie = new Cookie("user", username);
		// loginCookie.setMaxAge(30 * 60);
		// response.addCookie(loginCookie);
		// //response.sendRedirect("DirectServlet");
		// RequestDispatcher view=request.getRequestDispatcher("/Show.jsp");
		// view.forward(request,response);
		//
		// } else {
		// RequestDispatcher rd =
		// getServletContext().getRequestDispatcher("/Login.html");
		// PrintWriter out = response.getWriter();
		// out.println("Invalid user name or password,maybe you need sign up.");
		// rd.include(request, response);
		// }
		//
		// }
		//
		// if(request.getParameter("signUp")!=null)
		// {
		// RequestDispatcher view=request.getRequestDispatcher("/SignUp.html");
		// view.forward(request,response);
		//
		// }

	}

	private String loginIntoSystem(HttpServletRequest request, HttpServletResponse response,String base)
			throws ServletException, IOException {
		String url = "";
		try {
			String username = request.getParameter("username");
			String pass = request.getParameter("password");
			ServletContext sc = request.getServletContext();

			Map<String, String> users = (Map<String, String>) sc.getAttribute("users");
			if (users.keySet().contains(username)) {
				if (pass.equals(users.get(username))) {
					sc.setAttribute("username", username);
//					RequestDispatcher view = request.getRequestDispatcher("Show.jsp");
//					view.forward(request, response);
					url = base + "Show.jsp";

				} else {
					PrintWriter out = response.getWriter();
					out.println("your password is not correct.");
//					RequestDispatcher rd = request.getRequestDispatcher("LoginForm.jsp");
//					rd.include(request, response);
					url = base + "LoginForm.jsp";

				}

			} else {
				PrintWriter out = response.getWriter();
				out.println("no username existed in our system.");
//				RequestDispatcher rd = request.getRequestDispatcher("LoginForm.jsp");
//				rd.include(request, response);
				url = base + "LoginForm.jsp";
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return url;

	}

}
