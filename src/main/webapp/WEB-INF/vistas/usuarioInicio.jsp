<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sortea2 | Inicio</title>
<!-- Bootstrap theme -->
<!-- Bootstrap theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="background.jsp"/>
	<!-------------------------------------------------------------------------->
	<div class="d-flex justify-content-end navegador">
		<nav class="navbar ">
			<form class="form-inline">
				<a class="btn btn-danger" href="login" role="button">Salir</a>
			</form>
		</nav>
	</div>
	<!-------------------------------------------------------------------------->
	
	<div class="container">
		<h1 class="font-weight-bold">Sortea2</h1>
		<h3 class="font-weight-light">La mejor app de sorteos</h3>
	</div>

	<!-------------------------------------------------------------------------->
	
	<div class="d-flex justify-content-center align-items-center" style="margin-top: 5rem;">

		<div class="col-sm-4 mb-4 align-self-stretch ">

			<div class="card shadow-lg  bg-white">

				<div class="card-body border border-dark carta-sorteos">
					<h3 class="card-title text-light"
						style="color: #797D7F; text-align: center;">Crear Sorteo</h3>
				</div>
				<a class="btn btn-success" href="crearSorteo" role="button">Crear</a>

			</div>
		</div>

		<div class="col-sm-4 mb-4 align-self-stretch">

			<div class="card shadow-lg  bg-white">

				<div class="card-body border border-dark carta-sorteos">
					<h3 class="card-title text-light"
						style="color: #797D7F; text-align: center;">Listar Sorteos</h3>
				</div>
				<a class="btn btn-success" href="listado-sorteos" role="button">Ver Sorteos</a>

			</div>
		</div>
		
		<div class="col-sm-4 mb-4 align-self-stretch ">

			<div class="card shadow-lg  bg-white">

				<div class="card-body border border-dark carta-sorteos">
					<h3 class="card-title text-light"
						style="color: #797D7F; text-align: center;">Mis Sorteos Creados</h3>
				</div>
				<!--TODO: SE CAMBIÓ POR VER MIS SORTEOS, ACÁ ESTABA VER USUARIOS-->
				<a class="btn btn-success" href="mis-sorteos" role="button">Ver mis sorteos</a>

			</div>
		</div>
		
		<div class="col-sm-4 mb-4 align-self-stretch">

			<div class="card shadow-lg  bg-white">

				<div class="card-body border border-dark carta-sorteos">
					<h3 class="card-title text-light"
						style="color: #797D7F; text-align: center;">Listar Mis Rifas</h3>
				</div>
				<a class="btn btn-success" href="mis-rifas" role="button">Ver Mis Rifas</a>

			</div>
		</div>
		
	</div>
	<!-------------------------------------------------------------------------->


</body>
</html>