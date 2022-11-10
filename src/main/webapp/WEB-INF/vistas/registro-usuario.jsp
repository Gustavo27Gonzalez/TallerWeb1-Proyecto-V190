<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="background.jsp"/>
	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 add-margin-b2">

	<div class="d-flex justify-content-center">

		<div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 ">
			<form:form action="registrar-usuario" method="POST" modelAttribute="datosRegistro">

				<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
				<div class="mb-2">
					<form:label class="form-label text-light" for="nombre" path="nombre">Nombre(*)</form:label>
					<form:input path="nombre" type="text" id="nombre" placeholder="Ingresar nombre" class="form-control" />
				</div>


				<div class="mb-2">
					<form:label class="form-label text-light" for="dni" path="dni">DNI(*)</form:label>
					<form:input path="dni" type="text" id="dni" placeholder="Ingresar número de documento" class="form-control" />
				</div>


				<div class="mb-2">
					<form:label class="form-label text-light" for="email" path="email">Email(*)</form:label>
					<form:input path="email" type="email" id="email" placeholder="Ingresar email" class="form-control" />
				</div>
				

				<div class="mb-2">
					<form:label class="form-label text-light" for="password" path="password">Contraseña(*)</form:label>
					<form:input path="password" type="password" id="password" placeholder="Ingresar contraseña" class="form-control" />
				</div>


				<div class="mb-4">
					<form:label class="form-label text-light" for="repitePassword" path="repitePassword">Repita su Contraseña(*)</form:label>
					<form:input path="repitePassword" type="password" id="repitePassword" placeholder="Ingresar nuevamente su contraseña" class="form-control" />
				</div>

				<button class="btn btn-lg btn-success btn-block mb-3" type="Submit">Registrarme</button>


			</form:form>
			
			<div class="container">
				<div class="d-flex align-items-center justify-content-center">
					<p class="text-light" style="font-size: 25px;">¿Ya posee una cuenta?</p>
					<p class="text-light ml-2" style="font-size: 18px;">Ingrese con sus datos <strong><a href="login"> acá</a></strong></p>
				</div>
			</div>


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

</body>
</html>