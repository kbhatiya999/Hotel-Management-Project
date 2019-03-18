<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Form</title>
</head>
<body>
<h1>User Registration Form</h1>
<form:form action="./userRegistration" >
			<table style="with: 50%">
				<tr>
					<td>Name: </td>
					<td><form:input maxlength="50" path="user_Name" required="required" /></td>
				</tr>
				<tr>
					<td>Email: </td>
					<td><form:input maxlength="35" path="email_Id" required="required" /></td>
				</tr>
				<tr>
					<td>Phone Number: </td>
					<td><form:input maxlength="10" path="phone_Number" required="required" /></td>
				</tr>
					<tr>
					<td>Address: </td>
					<td><form:input maxlength="100" path="user_Address" required="required" /></td>
				</tr>
				<tr>
					<td>Role: </td>
					<td><form:input maxlength="3" path="login_Role" required="required" /></td>
				</tr>
				<tr>
					<td>UserName: </td>
					<td><form:input maxlength="20" path="login_Id" required="required" /></td>
				</tr>
					<tr>
					<td>Password: </td>
					<td><form:password maxlength="16" path="login_Password" required="required" /></td>
				</tr></table>
			<input type="submit" value="Submit" /></form:form>
</body>
</html>