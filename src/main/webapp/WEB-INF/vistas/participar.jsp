<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/styles.css" rel="stylesheet">
<title>Sortea2 |  Listado de Rifas</title>
</head>
<body>

	<div>
		<h1 class="font-weight-bold">SORTEA2</h1>
	</div>
	
	<!-- ----------------------------------------------------------------------------------- -->
	<div class="d-flex justify-content-center">
		<nav class="navbar navbar-expand-lg "
			style="background-color: #121212;">
			<a class="navbar-brand text-light" href="#">Navbar</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link text-light"
						href="login-index" style="background-color: #70a6ba;">Inicio<span
							class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a class="nav-link text-light" href="#">Features</a></li>
					<li class="nav-item"><a class="nav-link text-light" href="#">Pricing</a></li>
					<li class="nav-item"><a class="nav-link text-light" href="#">Disabled</a></li>
				</ul>
			</div>
		</nav>
	</div>

	<!-- ----------------------------------------------------------------------------------- -->
	<div>
		<a class="btn btn-danger ml-2" href="login-index" role="button">Volver</a>
	</div>

	<div class="d-flex justify-content-center flex-wrap"
		style="margin-top: 5rem;">
		<c:forEach var="RIFA" items="${rifas}">
			<div class="col-sm-4 mb-4 align-self-stretch ">
				<div class="card shadow-lg  bg-white">

					<div class="card-body border border-dark carta-sorteos">
						<h3 class="card-title text-light"
							style="color: #797D7F; text-align: center;">Rifa numero: ${RIFA.id}</h3>
						<!--
						<p class="card-text text-light" style="color: #797D7F">Precio:
							${SORTEO.precioRifa}</p>
						-->
						<div class="d-flex justify-content-end">
						
							<a class="btn btn-outline-info"
								href="participar" role="button">Comprar</a>
						</div>

					</div>
				</div>
			</div>
		</c:forEach>
	</div>


	<!--  <div class="container" style="text-align: center;">
		<table class="table tabla">
			<thead>
				<tr class="font-weight-light">
					<th scope="col">ID sorteo</th>
					<th scope="col">Nombre</th>
					<th scope="col">Descripción</th>
					<th scope="col">Precio $ARG</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="HOLA" items="${sorteos}">
					<tr>
						<td>${SORTEO.id}</td>
						<td>${SORTEO.nombre}</td>
						<td>${SORTEO.descripcion}</td>
						<td>${SORTEO.precioRifa}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>-->


</body>
</html>