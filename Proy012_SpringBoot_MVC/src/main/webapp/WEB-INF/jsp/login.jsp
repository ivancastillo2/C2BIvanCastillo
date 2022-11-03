<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<h2>Login</h2>

<form:form action="login" method="post" modelAttribute="usuarioForm">
	<form:label path="nombre">Nombre usuario:</form:label>
	<form:input path="nombre" /> <br/>
	<form:errors path="nombre"/> <br/>
	<form:label path="clave">Clave:</form:label>
	<form:password path="clave" /> <br/>
	<form:errors path="clave"/>
	<form:button>Login</form:button>
</form:form>

</body>
</html>