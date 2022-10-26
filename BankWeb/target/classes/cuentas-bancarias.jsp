<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Tienda Online</title>
  </head>
  <body>
	<h1>Banco</h1>
	<h3>Cuentas de ${requestScope.nombre} ${requestScope.apellido}: </h3>
	<table>
	<c:forEach var="cuenta" items="${requestScope.lista}">
		<c:if test="${not empty cuenta}">
			<tr>
				<td>${cuenta.id}. </td>
				<td>Saldo: ${cuenta.balance}.</td>
			</tr>
		</c:if>
	</c:forEach>
	</table>
	<h2>Añadir cuentas: </h2>
	<form action="crear" method="get">
		<br/>
		<input type="hidden" name="id" value="${requestScope.id}"/>
		Saldo cuenta:<input type="number" name="saldo" value="" />
		
		<button type="submit" class="btn btn-primary">Crear Cuenta</button>
	</form>
	<div class="border border-warning">
			${requestScope.mensaje}
	</div>
	<a class="btn btn-primary" href="banco" role="button">Volver</a>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  </body>
</html>