<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<form action="login">
		<table>
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
				<td><input type="submit" name="Log In"></td>
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
				<td><input type="submit" name="Register"></td>
			</tr>
		</table>
	</form>
</body>
</html>
