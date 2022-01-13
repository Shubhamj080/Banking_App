<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home Page</title>
</head>
<body>
	<h1>Welcome to Admin Portal</h1>
	<%
	String a = session.getAttribute("User_name").toString();
	if(a == null){
		out.print("Invalid Credentials");
	}
	else{
		out.print("Hello "+a+"!");
	}
	%>
	<br><br>
	
	<form action="Register.html" method="get">
		<input type="submit" value="Open Account">
	</form>
	<br>
	<form action="ExistingUser.html" method="get">
		<input type="submit" value="New Account Open for Existing User">
	</form>
	<br>
	<form action="CloseAcc.html" method="get">
		<input type="submit" value="Close Account">
	</form>
	<br>
	<form action="AllCustomer" method="get">
		<input type="submit" value="Show All Customer">
	</form>
	<br>
	<form action="index.html" method="get">
	<input type="submit" value="Logout">
	</form>
</body>
</html>