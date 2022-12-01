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
	<div class="d-flex justify-content-end navegador">
		<nav class="navbar ">
			<form class="form-inline">
				<a class="btn btn-danger" href="login" role="button">Salir</a>
			</form>
		</nav>
	</div>
	<!-------------------------------------------------------------------------->
	<jsp:include page="background.jsp"/>
	<div>
		<a class="btn btn-danger ml-2" href="login-index" role="button">Volver</a>
	</div>
		<div>
			<h1 class="font-weight-bold">SORTEA2</h1>
		</div>

		<div class="d-flex justify-content-center flex-wrap" style="margin-top: 5rem;">
			<div class="col-sm-4 mb-4 align-self-stretch ">
				<div class="card shadow-lg  bg-white">
					<div class="card-body border border-dark carta-sorteos">
						<h3 class="card-title text-light" style="color: #797D7F; text-align: center;">${sorteo.nombre}</h3>
						<p class="card-text text-light" style="color: #424949">ID: ${sorteo.id}</p>
						<p class="card-text text-light" style="color: #797D7F">Descripcion: ${sorteo.descripcion}</p>
						<p class="card-text text-light" style="color: #797D7F">Precio: $${sorteo.precioRifa}</p>
						<div class="d-flex justify-content-end">
							<a class="btn btn-outline-info" href="comprar" role="button" type="submit">Comprar</a>
						</div>
					</div>
				</div>
			</div>
		</div>
<%--		<div class="cho-container"></div>--%>

	</body>
</html>