<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Login Page</h1>
<f:view>
<h:form>
	<table>
	<tr>
		<td>Customer ID: </td>
		<td><h:inputText value="#{customer.id }"/></td>
	</tr>
	<tr>
		<td>Account ID: </td>
		<td><h:inputText value="#{bankAccount.accountid}"/></td>
	</tr>
	<tr>
		<td><h:commandButton action="#{customer.validateLogin }" value="Login"/></td>
		<td><h:commandButton action="#{customer.goToCustomerList }" value="Go to Customer List"/></td>
		<td><input type="button" id="myButton" value="New Account"/></td>
	</tr>
</table>
<h:messages style="color:red" showDetail="true"></h:messages>
</h:form>
</f:view>
<script type="text/javascript">
    document.getElementById("myButton").onclick = function () {
        location.href = "http://localhost:8081/OnlineBanking/pages/MainPage.jsp";
    };
</script>
</body>
</html>