<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recuperar Contraseña</title>
</head>
<body>
	<h1>RECOVERY</h1>
	
	<form:form action="recuperar" method="POST" modelAttribute="email">
		<input>
		<button class="btn btn-lg btn-success btn-block" Type="Submit"/ >Enviar</button>
	</form:form>
	
</body>
</html>