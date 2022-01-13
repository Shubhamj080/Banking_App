<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "Pojo.Banking" %>
	<%@ page import= "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Transactions</title>
</head>
<body>
<h1 align="center">All Transactions</h1>

	<table align="center" border="1px">
		<tr>
			<th>Transaction Id</th>
			<th>Account Number</th>
			<th>Date of Tran</th>
			<th>Amount</th>
		</tr>
		<%
List<Banking> list = (List<Banking>) request.getAttribute("Arraylist");
for (Banking s : list) {
%>
		<tr>
			<td><%=s.getTrnnum() %></td>
			<td><%=s.getAccnum()%></td>
			<td><%=s.getDot()%></td>
			<td><%=s.getAmount()%></td>
		</tr>
		<%
}

%>
	</table>
	<br>
	<form align="center" action="UserHome.jsp" method="get">
	<input type="submit" value="Home">
	</form>
</body>
</html>