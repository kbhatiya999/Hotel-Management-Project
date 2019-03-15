<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Hotel Details</title>
</head>
<body>
<h1>Add Hotel Details</h1>
<form:form action="./AddHotelResult" method="post">
		Add Hotel Id:<br><form:input path="hotelID"/><br>
		Add Hotel Name:<br><form:input path="hotelName"/><br>
		Add Total Rooms:<br><form:input path="numOfRoomsInHotel"/><br>
		Add Discount:<br><form:input path="hotelDiscount"/><br>
		Add City:<br><form:input path="hotelCity"/><br>
		Add Address:<br><form:input path="hotelAddress"/><br>
		Add Hotel Rating:<br><form:input path="hotelRating"/><br>
		Add Hotel No of Ratings:<br><form:input path="noOfFeedback"/><br>
		
<input type="submit" name= "operations" value="Submit">
	</form:form>
</body>
</html>