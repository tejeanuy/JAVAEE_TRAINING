<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
</head>
<body>
<h1>Customer Information</h1>
<form method="post" action="../CreateAccount">
	<table>
	<tr>
		<td>Customer ID: </td>
		<td><input type="text" name="id" readonly/></td>
	</tr>
	<tr>
		<td>First Name: </td>
		<td><input type="text" name="firstname"/></td>
	</tr>
	<tr>
		<td>Last Name: </td>
		<td><input type="text" name="lastname"/></td>
	</tr>
	<tr>
		<td>Email Address: </td>
		<td><input type="text" name="email"/></td>
	</tr>
	<tr>
		<td>Birthday: </td>
		<td><input type="text" name="birthday" value="MM/dd/yyyy"/></td>
	</tr>
	<tr>
		<td>Account Id: </td>
		<td><input type="text" name="accountid" readonly/></td>
	</tr>
	<tr>
		<td>Initial Balance: </td>
		<td><input type="text" name="balance"/></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Create New Account"/></td>
	</tr>
</table>
</form>
<% 
	String iscreated = request.getParameter("iscreated");
    String invalidbalance = request.getParameter("invalidbalance");
    String invalidbday = request.getParameter("invalidbday");
	if(iscreated != null && iscreated.equals("true")) {
%>
   <span style="color:green; font-size: medium;">Customer successfully created!</span>
<%	} else if (iscreated != null && iscreated.equals("false")){
%>
   <span style="color:red; font-size: medium;">Customer not created...</span>
<%	} else if (invalidbalance != null && invalidbalance.equals("true")){ 
%>
   <span style="color:red; font-size: medium;">The balance amount is less than 500.</span>
<%	} else if (invalidbday != null && invalidbday.equals("true")){ 
%>
   <span style="color:red; font-size: medium;">Birthday should be in the format MM/dd/yyyy.</span>
<%	}
%>
</body>
</html>