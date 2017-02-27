<!-- 
 *
 * Copyright 2017 (C) <Centennial College> COMP303-assign3
 * 
 * Created on : 25-02-2017
 * Author     : Chinatsu Kawakami (300821245)
 *
 *-----------------------------------------------------------------------------
 * Revision History (Release 1.0.0.0)
 *-----------------------------------------------------------------------------
 *
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.java.assignment.domain.YogaBean"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%!YogaBean bean; %>
<%! ServletContext sc;%>
<% sc = request.getServletContext();%>
<% bean = (YogaBean)sc.getAttribute("yogaBean");%>

<div id="all" align="center">
<h1>Yoga Class Registration</h1>
<br>
<form action="JspViewController" method=post>
<input type="text" value=<%= bean.getName()%> name="name" size=50/><br>
<input type="text" value=<%= bean.getEmail()%> name="email" size=50/><br>
<input type="text" value=<%= bean.getContactNumber() %> name="contactNumber" size=50/><br>
<b>Gender</b><br>
<input type="radio" name="gender" value="Male" <% if(bean.getGender().equals("Male")){out.print("checked=\"checked\"");}%> />Male

<input type="radio" name="gender" value="Female" <% if(bean.getGender().equals("Female")){out.print("checked=\"checked\"");}%> />Female<br>
<input type="text" value=<%=bean.getAge().toString() %> name="age" size=50><br>
<b>Batch That fits your timing!</b><br>
&thinsp;&thinsp;<input type="radio" name="time" value="Morning 6:30 to 8:30" <% if(bean.getTiming().equals("Morning 6:30 to 8:30")){out.print("checked=\"checked\"");}%>/>Morning 6:30 to 8:30
<br>
&thinsp;&thinsp;&thinsp;&thinsp;<input type="radio" name="time" value="Morning 8:30 to 10:30" <% if(bean.getTiming().equals("Morning 8:30 to 10:30")){out.print("checked=\"checked\"");}%>/>Morning 8:30 to 10:30
<br>
<input type="radio" name="time" value="Evening 4:30 to 6:30" <% if(bean.getTiming().equals("Evening 4:30 to 6:30")){out.print("checked=\"checked\"");}%>/>Evening 4:30 to 6:30
<br>
<input type="radio" name="time" value="Evening 6:30 to 8:30" <% if(bean.getTiming().equals("Evening 6:30 to 8:30")){out.print("checked=\"checked\"");}%>/>Evening 6:30 to 8:30
<br>
<b>Yoga you want to register for!</b><br>
&thinsp;&thinsp;&thinsp;&thinsp;<input type="checkbox" name="course" value="Anusara" <% if(bean.getTutor().equals("Anusara")){out.print("checked=\"checked\"");}%>/>Anusara<br>
&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;<input type="checkbox" name="course" value="Ashtanga" <% if(bean.getTutor().equals("Ashtanga")){out.print("checked=\"checked\"");}%>/>Ashtanga<br>
&thinsp;&thinsp;<input type="checkbox" name="course" value="Bikram" <% if(bean.getTutor().equals("Bikram")){out.print("checked=\"checked\"");}%>/>Bikram<br>
<input type="checkbox" name="course" value="Power" <% if(bean.getTutor().equals("Power")){out.print("checked=\"checked\"");}%> />Power<br>
&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;<input type="checkbox" name="course" value="Jivamukti" <% if(bean.getTutor().equals("Jivamukti")){out.print("checked=\"checked\"");}%>/>Jivamukti<br>
&thinsp;&thinsp;&thinsp;<input type="checkbox" name="course" value="Kundlini" <% if(bean.getTutor().equals("Kundlini")){out.print("checked=\"checked\"");}%>/>Kundlini<br>
<input type="text" value=<%= bean.getCityName().toString() %> name="city" size=50><br><br>
<button type="submit" style="background-color:#f44336;color:white;" id="submitBTN" name="action" value="YogaController">Update Registration!</button>
<button type="submit" style="background-color:#4CAF50;color:white;" id="cancleBTN" align="left" name="action" value="CancleUpate">cancle</button>
</form>
</div>
</body>
</html>