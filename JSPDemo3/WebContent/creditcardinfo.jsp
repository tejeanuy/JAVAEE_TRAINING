<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.HashMap, bean.ClientBean, bean.CreditCardInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Credit Card Info</title>
</head>
<body>
<jsp:useBean id="clientBean" class="bean.ClientBean" scope="session"></jsp:useBean>
<form action="CreditCardServlet" method="post">
<table>
	<tr>
		<td><label style="font-size: 20px; color: orange">Credit Card Number:</label></td>
		<td><input type="text" name="ccn"/></td>
	</tr>
	<tr>
		<td><label style="font-size: 20px; color: orange">Expiry Date:</label></td>
		<td><input type="text" name="expiry"/></td>
	</tr>
	<tr>
		<td rowspan="2"><input type="submit" value="Submit"/></td>
	</tr>
</table>
</form>
<%
	ClientBean cb = (ClientBean) session.getAttribute("clientBean");
	CreditCardInfo cci = cb.getCcinfo();
	
	HashMap<String, String> hm = new HashMap<String,String>();
	hm.put("Tejean", "Student");
	hm.put("Greg", "Pupil");
	session.setAttribute("hashmap", hm);
	
	String[] array = {"John", "Michael"};
	session.setAttribute("myarray",array);
%>
Values of HashMap:<br>
${hashmap.Tejean } <br> 
${hashmap.Greg } <br>
Values of Array:<br>
${hashmap["Tejean"]} <br> 
${myarray["1"]} <br>
${clientBean["ccinfo"]["cardno"]} <br>
Credit Card No.: <%=cci.getCardno() %><br>
Expiry Date: <%=cci.getExpirydate() %><br>
Credit Card No.: ${clientBean.ccinfo.cardno } <br>
Expiry Date: ${clientBean.ccinfo.expirydate } <br>
${initParam.contextparam}
</body>
</html>