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
<!------ Include the above in your HEAD tag ---------->
<title>Sortea2 |  Rifas vendidas</title>
</head>
<body>
	<jsp:include page="background.jsp"/>
	<div class="d-flex justify-content-end navegador">
		<nav class="navbar ">
			<form class="form-inline">
				<a class="btn btn-danger ml-2 d -flex justify-content-start" href="mis-sorteos" role="button">Volver</a>
				<a class="btn btn-danger" href="login" role="button">Salir</a>
			</form>
		</nav>
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