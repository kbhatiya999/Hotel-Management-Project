<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList" import="com.survival.entities.Hotel"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Hotels</title>
</head>
<body>
<table>
<tr>
<h3>Insert Hotel Record</h3>
<form:form action="./AddHotelResult" method="post">
<td>
		Hotel Id:<form:input path="hid"/>
		</td>		<td>
		Hotel Name:<form:input path="hname"/>
		</td><td>
		Total Rooms:<form:input path="totalrooms"/>
		</td>
		
		<td>
		Discount:<form:input path="discount"/>
		</td></tr><tr>
		<td>
		City:<form:input path="city"/>
		</td><td>
		Address:<form:input path="address"/>
		</td>
		

<td>
		Hotel Rating:<form:input path="hotelrating"/>
		</td><td>
		Hotel No of Ratings:<form:input path="nooffeedback" />
		</td>
		</tr>

<tr>
<input type="submit" name= "operations" value="Submit">
	</form:form>
</table>
<table>
<tr>
<h3>Delete Hotel Record</h3>
<form:form action="./DeleteHotelResult" method="post">
		Input  Hotel Id:<br><form:input path="hid"/><br>
<input type="submit" name= "operations" value="Submit">
	</form:form>
	</table>
</tr>
<table>
<tr>
<h3>Search Hotel Record</h3>
<form:form action="./SearchHotelResult" method="post">
		Input  Hotel Id:<br><form:input path="hid"/><br>
<input type="submit" name= "operations" value="Submit">
	</form:form>
</tr>
</table>
<table> 
<tr>
<h3>Add rooms</h3>

<form action="./ViewRoom" method="post">
<input type="submit" name= "operations" value="Submit">
	</form>
	</tr>
	</table>


<h1>Hotel Records</h1>
<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Address</th>
			<th>City</th>
			<th>No. of rooms</th>
			<th>Discount</th>
			<th>Rating</th>
			<th>No. of feedback</th>
		</tr>
		<%

		ResultSet rs = (ResultSet)request.getAttribute("msg");			
		ArrayList<Hotel> ls = new ArrayList<Hotel>(); 
		while (rs.next()) 
		{                      
			Hotel h=new Hotel();
			h.setHid(rs.getInt("hid"));
			h.setHname(rs.getString("hname"));
			h.setAddress(rs.getString("address"));
			h.setCity(rs.getString("city"));
			h.setTotalrooms(rs.getInt("totalrooms"));
			h.setDiscount(rs.getInt("discount"));
			h.setHotelrating(rs.getDouble("hotelrating"));
			h.setNooffeedback(rs.getInt("nooffeedback"));
			ls.add(h);		
		}
		
		
		
		for(Hotel element:ls){
			out.print("<tr>");
			out.println("<td>" + element.getHid() + "</td>");
			out.println("<td>" +element.getHname() + "</td>");
			out.println("<td>" +element.getAddress() + "</td>");
			out.println("<td>" +element.getCity() + "</td>");
			out.println("<td>" +element.getTotalrooms() + "</td>");
			out.println("<td>" +element.getDiscount() + "</td>");
			out.println("<td>" +element.getHotelrating() + "</td>");
			out.println("<td>" +element.getNooffeedback() + "</td>");
			out.print("</tr>");
		}
		%>
	</table>
	
	
</body>
</html>