<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Arxiu Musical</title>
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

		<!-- Popper JS -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
						
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css" />
		
	</head>
	<body>
		<div class="container">
			<div class="jumbotron">
				<div class="float-right">
					[ <sec:authentication property="principal.username" /> ]
					<form:form action="${pageContext.request.contextPath}/logout" method="POST">
						<button type="submit" class="btn btn-dark mt-1">Sortir</button>
					</form:form>
				</div>
				<div>
					<h1>Arxiu Musical</h1>
					<h3>${titNewUpdate}</h3>
					<h6 class="error">${msgGenError}</h6>
				</div>
			</div>
	
			<form:form action="saveLocGrav" modelAttribute="localitzacioGravacio" method="post">
				<form:hidden path="idLocGrav" />
				<div class="form-group">
					<label for="nombre">Àlbum (Intèrpret):</label>
					<form:select class="form-control" path="gravacio.idGravacio">
						<form:option value="${null}" label="--Selecciona--" />
						<form:options items="${gravacions}" itemValue="idGravacio" itemLabel="albumInterpret" />
					</form:select>
					<p class="error">${msgGravacioNotNull}</>
				</div>
				<div class="form-group">
					<label for="nombre">Localització:</label>
					<form:select class="form-control" path="localitzacio.idLocalitzacio">
						<form:option value="${null}" label="--Selecciona--" />
						<form:options items="${localitzacions}" itemValue="idLocalitzacio" itemLabel="descLloc" />
					</form:select>
					<p class="error">${msgLocalitzacioNotNull}</>
				</div>
				<div class="form-group">
					<label for="nombre">Format:</label>
					<form:select class="form-control" path="format.idFormat">
						<form:option value="${null}" label="--Selecciona--" />
						<form:options items="${formats}" itemValue="idFormat" itemLabel="nom" />
					</form:select>
					<p class="error">${msgFormatNotNull}</>
				</div>
				<input type="submit" value="Guardar" class="btn btn-success" />
				<a href="${pageContext.request.contextPath}/lector/locGrav"
					class="btn btn-outline-primary float-right"> Tornar a llista de localitzacions de gravacions</a>
			</form:form>
		</div>
	</body>
</html>
