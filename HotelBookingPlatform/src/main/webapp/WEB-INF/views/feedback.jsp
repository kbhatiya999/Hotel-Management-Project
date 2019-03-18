<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="./cal1">
Enter Rating (1-5) : <input type="text" name="tb1"><br><br>
Enter Feedback : <textarea name="tb2" rows = "10" cols= "50"></textarea>

<input type="submit" value="feedbackbutton">
<% request.setAttribute("hid", request.getAttribute("hid")); %>

</form:form>
</body>
</html>