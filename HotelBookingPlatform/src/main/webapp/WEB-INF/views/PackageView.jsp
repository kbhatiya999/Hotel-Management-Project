<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList" import="com.survival.entities.Package"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ include file = "header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class="table table-bordered">
<tr>
<h3>Insert Package </h3>
<form:form action="./AddPackageResult" method="post">
		Package Id:<form:input type="number" path="pid" required="required"/>   
	    Name:<form:input type="text" path="pname" required="required"/>     
		Hotel Id:<form:input type="number" path="hid" required="required"/>      
		Price:<form:input type="number" path="price" required="required"/>          
		                        <br> 
		Description:<form:input type="text" path="description" required="required"/>
		Package Type:<form:input type="number" path="packagetype" required="required"/>    
    	 City:<form:input type="text" path="city" required="required"/>    
		 No. of Days:<form:input type="number" path="noofdays" required="required"/>
			                      <br>
		Room Type ID:<form:input type="number" path="rtypeid" required="required"/>
	    
<input type="submit" name= "operations" value="Submit">
	</form:form>
<tr>

<h3>Delete Package </h3>
<form:form action="./DeletePackageResult" method="post">
		Add  Package Id:<br><form:input type="number" path="pid" required="required"/><br>
<input type="submit" name= "operations" value="Submit">
	</form:form>

<h3>Search Package</h3>
<form:form action="./SearchPackageResult" method="post">
		Add  Package Id:<br><form:input type="number" path="pid" required="required"/><br>
<input type="submit" name= "operations" value="Submit">
	</form:form>





<h1>Package Records</h1>
<<table class="table table-bordered">>
<thead>
		<tr>
			<th>Package Id</th>
			<th>Name</th>
			<th>Hotel Id</th>
			<th>Price</th>
			<th>Description</th>
			<th>Type</th>
			<th>City</th>
			<th>No. of Days</th>
			<th>Room Type Id</th>
		</tr>
		</thead>
		<tbody>
		<%

		ResultSet rs = (ResultSet)request.getAttribute("msg");			
		ArrayList<Package> ls = new ArrayList<Package>(); 
		while (rs.next()) 
		{                      
			Package p=new Package();
			p.setPid(rs.getInt("pid"));
			p.setPname(rs.getString("pname"));
			p.setHid(rs.getInt("hid"));
			p.setPrice(rs.getInt("price"));
			p.setDescription(rs.getString("description"));
			p.setPackagetype(rs.getInt("packagetype"));
			p.setCity(rs.getString("city"));
			p.setNoofdays(rs.getInt("noofdays"));
			p.setRtypeid(rs.getInt("rtypeid"));

			ls.add(p);		
		}
		
		
		
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
		</tbody>
	</table>

</body>
</html>