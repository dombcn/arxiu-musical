<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

		<style>
			body { background-color: lightgrey; padding-top: 25px; padding-bottom: 25px; }
			.carousel { height:400px; padding-top: 25px; }
			.carousel-inner > .carousel-item > img { height:500px; object-fit: contain; }
		</style>
	</head>
	<body>
		<div class="container">	
			<h1>Arxiu Musical</h1>
			<div>
				Aplicació web per a gestionar una col·lecció de música. Es poden introduir
				<a href="${pageContext.request.contextPath}/lector/gravacions"
					class="badge badge-warning">Gravacions</a>
				de diferents
				<a href="${pageContext.request.contextPath}/lector/autors"
		   			class="badge badge-warning">Autors</a>
				(intèrprets i compositors) i diferents
				<a href="${pageContext.request.contextPath}/lector/generes"
		   			class="badge badge-warning">Gèneres</a>
		   		musicals. Els
		   		<a href="${pageContext.request.contextPath}/lector/formats"
		   			class="badge badge-warning">Formats</a>
		   		dels àlbums poden ser físics (LPs, CDs, ...) i/o digitals (MP3, AAC, ...), i es guarden les
		   		<a href="${pageContext.request.contextPath}/lector/localitzacions"
		   			class="badge badge-warning">Localitzacions</a>
		   		físiques o informàtiques d'on es troben.
	   		</div>
		</div>
		<div id="carouselMusicRec" class="carousel carousel-fade slide" data-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img class="d-block w-100" src="${pageContext.request.contextPath}/resources/images/img1.png" alt="img1">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" src="${pageContext.request.contextPath}/resources/images/img2.png" alt="img2">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" src="${pageContext.request.contextPath}/resources/images/img3.png" alt="img3">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" src="${pageContext.request.contextPath}/resources/images/img4.png" alt="img4">
				</div>
			</div>
		</div>
	</body>
</html>
