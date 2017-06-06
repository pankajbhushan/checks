<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../../resources/css/main.css">
</head>
<body style="background-color: grey">

	<c:set var="context" value="${pageContext.request.contextPath}" />
	<form:form action="j_spring_security_check" method="post">
		<table>
			<tr>
				<td>Enter Username:</td>
				<td><input id="username" type="text" name="username"
					placeholder="enter Username"></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input id="password" type="password" name="password"
					placeholder="enter password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Log In"></td>
			</tr>
		</table>
	</form:form>

	<h3>Register below to create a new account:</h3>
	<form action="${context}/login/register" method="post">
		<c:out value="${registerMessage}"></c:out>
		<table>
			<tr>
				<td><input type="text" name="firstName"
					placeholder="First Name"></td>
				<td><input type="text" name="lastName" placeholder="Last Name"></td>
			</tr>
			<tr>
				<td>Enter Email id:</td>
				<td><input type="email" name="new_username"
					placeholder="Enter email id"></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="new_password"
					placeholder="Enter password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Create Account"></td>
			</tr>
		</table>
	</form>
	<form method="post" action="${context}/login/finduser">
		<input id="fusername" type="text" name="fusername" /><br/>
		<input type="submit" value="Find User"/>
	</form>
	
	Test Result : <c:out value="${result}"></c:out>

</body>
</html>
