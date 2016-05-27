<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://bootsnipp.com/dist/bootsnipp.min.css?ver=7d23ff901039aef6293954d33d23c066">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/ehealth.css">

<title>Registration</title>
<style>
    .error {
        color: red; font-weight: bold;
    }
</style>
</head>


<body>
    <!--
    you can substitue the span of reauth email for a input with the email and
    include the remember me checkbox
    -->
    <div class="container">
        <div class="card card-container" style="max-width:548px">
            <p id="profile-name" class="profile-name-card"></p>
            <form:form action="register" method="post" commandName="userForm" cssClass="form-signin">
            <form:errors path="erroralreadyExist" cssClass="error"/>
          <span id="reauth-email" class="reauth-email">Set your User Name & password</span>
          		<span id="age" class="reauth-email">User Name</span>
					<form:input path="username" cssClass="form-control" id="inputPassword"/>
					<form:errors path="username" cssClass="error"/>
				<span id="age" class="reauth-email">Password</span>	
					<td><form:password path="password" id="inputPassword" class="form-control"/></td>
					<form:errors path="password" cssClass="error"/>
				
				
					
				<span id="reauth-email" class="reauth-email">Tell us a bit about yourself</span>
				E-mail:
					<form:input path="email" id="inputEmail" class="form-control"/>
					<form:errors path="email" cssClass="error"/>
				
					Gender:
					<form:select path="gender" items="${genderList}" />
				
				<span id="age" class="reauth-email">Age</span>
				<div class="row">
                    <div class="col-xs-5">
					<form:input path="age" cssClass="reauth-email" />Years
					<form:errors path="age" cssClass="error"/>
					</div>
					</div>
				
					<span id="reauth-email" class="reauth-email">Height</span>
					<form:select path="heightft" items="${heightfeetList}" cssStyle="width:40%;display:inline;" id="feet"/>feet
					<form:select path="heightinch" items="${heightinchList}" cssStyle="width:40%;display:inline;" id="inch"/>inch
					 <span id="reauth-email" class="reauth-email">Weight</span>
					 <div class="row col-xs-5">
					<form:input path="weight" />
					<form:errors path="weight" cssClass="error"/>
					</div>
					
				<button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Register</button>
            </form:form>
                        <!-- /form -->
            Already have Account?<a href="/EAHealth/login" class="forgot-password">Login here.</a>
        </div>
        <!-- /card-container -->
    </div>
    <!-- /container -->

    <footer>
        <address>&copy; Copyright 2016 All Rights Reserved</address>
    </footer>

</body>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</html>