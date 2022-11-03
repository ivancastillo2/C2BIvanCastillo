<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalles</title>
</head>
<body>

<h2>Detalle Pedido</h2>

User: ${pedido.user }
<br/>
Descripcion: ${pedido.desc }
<br/>
Fecha pedido: <fmt:formatDate value="${pedido.fechaPedido }" pattern="dd-MM-yyy"/>
<br/>
<c:if test="${pedido.entregado}">
	Entregado
</c:if>
<c:if test="${pedido.entregado == false}">
	No enregado
</c:if>

</body>
</html>