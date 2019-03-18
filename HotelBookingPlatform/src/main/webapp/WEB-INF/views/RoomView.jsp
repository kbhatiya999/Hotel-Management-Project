<%@page import="com.survival.entities.Roomtype"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Rooms</title>
</head>
<body>

<h2>Add Room</h2>
<form:form action="./AddRoomResult" method="post">
		Add Room Type ID:<form:input path="rtypeid"/>
		Add Room Type:<form:input path="type"/><br>
		Add Total Number of Rooms:<form:input path="totalnoofrooms"/>
		Add Room Price:<form:input path="price"/>
		Hotel ID:<% out.println(request.getAttribute("hid")); %><br>
    <input type="submit" name= "operations" value="Submit">
</form:form>
</body>
</html>