<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Login Page</h1>
<form method="post" action="Login">
	<table>
	<tr>
		<td>Customer ID: </td>
		<td><input type="text" name="customerid"/></td>
	</tr>
	<tr>
		<td>Account ID: </td>
		<td><input type="text" name="accountid"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="Login"/></td>
		<td><input type="button" id="myButton" value="New Account"/></td>
	</tr>
</table>
<% 
	String isvalid = request.getParameter("isvalid");
	if(isvalid != null && isvalid.equals("false")) {
%>
   <span style="color:red; font-size: medium;">Invalid username or password.</span>
<%	}
%>
</form>
<script type="text/javascript">
    document.getElementById("myButton").onclick = function () {
        location.href = "http://localhost:8081/OnlineBanking/pages/MainPage.jsp";
    };
</script>
</body>
</html>