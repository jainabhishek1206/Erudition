<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Information About User</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}
</style>


</head>
<body>

<center><h1>Welcome</h1></center>
<br>
<h2> Here is the complete information about you</h2>
<%-- 
<font size="3"> Name:        ${name}  </font> <br>   
<font size="3"> UserName:    ${username } </font><br>
<font size="3"> DOB:         ${dob }</font>  <br>
<font size="3">Address:      ${address } </font><br> --%>


<table style="width:100%">
 
  <tr>
    <th>Parameter</th>
    <th>value</th>
  </tr>
  <tr>
    <td>ID</td>
    <td>${id}</td>
  </tr>
  <tr>
    <td>Name</td>
    <td>${name}</td>
  </tr>
  <tr>
    <td>UserName</td>
    <td>${username }</td>
  </tr>
  <tr>
    <td>DOB</td>
    <td>${dob }</td>
  </tr>
  <tr>
    <td>Age</td>
    <td>${age}</td>
  </tr>
  <tr>
    <td>Address</td>
    <td>${address }</td>
  </tr>
</table>




<form action="Update.jsp" method="get">
<input type="hidden"  name="username1" value= "${username }">
<br><br>
<input type="submit" value="Edit Information">
</form>
</body>
</html>



<%-- //<a href="EditInformation? username= ${username }" method="post"> Edit Information </a> --%>
<%-- <c:param name = "username1" value = "${username }"/> --%>
<%-- <jsp:forward page="Update.jsp">
	<jsp:param name="username1" value="${username }"/> --%>