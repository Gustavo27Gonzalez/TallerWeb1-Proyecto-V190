<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Sorteo</title>
<!-- Bootstrap theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/styles.css" rel="stylesheet">
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
	<a class="btn btn-danger ml-2" href="login-index" role="button">Volver</a>
</div>
	<div>
		<h1 class="font-weight-bold">SORTEA2</h1>
	</div>

	<div class="container d-flex justify-content-center">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 add-margin-b2">

			<form:form action="validar-crearSorteo" method="POST"
				modelAttribute="datosSorteo">

				<div class="form-outline mb-4">
					<form:label class="form-label text-light" for="nombre" path="nombre">Nombre</form:label>
					<form:input path="nombre" type="text" id="nombre"
						placeholder="Nombre del Sorteo..." class="form-control" />
				</div>


				<div class="form-outline mb-4">
					<form:label class="form-label text-light" for="descripcion" path="descripcion">Descripción</form:label>
					<form:input path="descripcion" type="text" id="descripcion"
						placeholder="Descripción del Premio..." class="form-control" />
				</div>

				<div class="form-outline mb-4">
					<form:label class="form-label text-light" for="precioRifa" path="precioRifa">Precio de cada Rifa</form:label>
					<form:input path="precioRifa" type="text" id="precioRifa"
						placeholder="Precio de cada Rifa..." class="form-control" />
				</div>

				<div class="form-outline mb-4">
					<form:label class="form-label text-light" for="cantidadRifas"
						path="cantidadRifas">Cantidad de Rifas</form:label>
					<form:input path="cantidadRifas" type="text" id="cantidadRifas"
						placeholder="Cantidad de Rifas..." class="form-control" />
				</div>
				<form:label class="form-label text-light" path="tipoAlgoritmo">Tipo de sorteo</form:label>
				<form:select path="tipoAlgoritmo" class="form-control">

					<form:options items="${algoritmos}" />
				</form:select>

<%--				<form:select class="text-light form-select form-select-lg mb-3" style="color: #797D7F; background-color: #3d4756" name="algoritmo">--%>
<%--					<c:forEach items="${algoritmos}" var="algoritmo" varStatus="loop">--%>
<%--						<form:option value="${loop.index}" class="card-text text-light" path="tipoAlgoritmo" id="tipoAlgoritmo">--%>
<%--								${algoritmo}--%>
<%--						</form:option>--%>
<%--					</c:forEach>--%>
<%--				</form:select>--%>

				<button class="btn btn-lg btn-primary btn-block add-margin-b2 mt-3"
					type="Submit">Crear sorteo</button>

			</form:form>

			<%--Bloque que es visible si el elemento error no esta vacio	--%>
			<c:if test="${not empty error}">
				<h4>
					<span>${error}</span>
				</h4>
				<br>
			</c:if>
			${msg}
		</div>
	</div>

	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>