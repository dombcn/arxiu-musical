<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
					<h3>Autors</h3>
				</div>
			</div>
			
			<a href="${pageContext.request.contextPath}/lector/gravacions"
				class="btn btn-primary mb-1">Gravacions</a>
			<a href="${pageContext.request.contextPath}/lector/autors"
				class="btn btn-primary mb-1 disabled" aria-disabled="true">Autors</a>
			<a href="${pageContext.request.contextPath}/lector/generes"
				class="btn btn-primary mb-1">Gèneres</a>
			<a href="${pageContext.request.contextPath}/lector/locGrav"
				class="btn btn-success mb-1">Loc. Gravacions</a>
			<a href="${pageContext.request.contextPath}/lector/localitzacions"
				class="btn btn-success mb-1">Localitzacions</a>
			<a href="${pageContext.request.contextPath}/lector/formats"
				class="btn btn-success mb-1">Formats</a>
				
			<sec:authorize access="hasRole('EDITOR')">
				<a href="${pageContext.request.contextPath}/editor/addAutor"
					class="btn btn-warning mb-1 float-right">Afegir Autor</a>
			</sec:authorize>
		
			<table class="table table-striped">
				<tr>
					<th>Id</th>
					<th>Nom</th>
					<th>Informació</th>
					<th>Àlbums Intèrpret</th>
					<th>Àlbums Compositor</th>
					<sec:authorize access="hasRole('EDITOR')">
						<th>Accions</th>
					</sec:authorize>
				</tr>
				
				<c:forEach var="autor" items="${autors}">
					<c:url var="linkUpdate" value="/editor/updateAutor">
						<c:param name="idAutor" value="${autor.idAutor}" />
					</c:url>
					<c:url var="linkDelete" value="/editor/deleteAutor">
						<c:param name="idAutor" value="${autor.idAutor}" />
					</c:url>
					<c:url var="linkGravInter" value="/lector/gravacionsInterpret">
						<c:param name="idInterpret" value="${autor.idAutor}" />
					</c:url>
					<c:url var="linkGravComp" value="/lector/gravacionsCompositor">
						<c:param name="idCompositor" value="${autor.idAutor}" />
					</c:url>
					<tr>
						<td>${autor.idAutor}</td>
						<td>${autor.nom}</td>
						<td>${autor.info}</td>
						<td>
							<c:choose>
								<c:when test="${fn:length(autor.gravacionsInterpret) > 0}">
									<a href="${linkGravInter}">${fn:length(autor.gravacionsInterpret)}</a>
								</c:when>
								<c:otherwise>
									${fn:length(autor.gravacionsInterpret)}
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${fn:length(autor.gravacionsCompositor) > 0}">
									<a href="${linkGravComp}">${fn:length(autor.gravacionsCompositor)}</a>
								</c:when>
								<c:otherwise>
									${fn:length(autor.gravacionsCompositor)}
								</c:otherwise>
							</c:choose>
						</td>
						<sec:authorize access="hasRole('EDITOR')">
							<td>
								<a href="${linkUpdate}" class="btn btn-outline-success btn-sm">Editar</a>
								<c:choose>
									<c:when test="${fn:length(autor.gravacionsInterpret) > 0}">
										<a href=""
										class="btn btn-outline-danger btn-sm disabled"
										aria-disabled="true">Eliminar</a>
									</c:when>
									<c:when test="${fn:length(autor.gravacionsCompositor) > 0}">
										<a href=""
										class="btn btn-outline-danger btn-sm disabled"
										aria-disabled="true">Eliminar</a>
									</c:when>
									<c:otherwise>
										<a href="${linkDelete}"
										onclick="if(!confirm('Segur que vols eliminar aquest autor?')) return false"
										class="btn btn-outline-danger btn-sm">Eliminar</a>
									</c:otherwise>
								</c:choose>
							</td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>
