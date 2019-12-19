<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Accés denegat</title>
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<!-- Popper JS -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		
		<style>
			body { background-color: lightgrey; padding-top: 25px; }
		</style>
	</head>
	<body>
		<div class="container">
			<h1 class="text-danger">Accés denegat</h1>
			<p>Usuari: <sec:authentication property="principal.username" /></p>
			<p>Rols: <sec:authentication property="principal.authorities" /></p>
			<form:form action="${pageContext.request.contextPath}/logout" method="POST">
				<button type="submit" class="btn btn-warning">Sortir</button>
			</form:form>
		</div>
	</body>
</html>
