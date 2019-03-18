<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="com.survival.entities.TrendingMain" import="java.util.ArrayList" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table style="width: 100%">
		<tr>
			<th>HotelName</th>
			<th>Rating</th>
			<th>Address</th>
			<th>Discount</th>
			<th>RoomType</th>
			<th>Price</th>
			<th>Location</th>
		</tr>		
		<%
			ArrayList<TrendingMain> list = (ArrayList) request.getAttribute("trending");
			for (TrendingMain element : list) {
		%>
		<tr>
			<td>
				<%
					out.println(element.getHotelName());
				%>
			</td>
			<td>
				<%
					out.println(element.getRating());
				%>
			</td>
			<td>
				<%
					out.println(element.getAddress());
				%>
			</td>
			<td>
				<%
					out.println(element.getDiscount());
				%>
			</td>
			<td>
				<%
					out.println(element.getRoom_type());
				%>
			</td>
			<td>
				<%
					out.println(element.getPrice());
				%>
			</td>
			<td>
				<%
					out.println(element.getLocation());
				%>
			</td>
			
			
		</tr>
		

		<%
			}
		%>
	</table>
<br> <br>	
<form:form action="./searchresult">
<!-- Enter City : <form:input type="text" path="city" /><br><br> -->
Enter the city:<form:select path="city">
<form:option value="Jaipur">Jaipur</form:option>
<form:option value="Delhi">Delhi</form:option>
<form:option value="Mumbai">Mumbai</form:option>
</form:select><br><br>

Enter MinPrice: <form:select path="minPrice">
<form:option value="1000">1000</form:option>
<form:option value="2000">2000</form:option>
<form:option value="6000">6000</form:option>
</form:select><br><br> <!--<form:input type="text" path="minPrice"/><br><br>-->

Enter MaxPrice:   <form:select path="maxPrice">
<form:option value="10000">10000</form:option>
<form:option value="15000">15000</form:option>
<form:option value="20000">20000</form:option>
</form:select><br><br>
<input type="submit" value="search">
</form:form>

</body>
</html>












