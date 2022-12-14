<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedidos</title>
</head>
<body>

	<h1>Lista pedidos</h1>
	<hr/>
	<ul>
		<c:forEach items="${listaPedidos}" var="pedido">
			<li>${pedido.id} - ${pedido.desc}
			
				<a href="pedido?idPedido=${pedido.id}">Ver detalles</a>
				<c:if test="${usuario.rol eq 'admin'}">
					<a href="borrar?idPedido=${pedido.id}">Borrar</a>
				</c:if>
			
			</li>
		</c:forEach>
	</ul>
	<hr/>
	<h3>Alta Producto</h3>
	<hr/>
	<form:form action="altaProducto" method="post" modelAttribute="pedidoForm">
		<form:label path="desc">Descripción:</form:label>
		<form:input path="desc"/>
		<form:errors path="desc"/> <br/>
		<form:label path="entregado">Entregado:</form:label>
		<form:checkbox path="entregado" />
		<form:button>Crear pedido</form:button>
	</form:form>
</body>
</html>