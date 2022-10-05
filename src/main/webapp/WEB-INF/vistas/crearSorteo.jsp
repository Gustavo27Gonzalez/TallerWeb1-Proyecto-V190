<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Sorteo</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>


	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 add-margin-b2">
			
			<form:form action="validar-crearSorteo" method="POST"
				modelAttribute="datosSorteo">

				<div class="form-outline mb-4">
					<form:label class="form-label" for="nombre" path="nombre">Nombre</form:label>
					<form:input path="nombre" type="text" id="nombre"
						placeholder="Nombre del Sorteo..." class="form-control" />
				</div>

				</br>

				<div class="form-outline mb-4">
					<form:label class="form-label" for="descripcion" path="descripcion">Descripción</form:label>
					<form:input path="descripcion" type="text" id="descripcion"
						placeholder="Descripción del Premio..." class="form-control" />
				</div>

				</br>

				<div class="form-outline mb-4">
					<form:label class="form-label" for="precioRifa" path="precioRifa">Precio de cada Rifa</form:label>
					<form:input path="precioRifa" type="text" id="precioRifa"
						placeholder="Precio de cada Rifa..." class="form-control" />
				</div>

				</br>

				<div class="form-outline mb-4">
					<form:label class="form-label" for="cantidadRifas"
						path="cantidadRifas">Cantidad de Rifas</form:label>
					<form:input path="cantidadRifas" type="text" id="cantidadRifas"
						placeholder="Cantidad de Rifas..." class="form-control" />
				</div>

				</br>

				<button class="btn btn-lg btn-primary btn-block add-margin-b2"
					type="Submit">Crear</button>

				</br>

			</form:form>

			<button>
				<a href="usuarioInicio">Volver </a>
			</button>


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