<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1> Edit Information related to  ${username1 }
 </h1>
 
 
<form action="EditInformation" method="post">
<%HttpSession session1=request.getSession();
String username=(String)session1.getAttribute("username");
String name=(String)session1.getAttribute("name");
String age=(String)session1.getAttribute("age");
String dob=(String)session1.getAttribute("dob");
String address=(String)session1.getAttribute("address");
String password=(String)session1.getAttribute("password");
%>

<h2>Name:<br> <input type="text" name="name" value="${name }" ><font color="red" size="2">${namemessage}</font><br>
Username:<br> <input type="text" name="username" value="${username }"><font color="red" size="2"></font><br>
password:<br> <input type="password" name="password" value="${password}"><font color="red" size="2">${pass}</font><br>
confirm password:<br> <input type="password" name="confirm" value="${password }"><font color="red" size="2">${pass}</font><br>
DOB:<br> <input type="date" max="2018-05-31" min="1900-01-01" name="dob" value="${dob}"> <br>
Age:<br> <input type="tex" name="age" value="${age }"><font color="red" size="2"> ${agemsg } 
${agemessage }</font><br>
Address:<br><input type="text" name="address" value="${address }"> </h2>
<input type = "submit" value = "Update" />
<font color="red">
<h1> 
</font> </h1>
</form><form action="info.jsp">
<input type="submit" value="Back to Homepage">
</form>
<br><font color="red">${sucess}</font><br>
</body>
</html>