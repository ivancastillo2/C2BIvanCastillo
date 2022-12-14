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
	<h3>Lista de Clientes: </h3>
	<table>
	<c:forEach var="cliente" items="${requestScope.lista}">
		<c:if test="${not empty cliente}">
			<tr>
				<td>${cliente.id}. </td>
				<td>${cliente.firstName}.</td>
				<td>${cliente.lastName}</td>
				<td><a class="btn btn-primary" href="cuentas?id=${cliente.id}" role="button">Ver cuentas</a></td>
			</tr>
		</c:if>
	</c:forEach>
	</table>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  </body>
</html>