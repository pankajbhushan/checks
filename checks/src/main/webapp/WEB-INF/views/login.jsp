<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../../resources/css/main.css">
</head>
<body>
	<form action="j_spring_security_check" method="post">
		<table>
			<tr>
				<td> Enter Username: </td>
				<td><input id="username" type="text" name="username" placeholder="enter Username"></td>
			</tr>
			<tr>
				<td> Enter Password </td>
				<td><input id="password" type="password" name="password" placeholder="enter password"></td>		
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Log In"></td>
			</tr>
		</table>
	</form>

	<h3>Register below to create a new account: </h3>
	<form action="/checks/register" method="post">
		<table>
			<tr>
				<td><input type="text" name="firstName" placeholder="First Name"></td>
				<td><input type="text" name="lastName" placeholder="Last Name"></td>
			</tr>
			<tr>
				<td> Enter Email id: </td>
				<td><input type="email" name="email" placeholder="enter email"></td>
			</tr>
			<tr>
				<td> Enter Password </td>
				<td><input type="password" name="password" placeholder="enter password"></td>		
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>
</body>
</html>
