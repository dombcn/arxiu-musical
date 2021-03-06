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
					<h3>Formats</h3>
				</div>
			</div>
			
			<a href="${pageContext.request.contextPath}/lector/gravacions"
				class="btn btn-primary mb-1">Gravacions</a>
			<a href="${pageContext.request.contextPath}/lector/autors"
				class="btn btn-primary mb-1">Autors</a>
			<a href="${pageContext.request.contextPath}/lector/generes"
				class="btn btn-primary mb-1">Gèneres</a>
			<a href="${pageContext.request.contextPath}/lector/locGrav"
				class="btn btn-success mb-1">Loc. Gravacions</a>
			<a href="${pageContext.request.contextPath}/lector/localitzacions"
				class="btn btn-success mb-1">Localitzacions</a>
			<a href="${pageContext.request.contextPath}/lector/formats"
				class="btn btn-success mb-1 disabled" aria-disabled="true">Formats</a>
				
			<sec:authorize access="hasAnyRole('EDITOR','ADMIN')">
				<a href="${pageContext.request.contextPath}/admin/addFormat"
					class="btn btn-warning mb-1 float-right">Afegir Format</a>
			</sec:authorize>
		
			<table class="table table-striped">
				<tr>
					<th>Id</th>
					<th>Nom Format</th>
					<th>Gravacions</th>
					<sec:authorize access="hasAnyRole('EDITOR','ADMIN')">
						<th>Accions</th>
					</sec:authorize>
				</tr>
				
				<c:forEach var="format" items="${formats}">
					<c:url var="linkUpdate" value="/admin/updateFormat">
						<c:param name="idFormat" value="${format.idFormat}" />
					</c:url>
					<c:url var="linkDelete" value="/admin/deleteFormat">
						<c:param name="idFormat" value="${format.idFormat}" />
					</c:url>
					<c:url var="linkLocGravFormat" value="/lector/locGravFormat">
						<c:param name="idFormat" value="${format.idFormat}" />
					</c:url>
					<tr>
						<td>${format.idFormat}</td>
						<td>${format.nom}</td>
						<td>
							<c:choose>
								<c:when test="${fn:length(format.localitzacioGravacions) > 0}">
									<a href="${linkLocGravFormat}">${fn:length(format.localitzacioGravacions)}</a>
								</c:when>
								<c:otherwise>
									${fn:length(format.localitzacioGravacions)}
								</c:otherwise>
							</c:choose>
						</td>
						<sec:authorize access="hasAnyRole('EDITOR','ADMIN')">
							<td>
								<a href="${linkUpdate}" class="btn btn-outline-success btn-sm">Editar</a>
								<c:choose>
									<c:when test="${fn:length(format.localitzacioGravacions) > 0}">
										<a href=""
										class="btn btn-outline-danger btn-sm disabled"
										aria-disabled="true">Eliminar</a>
									</c:when>
									<c:otherwise>
										<a href="${linkDelete}"
										onclick="if(!confirm('Segur que vols eliminar aquest format?')) return false"
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
