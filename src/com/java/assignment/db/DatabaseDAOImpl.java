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
package com.java.assignment.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.assignment.domain.User;
import com.java.assignment.domain.UserInfo;
import com.java.assignment.domain.YogaBean;

public class DatabaseDAOImpl implements DatabaseDAO {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
		}
	}
	//set URL, User, Password for My SQL
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
	}
	//set Exception and close connection
	private void closeConnection(Connection connection) {
		if (connection == null)
			return;
		try {
			connection.close();
		} catch (SQLException ex) {
		}
	}
	
	 //method shows all user information 
	@Override
	public List<UserInfo> getAllUsers() {
		//instantiate List to insert user Information 
		List<UserInfo> results = new ArrayList<UserInfo>();

		String sql = "select * from userInfo ";

		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				UserInfo user = new UserInfo();
				user.setUserName(resultSet.getString("username"));
				user.setPassword(resultSet.getString("passwd"));
				results.add(user);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return results;

	}

	 //method to insert new user's information(name, password) into Database
	@Override
	public void insertUser(User user) {
		
		String sql = "insert into UserInfo (username,passwd) values(?,?)";
		Connection connection = null;
		
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
			statement.execute();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		
		
		
		

	}

	//method to insert new user's all information into Database
	@Override
	public void inserYogaClass(YogaBean yogabean) {
		String sql = "insert into yogaclass (username,realname,email,contactnumber,gender,age,timing,tutor,city) values(?,?,?,?,?,?,?,?,?);";
		Connection connection = null;
		
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, yogabean.getUserName());
			statement.setString(2, yogabean.getRealName());
			statement.setString(3, yogabean.getEmail());
			statement.setString(4, yogabean.getContactNumber());
			statement.setString(5, yogabean.getGender());
			statement.setInt(6,yogabean.getAge());
			statement.setString(7,yogabean.getTiming());
			statement.setString(8,yogabean.getTutor());
			statement.setString(9,yogabean.getCityName());
			
			statement.execute();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}

	}

	//method to show user's information from yogaclass
	@Override
	public YogaBean getYogaBeanByUserName(String userName) {
		List<YogaBean> results =  new ArrayList<YogaBean>();
		
		String sql = "select * from yogaclass where username = ? ";

		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userName);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				YogaBean yogaClass = new YogaBean();
				yogaClass.setUserName(resultSet.getString("username"));
				yogaClass.setRealName(resultSet.getString("realname"));
				yogaClass.setEmail(resultSet.getString("email"));
				yogaClass.setGender(resultSet.getString("gender"));
				yogaClass.setContactNumber(resultSet.getString("contactnumber"));
				yogaClass.setTiming(resultSet.getString("timing"));
				yogaClass.setTutor(resultSet.getString("tutor"));
				yogaClass.setAge(resultSet.getInt("age"));
				yogaClass.setCityName(resultSet.getString("city"));
				
				

				results.add(yogaClass);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		
		if(results.size()>0)
		{
			return results.get(0);
		}
		else
		{
			return null;
		}
	}
	//method to delete user's information from yogaclass
	@Override
	public void deleteYogaBeanByUserName(String userName) {
		String sql = "delete from yogaclass where username = ?";
		Connection connection = null;
		
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userName);
			statement.execute();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
			
		}

	}
	

	 //method to update user information in yogaclass
	@Override
	public void updateYogaBean(YogaBean yogabean) {
		String sql = "update yogaclass set realname=?,"+"email=?,"+"contactnumber=?,"+"gender=?,"+"age=?,"
						+"timing=?,"+"tutor=?,"+"city=? where username=?;";
		Connection connection = null;
		
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, yogabean.getRealName());
			statement.setString(2, yogabean.getEmail());
			statement.setString(3, yogabean.getContactNumber());
			statement.setString(4, yogabean.getGender());
			statement.setInt(5, yogabean.getAge());
			statement.setString(6, yogabean.getTiming());
			statement.setString(7, yogabean.getTutor());
			statement.setString(8, yogabean.getCityName());
			statement.setString(9, yogabean.getUserName());
			statement.execute();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
			
		}


	}

}
