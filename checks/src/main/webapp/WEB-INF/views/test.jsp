<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Testing find by userName</title>
</head>
<body>
	
	<label class="jumbotron text-center">Enter UserName : </label>
	<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
	<form method="post" action="${contextpath}/login/finduser">
		<input id="username" type="text" name="username" /><br/>
		<input class="button" type="submit" value="Find User"/>
	</form>
	
	Test Result : <c:out value="${result}"></c:out>
	
</body>
</html>