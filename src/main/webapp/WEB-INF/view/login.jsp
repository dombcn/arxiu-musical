<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		
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
			<h2>Login</h2>
			
			<!-- Mensaje de error -->
			<c:if test="${param.error!=null}">
				<div class="alert alert-danger"><strong>Error</strong> en el nom d'usuari o la contrasenya.</div>
			</c:if>
			
			<h4>Introdueixi les seves credencials</h4>
			<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
				<div class="input-group mb-3">
					<div class="input-group-prepend w-25">
						<span class="input-group-text w-100">Nom d'usuari</span>
					</div>
					<input type="text" class="form-control" placeholder="Usuari" name="username" />
				</div>
				<div class="input-group mb-3">
					<div class="input-group-prepend w-25">
						<span class="input-group-text w-100">Contrasenya</span>
					</div>
					<input type="password" class="form-control" placeholder="Contrasenya" name="password" />
				</div>
				<button type="submit" class="btn btn-primary">Login</button>
			</form:form>
		</div>
	</body>
</html>
