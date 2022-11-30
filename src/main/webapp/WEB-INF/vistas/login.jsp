<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<!-- Bootstrap theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/styles.css" rel="stylesheet">
<title>Sortea2 | Iniciar sesi�n</title>
</head>
<body>
	<jsp:include page="background.jsp"/>

	<!-------------------------------------------------------------------------->

	<div class="container">
		<h1 class="font-weight-bold">Bienvenido a Sortea2</h1>
		<h3 class="font-weight-light">La mejor app de sorteos</h3>
	</div>

	<!-------------------------------------------------------------------------->

	<div class="container login-box">
		<div>
			<form:form action="validar-login" method="POST"
				modelAttribute="datosLogin">

				<div class="form-outline mb-3">
					<form:label class="form-label text-light" for="email" path="email">Email</form:label>
					<form:input path="email" type="email" id="email"
						placeholder="Ingrese su Email..." class="form-control" />
				</div>

				<div class="form-outline mb-4">
					<form:label class="form-label text-light" for="password" path="password">Contraseña</form:label>
					<form:input path="password" type="password" id="password" placeholder="Ingrese su Contrase�a..." class="form-control" />
				</div>
				<button class="btn btn-lg btn-success btn-block add-margin-b2" Type="Submit" />Login</button>
			</form:form>


			<div class="d-flex justify-content-between pt-2">
				<a class="btn btn-outline-info" href="registrar-usuario" role="button">Registrarme</a>
				<a class="btn btn-outline-info" href="recuperar-contrase�a" role="button">Olvid� mi Contrase�a</a>
				<a class="btn btn-outline-info" href="compras" role="button">PROBAR</a>
			</div>

			</br>
			<%--Bloque que es visible si el elemento error no esta vacio	--%>
			<c:if test="${not empty error}">
				<h4>
					<span class="text-danger">${error}</span>
				</h4>
				<br>
			</c:if>
			<p class="text-light">${msg}
		</div>

	</div>
	

</body>
</html>
