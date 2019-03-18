<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Enter Valid Entry</h3>
<table>
<tr>
<h3>Insert Hotel Record</h3>
<form:form action="./AddHotelResult" method="post">
<td>
		Hotel Id:<form:input type="number" min="0" max="1000000000"  path="hid" required="required" />
		</td>		<td>
		Hotel Name:<form:input type="text" maxlength="40" path="hname" required="required"/>
		</td><td>
		Total Rooms:<form:input type="number" min="0" max="99999" path="totalrooms" required="required"/>
		</td>
		
		<td>
		Discount:<form:input type="number" min="0" max="100" path="discount" required="required"/>
		</td></tr><tr>
		<td>
		City:<form:input type="text" maxlength="30" path="city" required="required"/>
		</td><td>
		Address:<form:input type="text" maxlength="100" path="address" required="required"/>
		</td>
		

<td>
		Hotel Rating:<form:input type="number" min="0" max="10" path="hotelrating" required="required"/>
		</td><td>
		Hotel No of Ratings:<form:input  type="number" min="0" max="10000" path="nooffeedback" required="required" />
		</td>
		</tr>
<input type="submit" name= "operations" value="Submit">
<tr>

	</form:form>
</table>
<table>
<tr>
<h3>Delete Hotel Record</h3>
<form:form action="./DeleteHotelResult" method="post">
		Input  Hotel Id:<br><form:input  type="number" min="0" max="1000000" path="hid" required="required"/><br>
<input type="submit" name= "operations" value="Submit">
	</form:form>
	</table>
</tr>
<table>
<tr>
<h3>Search Hotel Record</h3>
<form:form action="./SearchHotelResult" method="post">
		Input  Hotel Id:<br><form:input  type="number" min="0" max="1000000" path="hid" required="required"/><br>
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