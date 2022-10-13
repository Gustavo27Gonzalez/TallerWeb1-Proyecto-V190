<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Sorteos</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>


	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 add-margin-b2">
			
			<table border="1" cellspacing="0">
			<tr align="center" style="font-weight: bold;">
				 <td> Id del Sorteo </td>
				 <td> Nombre del Sorteo </td>
				 
			</tr>
		<c:forEach items="${lista-sorteos}" var="sorteo" varStatus="s">
				<tr>
					<td align="center">${i.index}</td>
					<td>${s.nombre}</td>
					
					<td>
						 <!-- <a href="toUpdate?id=${sorteo.id }"> Editar </a>  -->
						 <!-- <a href="delete?id=${o.id }"> Eliminar </a>  -->
					</td>
				</tr>
			</c:forEach>
		</table>

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