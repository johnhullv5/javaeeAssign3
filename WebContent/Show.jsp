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
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%!ServletContext sc;%>
	<%!String username;%>
	<%
		sc = request.getServletContext();
	%>
	<%
		username = (String) sc.getAttribute("username");
	%>
	<p>
		Welcome ,<%=username%>
	</p>

	<form action="DirectServlet" method=post>

		<button type="submit" style="background-color: #4CAF50; color: white;"
			id="liginBTN" name="action" value="view">view</button>
		<button type="submit" style="background-color: #6A5ACD; color: white;"
			id="registerBTN" name="action" value="create">create</button>
			
			<button type="submit" style="background-color:#f44336;color:white;"
			id="logoutBTN" name="action" value="logout">quit</button>
	</form>


</body>
</html>