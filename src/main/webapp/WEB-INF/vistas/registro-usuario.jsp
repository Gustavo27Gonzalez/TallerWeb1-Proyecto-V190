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
			<%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
			<%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
			<%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
			<form:form action="registrar-usuario" method="POST"
				modelAttribute="datosRegistro">

				<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
				<div class="form-outline mb-4">
					<form:label class="form-label" for="nombre" path="nombre">Nombre</form:label>
					<form:input path="nombre" type="text" id="nombre" placeholder="Ingrese su Nombre..."
						class="form-control" />
				</div>
				
				</br>
				
				<div class="form-outline mb-4">
					<form:label class="form-label" for="dni" path="dni">DNI</form:label>
					<form:input path="dni" type="text" id="dni" placeholder="Ingrese su DNI..."
						class="form-control" />
				</div>
				
				</br>
				
				<div class="form-outline mb-4">
					<form:label class="form-label" for="email" path="email">Email</form:label>
					<form:input path="email" type="email" id="email" placeholder="Ingrese su Email..."
						class="form-control" />
				</div>
				
				</br>
				
				<div class="form-outline mb-4">
					<form:label class="form-label" for="password" path="password">Contrase�a</form:label>
					<form:input path="password" type="password" id="password" placeholder="Ingrese su Contrase�a..."
						class="form-control" />
				</div>
				
				</br>
				
				<div class="form-outline mb-4">
					<form:label class="form-label" for="repitePassword" path="repitePassword">Repita su Contrase�a</form:label>
					<form:input path="repitePassword" type="password" id="repitePassword" placeholder="Ingrese Nuevamente su Contrase�a..."
						class="form-control" />
				</div>
				
				</br>
				
				<button class="btn btn-lg btn-primary btn-block add-margin-b2"
					type="Submit">Registrarme</button>
					
				</br>
					
			</form:form>
			
			<a href="login"	>�Ya posee una cuenta? <strong style="color: black;">Ingrese con sus datos</strong></a>
			
			
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