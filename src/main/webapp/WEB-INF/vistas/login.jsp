on<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/styles.css" rel="stylesheet">
<title>Sortea2 | Iniciar sesi&oacute;n</title>
</head>
<body>
	<jsp:include page="background.jsp"/>

	<!-------------------------------------------------------------------------->

	<div class="container">
		<h1 class="font-weight-bold">Bienvenido a Sortea2</h1>
		<h3 class="font-weight-light">La mejor app de sorteos</h3>
	</div>

	<!-------------------------------------------------------------------------->

	<div class="container login-box" style="width:40%;">
		<div>
			<form:form action="validar-login" method="POST"
				modelAttribute="datosLogin">

				<div class="form-outline mb-3">
					<form:label class="form-label text-light" for="email" path="email">Email</form:label>
					<form:input path="email" type="email" id="email"
						 class="form-control" />
				</div>

				<div class="form-outline mb-4">
<<<<<<< HEAD
					<form:label class="form-label text-light" for="password" path="password">Contrase�a</form:label>
					<form:input path="password" type="password" id="password" placeholder="Ingrese su Contrase�a..." class="form-control" />
=======
					<form:label class="form-label text-light" for="password" path="password">Contrase&ntilde;a</form:label>
					<form:input path="password" type="password" id="password"  class="form-control" />
>>>>>>> 2c6302636d84683fb494fd98635659246c0db860
				</div>
				<button class="btn btn-lg btn-success btn-block add-margin-b2" Type="Submit" />Login</button>
			</form:form>


			<div class="d-flex justify-content-between pt-2">
<<<<<<< HEAD
				<a class="btn btn-outline-info" href="registrar-usuario" role="button">Registrarme</a>
				<a class="btn btn-outline-info" href="recuperar-contrase�a" role="button">Olvid� mi Contrase�a</a>
				<a class="btn btn-outline-info" href="compras" role="button">PROBAR</a>
=======
				<a class="btn btn-primary" href="registrar-usuario" role="button">Registrarme</a>
				<a class="btn btn-success" href="recuperar-contraseña" role="button">Olvid&eacute; mi Contrase&ntilde;a</a>
>>>>>>> 2c6302636d84683fb494fd98635659246c0db860
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
