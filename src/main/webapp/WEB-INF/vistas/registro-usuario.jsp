<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 add-margin-b2">
			<%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
			<%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
			<%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
			<form:form action="registrar-usuario" method="POST"
				modelAttribute="datosRegistro">

				<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
				<div class="form-outline mb-4">
					<form:label class="form-label" for="nombre" path="nombre">Nombre</form:label>
					<form:input path="nombre" type="nombre" id="nombre" placeholder="Ingrese su Nombre..."
						class="form-control" />
				</div>
				
				<div class="form-outline mb-4">
					<form:label class="form-label" for="dni" path="dni">DNI</form:label>
					<form:input path="dni" type="dni" id="dni" placeholder="Ingrese su DNI..."
						class="form-control" />
				</div>
				
				<div class="form-outline mb-4">
					<form:label class="form-label" for="email" path="email">Email</form:label>
					<form:input path="email" type="email" id="email" placeholder="Ingrese su Email..."
						class="form-control" />
				</div>
				
				<div class="form-outline mb-4">
					<form:label class="form-label" for="password" path="password">Contraseña</form:label>
					<form:input path="password" type="password" id="password" placeholder="Ingrese su Contraseña..."
						class="form-control" />
				</div>
				
				<div class="form-outline mb-4">
					<form:label class="form-label" for="repitePassword" path="repitePassword">Repita su Contraseña</form:label>
					<form:input path="repitePassword" type="password" id="repitePassword" placeholder="Ingrese Nuevamente su Contraseña..."
						class="form-control" />
				</div>

				<button class="btn btn-lg btn-primary btn-block add-margin-b2"
					type="Submit">Registrarme</button>
					
				</br>
					
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