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

import java.util.List;

import com.java.assignment.domain.User;
import com.java.assignment.domain.UserInfo;
import com.java.assignment.domain.YogaBean;
//Interface includes List and methods
public interface DatabaseDAO {
	
	public List<UserInfo> getAllUsers();
	
	public void insertUser(User user);
	
	public void inserYogaClass(YogaBean yogabean);
	
	public YogaBean getYogaBeanByUserName(String userName);
	
	public void deleteYogaBeanByUserName(String userName);
	
	public void updateYogaBean(YogaBean yogabean);
	
	

}
