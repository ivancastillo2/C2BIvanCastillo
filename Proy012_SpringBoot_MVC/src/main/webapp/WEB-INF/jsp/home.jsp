<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>
</head>
<body>

<h2>Bienvenido ${usuario.nombre }</h2>
rol: ${usuario.rol }

<c:if test="${usuario.rol eq 'cliente'}">
	<a href="pedidos">Listar mis pedidos</a>
</c:if>
<c:if test="${usuario.rol eq 'admin'}">
	<a href="pedidos">Listar todos los pedidos</a>
</c:if>
</body>
</html>