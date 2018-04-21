<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="WEB-INF/customtags.tld" prefix="mytag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Custom Tags Demo</title>
</head>
<body>
<mytag:greet/>
<mytag:formatter style="medium"/>
<mytag:block>This is a tag that displays a border. </mytag:block>
<mytag:caps>This is a tag with BodyTagSupport.</mytag:caps>
</body>
</html>