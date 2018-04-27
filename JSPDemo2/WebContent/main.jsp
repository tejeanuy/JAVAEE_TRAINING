<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
<style type="text/css">
	table, th, td {
    	border: 1px solid green;
	}
	table {
		border-collapse: collapse;
	}
</style>
</head>
<jsp:useBean id="clientBean" scope="session" class="bean.ClientBean"></jsp:useBean>
<body>

<h1>Welcome <jsp:getProperty property="username" name="clientBean"/>!!!</h1>
<h2>Here are your details: </h2>
<table>
	<tr>
		<td>Name:</td>
		<td ><jsp:getProperty property="name" name="clientBean"/></td>
	</tr>
	<tr>
		<td>Address:</td>
		<td><jsp:getProperty property="address" name="clientBean"/></td>
	</tr>
	<tr>
		<td>Nationality:</td>
		<td><jsp:getProperty property="nationality" name="clientBean"/></td>
	</tr>
	<tr>
		<td>Age:</td>
		<td><jsp:getProperty property="age" name="clientBean"/></td>
	</tr>
</table>
</body>
</html>