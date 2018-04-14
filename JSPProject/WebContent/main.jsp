<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
</head>
<body>
<%-- The request object is an implicit object which is an object of HttpServletRequest --%>
<h1>Calling context param in JSP <%= config.getServletContext().getInitParameter("greeting") %> </h1>
<h1>Welcome <%= request.getParameter("username") %>! </h1>
</body>
</html>