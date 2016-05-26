<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<style>
    .error {
        color: red; font-weight: bold;
    }
</style>
</head>
<body>
	<div align="center">
		<form:form action="register" method="post" commandName="userForm">
		<form:errors path="*" cssClass="error" />
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>User Registration</h2></td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td><form:input path="username" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><form:select path="gender" items="${genderList}" /></td>
				</tr>
				<tr>
					<td>Height:</td>
					<td><form:select path="heightft" items="${heightfeetList}" /></td><td>ft</td>
					<td><form:select path="heightinch" items="${heightinchList}"/></td><td>inch</td>
				</tr>
				<tr>
					<td>Age:</td>
					<td><form:input path="age" /></td>
				</tr>
				<tr>
					<td>Weight:</td>
					<td><form:input path="weight" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Register" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>