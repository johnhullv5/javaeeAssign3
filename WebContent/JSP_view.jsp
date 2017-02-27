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
<%@ page language="java" import="com.java.assignment.domain.YogaBean" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Information</title>
</head>
<body>
<%!YogaBean bean; %>
<%! ServletContext sc;%>
<% sc = request.getServletContext();%>
<% bean = (YogaBean)sc.getAttribute("yogaBean");%>
<jsp:useBean id="yogaBean" class="com.java.assignment.domain.YogaBean" scope="application" />


<% if(bean==null){%>
   <%  out.print("I see! You don't have a record.. well..let us create one!"); %> 
   <form action="DirectServlet" method=post>
<button type="submit" id="createBTN"  style="background-color: #4CAF50; color: white;" align="right" name="action" value="create">Create!</button>
<button type="submit" id="logoutBTN"  style="background-color:#f44336;color:white;" align="right" name="action" value="logout">logout</button>
</form> 
<% } 
else {%>
  <div id="all" align="center">

<p>Welcome,${yogaBean.userName}</p>


<br>
<p>Your registration details are as follows:</p>
<p>Email Address: ${yogaBean.email}</p>
<p>Phone Number: ${yogaBean.contactNumber}</p>
<p>Gender: ${yogaBean.gender}</p>
<p>Age: ${yogaBean.age}</p>
<p>Batch: ${yogaBean.timing}</p>
<p>Yoga: ${yogaBean.tutor}</p>
<p>City: ${yogaBean.cityName}</p>




<h3>Your online registration completed.</h3><br>
<h3>Class will be starting soon.</h3>
<form action="DirectServlet" method=post>
<button type="submit" style="background-color:#4CAF50;color:white;" id="viewBTN" align="left" name="action" value="OK&Logout">OK&Logout</button>
<button type="submit" style="background-color:#6A5ACD;color:white;" id="editBTN" align="center" name="action" value="Update">Update</button>
<button type="submit" style="background-color:#f44336;color:white;" id="deleteBTN" align="right" name="action" value="Delete">Delete</button>
</form>
<% } %>




</div>
</body>

</html>