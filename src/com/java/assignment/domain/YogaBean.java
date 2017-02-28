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
package com.java.assignment.domain;

public class YogaBean {
	
	private String userName;
	
	private String realName;
	
	private String email;
	
	private String contactNumber;
	
	private String gender;
	
	private Integer age;
	
	private String timing;
	
	private String tutor;
	
	private String cityName;

	public String getRealName() {
		return realName;
	}

	public void setRealName(String name) {
		this.realName = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	@Override
	public String toString() {
		return "YogaBean [age=" + age + ", contactNumber=" + contactNumber + ", email=" + email + ", gender=" + gender
				+ ", realName=" + realName + ", timing=" + timing + ", tutor=" + tutor + ", city=" + cityName +"]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String city) {
		this.cityName = city;
	}
	
	

}
