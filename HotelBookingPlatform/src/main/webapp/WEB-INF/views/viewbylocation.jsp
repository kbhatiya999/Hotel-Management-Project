<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.survival.entities.SearchResultMain" import="java.util.ArrayList" isELIgnored="false"%>
    <%@ include file = "header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" >
<title>View by Location</title>
</head>
<body>
<table style="width: 100%" class="table table-bordered">
		<tr>
			<th>HotelName</th>
			<th>Rating</th>
			<th>Address</th>
			<th>Discount</th>
			<th>RoomType</th>
			<th>Price</th>
		</tr>		
		<%
			ArrayList<SearchResultMain> list = (ArrayList) request.getAttribute("resultSetLocation");
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
<div class="container">
<h3>Filter categories:-
</h3>
</div>	
<table style="width: 100%" class="table table-bordered">	
<tr>
<th><a href="./filterpricelowhigh">FilterByPrice(Low to High)</a></th>
<th><a href="./filterpricehighlow">FilterByPrice(High to Low)</a></th>
<th><form action="./filterbyrating">
Enter Minimum rating : <input type="text" name="filter" >
<input type="submit" value="Filter">
</form></th>
</tr>
</table>
<div class="container">
<h3>Sort Categories:-
</h3>
</div>
<table style="width: 100%" class="table table-bordered">
<tr>	
<th><a href="./sorthotellowhigh">SortByhotelname(Low to High)</a></th>
<th><a href="./sorthotelhighlow">SortByhotelname(High to Low)</a></th>
<th><a href="./sortpricelowhigh">SortByPrice(Low to High)</a></th>
<th><form action="./filterbyrating">
Enter Minimum rating : <input type="text" name="filter" >
<input type="submit" value="Filter">
</form></th>
</tr>
<tr>
<th><a href="./sortpricehighlow">SortByPrice(High to Low)</a></th>
<th><a href="./sortbydiscount">SortByDiscount</a><br></th>
<th><a href="./sortbyrating">SortByRating</a></th>
</tr>
</table>
<div class="container">
<table style="width: 100%" class="table table-bordered">
<tr>
<th><a href="./viewallpackages">View Holiday Packages For This City</a></th>
<th>
<form action="./viewhotelpackage"><br>
<input type="submit" value="Search Hotel Packages">
</form></th>
</tr>
</table>
<form action="./booking">
Enter Hotel Name to Book : <input type="text" name="hotelbook" ><br>
<input type="submit" value="Book!">
</form>
</div>
</body>
</html>
