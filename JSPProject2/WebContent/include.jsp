<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Included JSP</title>
</head>
<body>
<h1>Phone Number: <%= request.getParameter("phonenum") %></h1>
<h1>Phone Number: ${param.phonenum} </h1> 
</body>
</html>