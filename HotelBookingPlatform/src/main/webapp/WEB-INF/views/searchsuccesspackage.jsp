

<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList" import="com.survival.entities.Package"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

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

		Package p1=(Package)request.getAttribute("msg");		
		ArrayList<Package> ls = new ArrayList<Package>(); 
		ls.add(p1);
		
		
		

		
		
		for(Package element:ls){
			out.print("<tr>");
			out.println("<td>" + element.getPid() + "</td>");
			out.println("<td>" +element.getPname() + "</td>");
			out.println("<td>" +element.getHid() + "</td>");
			out.println("<td>" +element.getPrice() + "</td>");
			out.println("<td>" +element.getDescription() + "</td>");
			out.println("<td>" +element.getPackagetype() + "</td>");
			out.println("<td>" +element.getCity() + "</td>");
			out.println("<td>" +element.getNoofdays() + "</td>");
			out.println("<td>" +element.getRtypeid() + "</td>");
			out.print("</tr>");
		}
		
		
		%>
		
	
		
		
		
		
	</table>
<h3>Update Package Details</h3>
<form:form action="./UpdatePackageResult" method="post">
		Package Id:<form:input path="pid"/>    Name:<form:input path="pname"/>               Hotel Id:<form:input path="hid"/>              Price:<form:input path="price"/>               <br> 
		Description:<form:input path="description"/>	Package Type:<form:input path="packagetype"/>               City:<form:input path="city"/>               No. of Days:<form:input path="noofdays"/><br>
		Room Type ID:<form:input path="rtypeid"/>
	    
<input type="submit" name= "operations" value="Submit">
	</form:form>

</body>
</html>