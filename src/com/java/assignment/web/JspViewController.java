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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.assignment.db.DatabaseDAO;
import com.java.assignment.db.DatabaseDAOImpl;
import com.java.assignment.domain.YogaBean;

/**
 * Servlet implementation class Registra
 */
@WebServlet("/JspViewController")
public class JspViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JspViewController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String base = "/";
		String url = base + "Show.jsp";
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "OK&Logout":
				url = base + "Logout.jsp";
				break;
			case "Update":
				url = base + "Registration.jsp";
				break;
			case "Delete":
				deleteOneYogaClass(request, response);
				break;
			case "CancleUpate":
				break;

			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.include(request, response);

	}

	//delete one yogaclass from database.
	private void deleteOneYogaClass(HttpServletRequest request, HttpServletResponse response) {
		ServletContext sc = request.getServletContext();
		String username = (String) sc.getAttribute("username");

		try {
			DatabaseDAO databaseDAO = new DatabaseDAOImpl();
			databaseDAO.deleteYogaBeanByUserName(username);

			sc.setAttribute("yogaBean", null);

			System.out.println("db delete done.");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
