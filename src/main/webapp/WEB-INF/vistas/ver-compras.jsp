<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="css/styles.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>COMPRAS</title>
</head>
<body>
	<h1>Mis compras</h1>
	
	<div class="d-flex justify-content-center flex-wrap"
		style="margin-top: 5rem;">
		<c:forEach var="COMPRA" items="${compras}">
			<div class="col-sm-4 mb-4 align-self-stretch ">
				<div class="card shadow-lg  bg-white">

					<div class="card-body border border-dark carta-sorteos">
						<h3 class="card-title text-light" style="color: #797D7F; text-align: center;">Número de compra: ${COMPRA.id}</h3>
						<h3 class="card-title text-light" style="color: #797D7F; text-align: center;">Numero de rifa: ${COMPRA.numeroDeRifa}</h3>
						<h3 class="card-title text-light" style="color: #797D7F; text-align: center;">Comprador: ${COMPRA.nombreUsuario}</h3>

					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	
	
</body>
</html>