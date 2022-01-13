<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home Page</title>
</head>
<body>
	<h1>Welcome to User Portal</h1>
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
	
	<form action="Deposit.html" method="get">
		<input type="submit" value="Deposit">
	</form>
	<br>
	<form action="Withdraw.html" method="get">
		<input type="submit" value="Withdraw">
	</form>
	<br>
	<form action="TransferAmount.html" method="get">
		<input type="submit" value="Transfer Amount">
	</form>
	<br>
	<form action="Banking.html" method="get">
		<input type="submit" value="Show all transactions">
	</form>
	<br>
	<form action="index.html" method="get">
	<input type="submit" value="Logout">
	</form>
</body>
</html>