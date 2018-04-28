<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
</head>
<body>
<f:view>
<h1>Customer Information</h1>
<h:form>
	<table>
	<tr>
		<td>Customer ID: </td>
		<td><h:inputText value="#{customer.id }" readonly="true"/></td>
	</tr>
	<tr>
		<td>First Name: </td>
		<td><h:inputText id="firstname" value="#{customer.firstname }" required="true" requiredMessage="Please enter a firstname."/>
		<h:message for="firstname" style="color:red" />
		</td>
	</tr>
	<tr>
		<td>Last Name: </td>
		<td><h:inputText id="lastname" value="#{customer.lastname }" required="true" requiredMessage="Please enter a lastname."/>
		<h:message for="lastname" style="color:red" />
		</td>
	</tr>
	<tr>
		<td>Email Address: </td>
		<td><h:inputText id="email" value="#{customer.email }" required="true" requiredMessage="Please enter an email address.."/>
		<h:message for="email" style="color:red" />
		</td>
	</tr>
	<tr>
		<td>Birthday: </td>
		<td><h:inputText id="birthday" value="#{customer.birthday }" required="true" requiredMessage="Please enter a birthday."/>
		<h:message for="birthday" style="color:red" />
		</td>
	</tr>
	<tr>
		<td>Account Id: </td>
		<td><h:inputText value="#{bankAccount.accountid }" readonly="true"/></td>
	</tr>
	<tr>
		<td>Initial Balance: </td>
		<td><h:inputText id="balance" value="#{bankAccount.accountbalance }" required="true" requiredMessage="Please enter the initial amount.">
				<f:validator validatorId="balanceValidator"/>
			</h:inputText>
		<h:message for="balance" style="color:red" showSummary="true" showDetail="true"/>
		</td>
	</tr>
	<tr>
		<td colspan="2"><h:commandButton action="#{customer.createCustomer }" value="Create New Account"/></td>
	</tr>
</table>
</h:form>
</f:view>
<c:choose>
	<c:when test="${customer.created == true }">
		<span style="color:green; font-size: medium">Customer successfully created!</span> 
	</c:when>
	<c:when test="${customer.created == false }">
		<span style="color:red; font-size: medium">Customer creation failed...</span> 
	</c:when>
</c:choose>
</body>
</html>







