<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="servlets.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Customer Details</title>
</head>
<body>
<%! Customer customerObj = null; %>
<% customerObj = (Customer) session.getAttribute("customer"); 
   customerObj.setUsername(request.getParameter("username"));
%>
<h1>Customer Details: </h1> 

<table>
	<tr>
		<td>Username: </td>
		<td><%= customerObj.getUsername() %></td>
	</tr>
	<tr>
		<td>Customer Name: </td>
		<td><%= customerObj.getName() %></td>
	</tr>
	<tr>
		<td>Customer Address: </td>
		<td><%= customerObj.getAddress() %></td>
	</tr>
</table>

<jsp:useBean id="customer" class="servlets.Customer" scope="session"></jsp:useBean>
<jsp:setProperty name="customer" property="address" value="Philippines"></jsp:setProperty>
<jsp:setProperty name="customer" property="username" param="username"></jsp:setProperty>
<table>
	<tr>
		<td>Username: </td>
		<td><jsp:getProperty name="customer" property="username"></jsp:getProperty></td>
	</tr>
	<tr>
		<td>Customer Name: </td>
		<td><jsp:getProperty name="customer" property="name"></jsp:getProperty></td>
	</tr>
	<tr>
		<td>Customer Address: </td>
		<td><jsp:getProperty name="customer" property="address"></jsp:getProperty></td>
	</tr>
</table>
<jsp:include page="include.jsp">
	<jsp:param name="phonenum" value="1234567"></jsp:param>
</jsp:include>
</body>
</html>









