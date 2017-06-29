<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet" href="/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<link type="text/css" rel="stylesheet" href="/resources/css/main.css">
<title>Checks</title>
</head>
<body>
<%@ include file="commons/header.jspf" %>
<div class="container-fluid scrollable">
<h2>Welcome! <c:out value="${username}"/></h2> 
<h2><a href=<c:url value="/login?logout=true"></c:url>>logout</a></h2>
</div>

<%@ include file="commons/footer.jspf" %>