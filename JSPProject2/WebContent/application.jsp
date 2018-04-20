<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application Form</title>
</head>
<body>
<form method="post" action="RegisterServlet">
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
		<td>Name: </td>
		<td><input type="text" name="name"/></td>
	</tr>
	<tr>
		<td>Address: </td>
		<td><input type="text" name="address"/></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="REGISTER"/></td>
	</tr>
</table>
</form>
</body>
</html>