<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>lista</title>
</head>
<body>
	<h1>Modificar producto</h1>
	<div class="border border-warning">
			${requestScope.mensaje}
	</div>
	<form action="modificar" method="get">
			<input type="hidden" name="id" id="id" value="${requestScope.producto.idProducto}"/>
			Descripción: <input type="text" name="descripcion" id="descripcion" value="${requestScope.producto.descripcion}"/>
			Precio: <input type="text" name="precio" id="precio" value="${requestScope.producto.precio}"/>
			Cantidad: <input type="number" name="cantidad" id="cantidad" value="${requestScope.producto.stock}"/>
			<button type="submit" class="btn btn-primary">Modificar</button>
	</form>
</body>
</html>