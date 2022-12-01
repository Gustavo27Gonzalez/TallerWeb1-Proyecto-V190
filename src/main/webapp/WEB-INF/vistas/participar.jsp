<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<%--	allos ancestor mercado pago--%>
<meta charset="ISO-8859-1"
	  ttp-equiv="Content-Security-Policy" content="
	  frame-src 'self' *.mercadopago.com.ar;"
	 >



<%--	<meta http-equiv="Content-Security-Policy" content="--%>
<%--    default-src 'self';--%>
<%--    script-src 'report-sample' 'self' https://http2.mlstatic.com/storage/event-metrics-sdk/js https://sdk.mercadopago.com/js/v2 https://www.mercadopago.com.mx/;--%>
<%--    style-src 'report-sample' 'self';--%>
<%--    object-src 'none'; base-uri 'self';--%>
<%--    connect-src 'self' https://events.mercadopago.com;--%>
<%--    font-src 'self' data:;--%>
<%--    frame-src 'self' https://www.mercadopago.com.mx;--%>
<%--    img-src 'self';--%>
<%--    manifest-src 'self';--%>
<%--    media-src 'self';--%>
<%--    worker-src 'self';">--%>

<!-- Bootstrap theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	<script src="https://sdk.mercadopago.com/js/v2"></script>
	<script>
		try {
			const mp = new MercadoPago('TEST-592d7fd3-e293-4461-a77c-74df0fd62bb3', {
				locale: 'es-AR'
			});

			mp.checkout({
				preference: {
					id: 'YOUR_PREFERENCE_ID'
				},
				render: {
					container: '.cho-container',
					label: 'Pagar',
				}
			});

		}
		catch (error) {
			console.log(error);
		}
	</script>
<link href="css/styles.css" rel="stylesheet">
	<title>Sortea2 |  Listado de Rifas</title>
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
			<h3 class="font-weight-bold">Comprar rifa</h3>
		</div>

		<div class="d-flex justify-content-center flex-wrap" style="margin-top: 5rem;">
			<div class="col-sm-4 mb-4 align-self-stretch ">
				<div class="card-counter danger">
					<i class="fa fa-ticket"></i>
					<span class="count-numbers">${sorteo.nombre}</span>
					<span class="count-name">${sorteo.descripcion}</span>
				</div>
			</div>
		</div>
		<div class="d-flex justify-content-center flex-wrap" style="margin-top: 1rem;">
			<a class="btn btn-primary" href="comprar" role="button" type="submit">Comprar: $ ${sorteo.precioRifa}</a>
		</div>
<%--		<div class="cho-container"></div>--%>

	</body>
</html>