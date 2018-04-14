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
<form method="post" action="LoginValidator">
	<table>
	<tr>
		<td>Username: </td>
		<td><input type="text" name="username"/></td>
	</tr>
	<tr>
		<td>Password: </td>
		<td><input type="password" name="password"/></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="SUBMIT"/></td>
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
</body>
</html>