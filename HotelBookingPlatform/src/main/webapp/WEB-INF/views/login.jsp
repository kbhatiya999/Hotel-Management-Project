<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
     <%@ include file = "header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body >
<div class="container">
<form:form action="./log">
<table class="table table-bordered">
<tbody>
<tr>
<td>UserName:</td> 
<td><form:input path="login_Id" required="required "/></td>
</tr><tr>
<td> Password:</td>
<td><form:password path="login_Password" required="required" /></td>
</tr>
<tr>
<td><input type="submit" value="login"></td><td></td> 
</tr><tr>
</form:form>
<form action="./registration">
<h2>New User?</h2>

<input type="submit" value="Sign Up"> 
</tbody>
</table>
</form>
</div>
</body>
</html>