<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<% application.setAttribute("context", "WebShoppe Online Store"); %>
	<h1><%= application.getAttribute("context") %></h1>
	<form action="LoginServlet" method="post">
		<input type="text" name="username" /><br/>
		<input type="password" name="password"/><br/>
		<input type="text" name="newcontext"/><br/>
		<input type="submit" value="SUBMIT"/>
	</form>
	<br/>
	<%
		String error = (String) session.getAttribute("error");
		if(error != null) {
	%>
	<span style="color: red"><%= error %></span>
	<% 
		session.removeAttribute("error");
	} %>
	<br/>
	<a href="register.jsp?user=New Client">Click to register!</a>
</body>
</html>