<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter names</title>
</head>
<body>
<form method="post" action="Names">
<table>
	<tr>
		<td>First Name: </td>
		<td><input type="text" name="firstname"/></td>
	</tr>
	<tr>
		<td>Last Name: </td>
		<td><input type="text" name="lastname"/></td>
	</tr>
	<tr>
		<td>Add More?</td>
		<td><input type="radio" name="more" value="yes"/> Yes <input type="radio" name="more" value="no"/> No </td>
	</tr>
	<tr>
		<td><input type="submit" value="Names"/></td>
	</tr>
</table>
</form>

<c:if test="${param.show eq 'true'}"> 
	<c:forEach var="name" items="${names }">
		<tr><td>${name }</td></tr>
    </c:forEach>
</c:if>
</body>
</html>