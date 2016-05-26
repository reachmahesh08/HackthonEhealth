<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  


<!DOCTYPE html>
<html>

<head >
    <meta charset="UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://bootsnipp.com/dist/bootsnipp.min.css?ver=7d23ff901039aef6293954d33d23c066">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/ehealth.css">
    <title>User Login</title>
<style>
	
    .error {
        color: red; font-weight: bold;
    }
</style>
    
    <script type="text/javascript">
function submitform(obj,path){
	var id;
	var formObject=document.getElementById("loginPage");
	var targetUrl=path+"/EAHealth/register";
	formObject.method="GET";
	formObject.action=targetUrl
	formObject.submit(obj);
	}
</script>
    
 </head>
 <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<body >
    <!--
    you can substitue the span of reauth email for a input with the email and
    include the remember me checkbox
    -->
    <div class="container" >
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
        
		    <form:form name="loginPage" action="dologin" method="post" commandName="loginform" cssClass="form-signin" >
                   <span id="reauth-email" class="reauth-email"></span>
                Email address <form:input type="text" id="inputEmail" cssClass="form-control" path="userName"/>
                <form:errors path="userName" cssClass="error"/>
                
                Password <form:input type="password" id="inputPassword" cssClass="form-control" path="pwd"/>
                <form:errors path="pwd" cssClass="error"/>
                <div id="remember" class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                
                
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
            </form:form>
            <!-- /form -->
            Don't have any account yet?<a href="/EAHealth/register" class="forgot-password"> Create an account</a>
        </div>
        <!-- /card-container -->
    </div>
     <footer>
        <address>&copy; Copyright 2016 All Rights Reserved</address>
    </footer>
</body>

</html>