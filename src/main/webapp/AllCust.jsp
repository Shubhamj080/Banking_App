<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import= "Pojo.Customer" %>
	<%@ page import= "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Customer JSP</title>
</head>
<body>
	<h1 align="center">All Customers</h1>

	<table align="center" border="1px">
		<tr>
			<th>Customer Id</th>
			<th>Name</th>
			<th>Email Id</th>
			<th>Mobile number</th>
		</tr>
		<%
List<Customer> list = (List<Customer>) request.getAttribute("Arraylist");
for (Customer s : list) {
%>
		<tr>
			<td><%=s.getCust_id()%></td>
			<td><%=s.getCname()%></td>
			<td><%=s.getMail_id()%></td>
			<td><%=s.getMob()%></td>
		</tr>
		<%
}

%>
	</table>
	<br>
	<form align="center" action="AdminHome.jsp" method="get">
	<input type="submit" value="Home">
	</form>
</body>
</html>