<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="from" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<from:form action="./updateName">
Enter Name : <input type="text" name="name">
Enter Phone     : <input type="text" name="phone">
Enter New Name     : <input type="text" name="newName">
<br>
<input type="submit" value="Update" name="">
</from:form>
</body>
</html>