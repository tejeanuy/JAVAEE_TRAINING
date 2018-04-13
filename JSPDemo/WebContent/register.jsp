<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<h1><%= application.getAttribute("context") %></h1>
	<h3>Welcome <%= request.getParameter("user") %>.
	Please fill out the form below.</h3>
	<br/>
	<form>
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="fname"/></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lname"/></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address"/></td>
			</tr>
			<tr>
				<td>User Name:</td>
				<td><input type="text" name="uname"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="pass"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"/></td>
			</tr>
		</table>
	</form>
</body>
</html>