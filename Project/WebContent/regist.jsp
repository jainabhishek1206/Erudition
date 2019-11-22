<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<center><h1>Welcome to Registration page</h1></center>
<form action="Register" method="post">
Name:<br>              <input type="text" name="name"><font color="red">${namemessage}</font><br>
Username:<br>          <input type="text" name="username"><font color="red">${usernamemessage }</font><br>
password:<br>          <input type="password" name="password"><font color="red">${pass }</font><br>
Confirm Password:<br>  <input type="password" name="confirm"><font color="red">${pass }</font><br>
Age:   <br>            <input type="text" name="age"> <font color="red">${agemsg } 
${agemessage } </font><br>
DOB:<br>               <input type="date" max="2018-06-02" min="1899-12-31" name="dob"><br>
Address:<br>           <input type="text" name="address"><br>
<input type="submit" value="Register">
<font color="Red">


</font>
</form>


</body>
</html>