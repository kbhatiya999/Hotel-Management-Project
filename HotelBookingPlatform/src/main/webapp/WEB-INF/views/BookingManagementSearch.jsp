<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="from" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer's Booking Search</title>
</head>
<body>
<from:form action="./search">
Enter Name     : <from:input path="userFullName"/><br></br>
Enter Phone No : <from:input path="userPhoneNumber"/><br></br>
<input type="submit" value="Login">
</from:form>
</body>
</html>