<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.survival.entities.SearchResultMain" import="java.util.ArrayList" isELIgnored="false"%>
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
		</tr>		
		<%
			ArrayList<SearchResultMain> list = (ArrayList) request.getAttribute("resultSetFilter");
			for (SearchResultMain element : list) {
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
			
			
		</tr>
		

		<%
			}
		%>
	</table>
	<br><br>
<form action="./booking">
Enter Hotel Name to Book : <input type="text" name="hotelbook" >
<input type="submit" value="Book!">
</form>
</body>
</html>