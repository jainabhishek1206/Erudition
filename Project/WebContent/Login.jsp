<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>    Welcome to HomePage</h1></center>
<br>
<center><h2>Sign In to Continue</h2></center>


<form action="SignIn" method="post">
<h7> 
<font color="red"> *${login } </h7>
</font>
 
<br>
<br>
<h3>
<center>Enter Username <input type="text" name="username"> <br>
Enter password  <input type="password" name="password"> <br>
<br>
<input type = "submit" value = "            SignIn                " />

<br></form> <form action="regist.jsp" method="post">
<input type = "submit" value = "Register a New Account" /></center>
</form>
</body>
</html>