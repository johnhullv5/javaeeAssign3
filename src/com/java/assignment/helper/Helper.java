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
package com.java.assignment.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.assignment.domain.UserInfo;

//helper method
public class Helper {

	//convert List to Map
	public static Map<String, String> mapListUsersToMap(List<UserInfo> users) {
		Map<String, String> usersMap = new HashMap<String, String>();

		for (UserInfo user : users) {
			if (!usersMap.keySet().contains(user.getUserName())) {
				usersMap.put(user.getUserName(), user.getPassword());
			}

		}

		return usersMap;

	}

}
