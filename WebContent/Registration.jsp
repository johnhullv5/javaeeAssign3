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
<h1>Yoga Class Registration</h1>
<br>
<form action="YogaController" method=post>
<input type="text" value="your Name" name="name" size=50/><br>
<input type="text" value="Email Id" name="email" size=50/><br>
<input type="text" value="Contact Number" name="contactNumber" size=50/><br>
<b>Gender</b><br>
<input type="radio" name="gender" value="Male" />Male
<input type="radio" name="gender" value="Female"/>Female<br>
<input type="text" value="0" name="age" size=50><br>
<b>Batch That fits your timing!</b><br>
&thinsp;&thinsp;<input type="radio" name="time" value="Morning 6:30 to 8:30"/>Morning 6:30 to 8:30
<br>
&thinsp;&thinsp;&thinsp;&thinsp;<input type="radio" name="time" value="Morning 8:30 to 10:30"/>Morning 8:30 to 10:30
<br>
<input type="radio" name="time" value="Evening 4:30 to 6:30"/>Evening 4:30 to 6:30
<br>
<input type="radio" name="time" value="Evening 6:30 to 8:30"/>Evening 6:30 to 8:30
<br>
<b>Yoga you want to register for!</b><br>
&thinsp;&thinsp;&thinsp;&thinsp;<input type="checkbox" name="course" value="Anusara"/>Anusara<br>
&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;<input type="checkbox" name="course" value="Ashtanga"/>Ashtanga<br>
&thinsp;&thinsp;<input type="checkbox" name="course" value="Bikram"/>Bikram<br>
<input type="checkbox" name="course" value="Power"/>Power<br>
&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;<input type="checkbox" name="course" value="Jivamukti"/>Jivamukti<br>
&thinsp;&thinsp;&thinsp;<input type="checkbox" name="course" value="Kundlini"/>Kundlini<br>
<input type="text" value="city" name="city" size=50/><br><br>
<button type="submit" style="background-color:#4CAF50;color:white;" id="submitBTN" name="action" value="YogaController">Confirm Registration!</button>
<button type="submit" style="background-color:#f44336;color:white;" id="cancleBTN" name="action" value="Cancle">Cancle</button>
</form>
</div>
</body>
</html>