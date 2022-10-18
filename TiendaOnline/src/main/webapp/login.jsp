<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<title>login</title>
</head>
<body>
	<h1>Login</h1>
	<form action="login" method="post">
		Nombre usuario: <input type="text" name="nombre" value="" /> 
		<br />
		Roll: 
		<select name="select-1" id="select-1">
			<option value="admin">Admin</option>
			<option value="cliente">Cliente</option>
		</select>
		<button type="submit" class="btn btn-primary">Grabar</button>
	</form>
</body>
</html>