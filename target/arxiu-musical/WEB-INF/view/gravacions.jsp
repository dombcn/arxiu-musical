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
					<h3>${titGrav}</h3>
				</div>
			</div>
			
			<a href="${pageContext.request.contextPath}/lector/gravacions"
				class="btn btn-primary mb-1 disabled" aria-disabled="true">Gravacions</a>
			<a href="${pageContext.request.contextPath}/lector/autors"
				class="btn btn-primary mb-1">Autors</a>
			<a href="${pageContext.request.contextPath}/lector/generes"
				class="btn btn-primary mb-1">Gèneres</a>
			<a href="${pageContext.request.contextPath}/lector/locGrav"
				class="btn btn-success mb-1">Loc. Gravacions</a>
			<a href="${pageContext.request.contextPath}/lector/localitzacions"
				class="btn btn-success mb-1">Localitzacions</a>
			<a href="${pageContext.request.contextPath}/lector/formats"
				class="btn btn-success mb-1">Formats</a>
				
			<sec:authorize access="hasRole('EDITOR')">
				<a href="${pageContext.request.contextPath}/editor/addGravacio"
					class="btn btn-warning mb-1 float-right">Afegir Gravació</a>
			</sec:authorize>
			
			<table class="table table-striped">
				<tr>
					<th>Id</th>
					<th>Intèrpret</th>
					<th>Compositor</th>
					<th>Gènere</th>
					<th>Àlbum</th>
					<th>Any</th>
					<th>Núm. Temes</th>
					<th>Localitzacions</th>
					<sec:authorize access="hasRole('EDITOR')">
						<th>Accions</th>
					</sec:authorize>
				</tr>
				
				<c:forEach var="gravacio" items="${gravacions}">
					<c:url var="linkUpdate" value="/editor/updateGravacio">
						<c:param name="idGravacio" value="${gravacio.idGravacio}" />
					</c:url>
					<c:url var="linkDelete" value="/editor/deleteGravacio">
						<c:param name="idGravacio" value="${gravacio.idGravacio}" />
					</c:url>
					<c:url var="linkLocGrav" value="/lector/locGravGravacio">
						<c:param name="idGravacio" value="${gravacio.idGravacio}" />
					</c:url>
					<tr>
					
						<td>${gravacio.idGravacio}</td>
						<td>${gravacio.interpret.nom}</td>
						<td>${gravacio.compositor.nom}</td>
						<td>${gravacio.genere.nom}</td>
						<td>${gravacio.album}</td>
						<td>${gravacio.anyGrav}</td>
						<td>${gravacio.numTemes}</td>
						<td>
							<c:choose>
								<c:when test="${fn:length(gravacio.localitzacioGravacions) > 0}">
									<a href="${linkLocGrav}">${fn:length(gravacio.localitzacioGravacions)}</a>
								</c:when>
								<c:otherwise>
									${fn:length(gravacio.localitzacioGravacions)}
								</c:otherwise>
							</c:choose>
						</td>
	
						<sec:authorize access="hasRole('EDITOR')">
							<td>
								<a href="${linkUpdate}" class="btn btn-outline-success btn-sm">Editar</a>
								<c:choose>
									<c:when test="${fn:length(gravacio.localitzacioGravacions) > 0}">
										<a href=""
										class="btn btn-outline-danger btn-sm disabled"
										aria-disabled="true">Eliminar</a>
									</c:when>
									<c:otherwise>
										<a href="${linkDelete}"
										onclick="if(!confirm('Segur que vols eliminar aquesta gravació?')) return false"
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
