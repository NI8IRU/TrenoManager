<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Travel Search</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
body {
	background-color: #f8f9fa;
	font-family: Arial, sans-serif;
}

.container {
	background-color: #fff;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
	text-align: center;
	color: #030f1b;
	padding-bottom: 10px;
}

.table-plus {
	font-weight: bold;
}

.table th {
	background-color: #030f1b;
	color: #fff;
}

.content-center {
	display: flex;
	justify-content: center;
	align-items: center;
	text-align: center;
}
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>

<body>
	<div class="w3-top fixed-top">
		<div class="w3-bar w3-black w3-card">
			<a
				class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right"
				title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a> <a
				href="home" class="w3-bar-item w3-button w3-padding-large">HOME</a> <a
				href="#contact"
				class="w3-bar-item w3-button w3-padding-large w3-hide-small">CONTATTI</a>

			<c:if test="${not empty utenteLoggato }">
				<div class="w3-dropdown-hover w3-hide-small">
					<button class="w3-padding-large w3-button" title="More">
						MENU</button>
					<div class="w3-dropdown-content w3-bar-block w3-card-4">
						<a href="myTrain" class="w3-bar-item w3-button">Prenota un
							Viaggio</a> <a href="profilo" class="w3-bar-item w3-button">Profilo</a>
						<a href="addTreni" class="w3-bar-item w3-button">Crea un Treno</a>
					</div>

				</div>
				<a href="logout"
					class="w3-bar-item w3-button w3-padding-large w3-hide-small">LOGOUT</a>
			</c:if>

			<c:if test="${!not empty utenteLoggato }">
				<a href="addUtente"
					class="w3-bar-item w3-button w3-padding-large w3-hide-small">REGISTRATI</a>
				<a href="loginUtente"
					class="w3-bar-item w3-button w3-padding-large w3-hide-small">ACCEDI</a>
			</c:if>
		</div>

	</div>

	<div class="container mt-3">
		<h1>Lista Treni</h1>
		
		<div class="row mt-3">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Marca</th>
						<th>Tipo Treno</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="treno" items="${treni}">
						<tr>
							<td class="table-plus">${treno.id}</td>
							<td>${treno.marca}</td>
							<td>${treno.tipoTreno}</td>
							
							<td><a href="createViaggio/${treno.id}" class="btn btn-warning">
									Crea Viaggio </a></td>
							
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script src="scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>

</html>