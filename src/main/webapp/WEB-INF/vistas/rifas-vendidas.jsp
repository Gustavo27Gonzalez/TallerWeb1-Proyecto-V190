<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap theme -->
	<style>
		.card-counter{
			box-shadow: 2px 2px 10px #DADADA;
			margin: 5px;
			padding: 20px 10px;
			background-color: #fff;
			height: 100px;
			border-radius: 5px;
			transition: .3s linear all;
		}

		.card-counter:hover{
			box-shadow: 4px 4px 20px #DADADA;
			transition: .3s linear all;
		}

		.card-counter.primary{
			background-color: #007bff;
			color: #FFF;
		}

		.card-counter.danger{
			background-color: #ef5350;
			color: #FFF;
		}

		.card-counter.success{
			background-color: #66bb6a;
			color: #FFF;
		}

		.card-counter.info{
			background-color: #26c6da;
			color: #FFF;
		}

		.card-counter i{
			font-size: 5em;
			opacity: 0.2;
		}

		.card-counter .count-numbers{
			position: absolute;
			right: 35px;
			top: 20px;
			font-size: 32px;
			display: block;
		}

		.card-counter .count-name{
			position: absolute;
			right: 35px;
			top: 65px;
			font-style: italic;
			text-transform: capitalize;
			opacity: 0.5;
			display: block;
			font-size: 18px;
		}
	</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/styles.css" rel="stylesheet">
<!------ Include the above in your HEAD tag ---------->
<title>Sortea2 |  Listado de usuarios</title>
</head>
<body>
	<jsp:include page="background.jsp"/>
	<div>
		<a class="btn btn-danger ml-2" href="login-index" role="button">Volver</a>
	</div>
	<div>
		<h1 class="font-weight-bold">SORTEA2</h1>
	</div>
	
	<!-- ----------------------------------------------------------------------------------- -->
	<div class="d-flex justify-content-center">

	</div>

	<!-- ----------------------------------------------------------------------------------- -->


	<div class="d-flex justify-content-center flex-wrap"
		style="margin-top: 5rem;">
		<c:forEach var="rifa" items="${rifas}">

			<div class="col-md-3">
				<div class="card-counter danger">
					<i class="fa fa-ticket"></i>
					<span class="count-numbers">Id rifa: ${rifa.id}</span>
					<span class="count-name">Id comprador: ${rifa.usuario}</span>
				</div>
			</div>



<%--			<div class="col-sm-4 mb-4 align-self-stretch ">--%>
<%--				<div class="card shadow-lg  bg-white">--%>

<%--					<div class="card-body border border-dark carta-sorteos">--%>
<%--						<h3 class="card-title text-light"--%>
<%--							style="color: #797D7F; text-align: center;">Id rifa: ${rifa.id}</h3>--%>
<%--						<p class="card-text text-light" style="color: #797D7F">Id comprador:--%>
<%--							${rifa.usuario}</p>--%>
<%--						<c:if test="${preseleccionado == true}">--%>
<%--							<p class="card-text text-light" style="color: #424949">Rifa ganadora:--%>
<%--								${rifa.esRifaGanadora()}</p>--%>
<%--						</c:if>--%>
<%--					</div>--%>
<%--				</div>--%>
<%--			</div>--%>
		</c:forEach>
	</div>


</body>
</html>