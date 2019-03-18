<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body >
<form:form action="./log">
UserName: <br> 
<form:input path="login_Id" required="required "/> <br>
Password: <br>
<form:password path="login_Password" required="required" /> <br><br>
<input type="submit" value="login"><br></br> 

</form:form>
<form action="">
<h2>New User?</h2>
<input type="submit" value="Sign Up"> 


</form>
</body>
</html>