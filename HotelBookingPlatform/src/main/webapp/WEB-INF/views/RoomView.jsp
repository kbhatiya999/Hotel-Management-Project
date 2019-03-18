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
		Add Hotel ID:<form:input path="hid"/><br>
    <input type="submit" name= "operations" value="Submit">
</form:form>

<h2>Delete Room</h2>
<form:form action="./DeleteRoomResult" method="post">
		Input Room Type Id:<br><form:input path="rtypeid"/><br>
<input type="submit" name= "operations" value="Submit">
</form:form>

<h2>Modify Room</h2>
<form:form action="./ModifyRoomResult" method="post">
		Input Room Type Id:<br><form:input path="rtypeid"/><br>
<input type="submit" name= "operations" value="Submit">
	</form:form>

<h2>Current Rooms</h2>

<table>
		<tr>
			<th>RTypeID</th>
			<th>Type</th>
			<th>TotalNumRooms</th>
			<th>Price</th>
			<th>HotelID</th>
		</tr>
		<%

		ResultSet rs = (ResultSet)request.getAttribute("msg");			
		ArrayList<Roomtype> ls = new ArrayList<Roomtype>(); 
		while (rs.next()) 
		{                      
			Roomtype r =new Roomtype();
			r.setRtypeid(rs.getInt("rtypeid"));
			r.setType(rs.getString("type"));
			r.setTotalnoofrooms(rs.getInt("totalnoofrooms"));
			r.setPrice(rs.getInt("price"));
			r.setHid(rs.getInt("hid"));
			ls.add(r);		
		}
		
		
		
		for(Roomtype element:ls){
			out.print("<tr>");
			out.println("<td>" + element.getRtypeid() + "</td>");
			out.println("<td>" + element.getType() + "</td>");
			out.println("<td>" + element.getTotalnoofrooms() + "</td>");
			out.println("<td>" + element.getPrice() + "</td>");
			out.println("<td>" + element.getHid() + "</td>");
			out.print("</tr>");
		}
		%>
	</table>
	

</body>
</html>