<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="all" align="center">
<h1>LogIn Form</h1><br>

<form action="LoginServlet" method=post text-align: center>
Your Name<input type="text" name="username"/><br>
&thinsp;&thinsp;&thinsp;PassWord<input type="password" name="password"/><br>
<button type="submit" style="background-color:#4CAF50;color:white;" id="liginBTN" name="action" value="LoginServlet">LogIn</button>
<button type="submit" style="background-color:#6A5ACD;color:white;" id="registerBTN" name="action" value="SignUpServlet">Sign Up</button>
<button type="submit" style="background-color:#f44336;color:white;" id="cancelBTN" name="action" value="cancleServlet">Cancel</button>
</form>
</div>
</body>
</html>