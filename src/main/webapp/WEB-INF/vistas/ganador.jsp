<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Inicio</title>
  <!-- Bootstrap core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- Bootstrap theme -->
  <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="background.jsp"/>
<div class="container">
  <h1>GANADOR</h1>
  <h2>${ganador.nombre}</h2>
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