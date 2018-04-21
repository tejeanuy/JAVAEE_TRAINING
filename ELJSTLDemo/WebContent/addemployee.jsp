<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="beans.Employee"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
<jsp:useBean id="employee" scope="session" class="beans.Employee">
</jsp:useBean>
<jsp:setProperty name="employee" property="name" param="name"/>
<jsp:setProperty name="employee" property="email" param="email"/>
<jsp:setProperty name="employee" property="number" param="number"/>

<form method="post" action="addemployee.jsp?show=true">
	<input type="submit" value="Show Employee"/>
</form>
<c:if test="${param.show eq 'true' }"> 
	<jsp:getProperty name="employee" property="name"/> <br>
	<jsp:getProperty name="employee" property="email"/> <br>
	<jsp:getProperty name="employee" property="number"/> <br>
</c:if>
</body>
</html>