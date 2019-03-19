<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<h1> Welcome,To Apna Hotel </h1>
<table>
<tr>
<th><form action="./searchinput"><input type="submit" value="Search        "></form></th>
<th><a href="./activeBookings?uid=${userid }"><input type="submit" value="My Active Bookings  "></a></th>
<th><a href="./inactiveBookings?uid=${userid }"><input type="submit" value="My Previous Bookings"></a></th>
</tr>
</table>
<a href="./ContactUs">Contact Us</a>
</body>
</html>