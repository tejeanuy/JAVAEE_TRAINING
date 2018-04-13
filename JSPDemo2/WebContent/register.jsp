<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="bean.ClientBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<jsp:useBean id="clientBean" scope="session" class="bean.ClientBean">
</jsp:useBean>
<jsp:setProperty property="username" name="clientBean" param="user"/>
<body>
<jsp:include page="login.jsp"/>
	<h3>Welcome <jsp:getProperty property="username" name="clientBean"/>.
	Please fill out the form below.</h3>
	<br/>
	<form>
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address"/></td>
			</tr>
			<tr>
				<td>Nationality:</td>
				<td><input type="text" name="nationality"/></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input type="text" name="age"/></td>
			</tr>
			<tr>
				<td>User Name:</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"/></td>
			</tr>
		</table>
	</form>
</body>
</html>