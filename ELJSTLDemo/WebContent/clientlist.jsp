<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="beans.Client"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client List</title>
</head>
<body>
<%
    String[] favoriteFood = {"ice cream", "cake", "barbecue"};
    request.setAttribute("foodlist", favoriteFood);
   	Integer[] numlist = {10,5,20};
   	session.setAttribute("numlist", numlist);
   	String[] movieList = {"Jurassic Park","Lord of the Rings", "Star Wars"};
   	request.setAttribute("movieList", movieList);
   	
   	String userLevel = "Admin";
   	session.setAttribute("userLevel", userLevel);

%>
<%-- <%
	Client c = new Client();
	c.setName("Ken");
	c.setAddress("Japan");
	session.setAttribute("client", c);
%> --%>
<jsp:useBean id="client" scope="session" class="beans.Client"></jsp:useBean>
<jsp:setProperty property="name" name="client" value="Ken"/>
<jsp:setProperty property="address" name="client" value="Japan"/>

<h2>Client name: ${client.name }</h2>
<h2>Client address: ${client.address }</h2>
<h2>My Favorite food is ${requestScope.foodlist["1"]}</h2>
<h2>Is ${numlist[1] } greater than 20? ${numlist[1] gt 20 }</h2>
<table>
<jstl:forEach var="movie" items="${movieList }">
	<tr><td>${movie }</td></tr>
</jstl:forEach>

<jstl:if test="${5 > 2 }"> 
	<span>5 is greater than 2</span> <br>
</jstl:if>

<jstl:set var="userLevel" scope="session" value="member"> </jstl:set>

<jstl:out value="${userLevel }"></jstl:out>

</table>
</body>
</html>