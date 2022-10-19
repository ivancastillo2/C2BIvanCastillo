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
	<p>Usuario: ${sessionScope.nombre}</p>
	<h1>Tienda Online</h1>
	<h4>Lista de productos</h4>
	<table>
		<div class="border border-warning">
			${requestScope.mensaje}
		</div>
		<c:forEach var="producto" items="${requestScope.lista}">
			<tr>
				<td>${producto.idProducto}.</td>
				<td>${producto.descripcion}</td>
				<td>${producto.precio}</td>
				<td>${producto.stock}</td>
				<td><a href="comprar?id=${producto.idProducto}">Comprar producto</a></td>
			</tr>
		</c:forEach>
	</table>
	<form action="comprar" method="get">
			<label for="select_producto">Producto:</label>
			<select name="id" id="id">
			<c:forEach var="producto" items="${requestScope.lista}">
				<option value="${producto.idProducto}">${producto.descripcion}</option>
			</c:forEach>
			</select>
			Cantidad: <input type="number" name="cantidad" id="cantidad" value="1"/>
			<button type="submit" class="btn btn-primary">Comprar</button>
	</form>
</body>
</html>