<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	<link rel="stylesheet"
		  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		  integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
		  crossorigin="anonymous">
	<link href="css/styles.css" rel="stylesheet">
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
	<div>
		<a class="btn btn-danger ml-2" href="login-index" role="button">Volver</a>
	</div>

	<jsp:include page="background.jsp"/>
	<div class="container">
		<h1>Compra Exitosa</h1>
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