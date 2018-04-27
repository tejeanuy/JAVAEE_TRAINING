<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="bean.ClientBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<%-- 
same as <jsp:useBean></jsp:useBean>
<% ClientBean clientBean1 = new ClientBean();
   session.setAttribute("clientBean", clientBean1);
%> --%>
<jsp:useBean id="clientBean" scope="session" class="bean.ClientBean"></jsp:useBean>
<form action="LoginServlet" method="post">
<table>
	<tr>
		<td><label style="font-size: 20px; color: orange">User Name:</label></td>
		<td><input type="text" name="username"/></td>
	</tr>
	<tr>
		<td><label style="font-size: 20px; color: orange">Password:</label></td>
		<td><input type="password" name="password"/></td>
	</tr>
	<tr>
		<td rowspan="2"><input type="submit" value="Submit"/></td>
	</tr>
	<%  
	ClientBean cb = (ClientBean) session.getAttribute("clientBean");
	if (cb.getMessage() != null) { %>
	<tr>
		<td rowspan="2"><label style="color: red"><jsp:getProperty property="message" name="clientBean"/></label></td>
	</tr>
	<% } %>
</table>
</form>
<a href="register.jsp?user=New User">Click me!</a>
</body>
</html>