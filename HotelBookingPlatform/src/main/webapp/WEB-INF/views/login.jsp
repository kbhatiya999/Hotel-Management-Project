<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
     <%@ include file = "header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style type="text/css">
.container{

      height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;

}

</style>
</head>
<body >
<<<<<<< HEAD
<div class="container container-table"  >
<div class="h-100  row align-items-center">
<div class="card">
<article class="card-body">
<a href="./registration" class="float-right btn btn-outline-primary">Sign up</a>
<h4 class="card-title mb-4 mt-1">Sign in</h4>
       <form:form action="./log">
    <div class="form-group">
       <label>Username</label>
        <form:input path="login_Id" required="reqiured" hint="Username" />
        
    </div> <!-- form-group// -->
    <div class="form-group">
       
       <label>Password</label>
        <form:password path="login_Password" required="required" hint="******" />
    </div> <!-- form-group// --> 
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Login  </button>
    </div> <!-- form-group// -->                                                           
=======

<div class="row">
	<center class="col-sm-4">
<div class="card">
<article class="card-body">

<h4 class="card-title mb-4 mt-1">Login</h4>
	 <form:form action="./log">
    <div class="form-group">
    	<label>User Name</label>
        <form:input path="login_Id" required="required "/>
    </div> <!-- form-group// -->
    <div class="form-group">
    	
    	<label>Password</label>
        <form:password path="login_Password" required="required" />
    </div> <!-- form-group// --> 
    <div class="form-group"> 
   
    </div> <!-- form-group// -->  
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Login  </button>
    </div> <!-- form-group// -->                                                           
</form:form>
</article>
</div> <!-- card.// -->

<form action="./registration">

<input type="submit"  class="float-right btn btn-outline-primary" value="Sign Up"> 
</tbody>
</table>
</form>
</center class="col-sm-4">
</div>


<%-- 

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
>>>>>>> branch 'iterationOne' of https://github.com/kbhatiya999/Hotel-Management-Project.git
</form:form>
<<<<<<< HEAD
</article>
</div> <!-- card.// -->
</div>
</div>
=======
<form action="./registration">
<h2>New User?</h2>

<input type="submit" value="Sign Up"> 
</tbody>
</table>
</form>
</div> --%>
>>>>>>> branch 'iterationOne' of https://github.com/kbhatiya999/Hotel-Management-Project.git
</body>
</html>

