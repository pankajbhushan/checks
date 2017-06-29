<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="todo application">
<meta name="author" content="Pankaj Bhushan">
<link type="text/css" rel="stylesheet"
	href="/resources/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="/resources/css/bootstrap-theme.min.css">
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
</head>
<body style="background-color: grey">

	<c:set var="context" value="${pageContext.request.contextPath}" />
	<%-- <c:if test="${logout ne null}">
		<div class="success">
			<c:out value="Logged out successfully"></c:out>
		</div>
	</c:if> --%>
	<c:if test="${param.logout != null}">
		<div class="alert alert-success">You have been logged out.</div>
	</c:if>

	<c:if test="${error ne null}">
		<div class="failure">
			<c:out value="Invalid Credentials supplied."></c:out>
		</div>
	</c:if>

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



	<c:if test="${registerMessage ne null}">
		<div class="success">
			<c:out value="${registerMessage}"></c:out>
		</div>
	</c:if>
	<h3>Register below to create a new account:</h3>
	<form action="${context}/login/register" method="post">
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

</body>
</html>
