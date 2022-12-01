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
    <title>Sortea2 |  Listado de sorteos</title>
</head>
<body>
<!-------------------------------------------------------------------------->
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #121212">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="btn btn-danger ml-2" href="login-index" role="button">Volver</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <a class="btn btn-danger" href="login" role="button">Salir</a>
        </form>
    </div>
</nav>
<!-------------------------------------------------------------------------->
<jsp:include page="background.jsp"/>

<div>
    <h1 class="font-weight-bold">SORTEA2</h1>
</div>

<!-- ----------------------------------------------------------------------------------- -->
<div class="d-flex justify-content-center">

</div>

<!-- ----------------------------------------------------------------------------------- -->


<div class="d-flex justify-content-center flex-wrap"
     style="margin-top: 5rem;">
    <c:forEach var="SORTEO" items="${sorteos}">
        <c:if test="${SORTEO.sorteoCerrado == false}">
            <div class="col-sm-4 mb-4 align-self-stretch ">
                <div class="card-counter success">
                    <i class="fa fa-ticket"></i>
                    <span class="count-numbers">${SORTEO.nombre}</span>
                    <span class="count-name">Tipo sorteo: ${SORTEO.algoritmo}</span>
                    <div class="d-flex justify-content-between pt-2" style="position: absolute;top: 137px;left: 90px;">
                        <a class="btn btn-outline-succes"
                           href="listar-rifas?id=${SORTEO.id}" role="button">Ver rifas vendidas</a>
                        <a class="btn btn-outline-succes"
                           href="sortear?id=${SORTEO.id}" role="button">Sortear ganador</a>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${SORTEO.sorteoCerrado == true}">
            <div class="col-sm-4 mb-4 align-self-stretch ">
                <div class="card-counter danger">
                    <i class="fa fa-ticket"></i>
                    <span class="count-numbers">${SORTEO.nombre}</span>
                    <span class="count-name">Ganador: ${SORTEO.ganador}</span>
                </div>
            </div>
        </c:if>
<%--            <div class="card shadow-lg  bg-white">--%>
<%--                <div class="card-body border border-dark carta-sorteos">--%>
<%--                    <h3 class="card-title text-light" style="color: #797D7F; text-align: center;">${SORTEO.nombre}</h3>--%>
<%--                    <p class="card-text text-light" style="color: #424949">ID: ${SORTEO.id}</p>--%>
<%--                    <p class="card-text text-light" style="color: #797D7F">Descripcion: ${SORTEO.descripcion}</p>--%>
<%--                    <p class="card-text text-light" style="color: #797D7F">Precio: $${SORTEO.precioRifa}</p>--%>
<%--                    <p class="card-text text-light" style="color: #797D7F">Tipo algoritmo: ${SORTEO.algoritmo}</p>--%>

<%--                </div>--%>
<%--            </div>--%>
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