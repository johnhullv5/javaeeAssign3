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
@WebServlet("/YogaController")
public class YogaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public YogaController() {
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
		// TODO Auto-generated method stub
		// doGet(request, response);
		String action = request.getParameter("action");
		System.out.println(action);
		String base = "/";
		String url = base + "Show.jsp";
		if (action != null) {
			switch (action) {
			case "Cancle":
				break;
			case "YogaController":
				createYogaBean(request, response);
				break;
			}

		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.include(request, response);
	}

	private void createYogaBean(HttpServletRequest request, HttpServletResponse response) {
		YogaBean yogaBean = new YogaBean();
		ServletContext sc = request.getServletContext();
		String username = (String) sc.getAttribute("username");
		yogaBean.setUserName(username);
		yogaBean.setName(request.getParameter("name"));
		yogaBean.setEmail(request.getParameter("email"));
		yogaBean.setContactNumber(request.getParameter("contactNumber"));
		yogaBean.setGender(request.getParameter("gender"));
		yogaBean.setAge(Integer.valueOf(request.getParameter("age")));
		yogaBean.setTiming(request.getParameter("time"));
		yogaBean.setTutor(request.getParameter("course"));
		yogaBean.setCityName(request.getParameter("city"));
		try {
			DatabaseDAO databaseDAO = new DatabaseDAOImpl();
			databaseDAO.inserYogaClass(yogaBean);
			request.setAttribute("yogaBean", yogaBean);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
