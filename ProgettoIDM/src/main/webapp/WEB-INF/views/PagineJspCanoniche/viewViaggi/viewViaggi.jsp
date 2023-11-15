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
		<h1>Prenota un Viaggio</h1>
		<form action="searchViaggi" method="post">
			<div class="row content-center">

				<div class="col">
					<div class="search-container">
						<input type="text" placeholder="Partenza...">
					</div>
				</div>
				<div class="col">
					<input type="text" placeholder="Destinazione...">
				</div>
				<div class="col">
					<input type="datetime-local" id="dataPartenza" name="dataPartenza"
						required>
				</div>
				<div class="col">
					<select id="compagnia" class="form-control-sm"></select>
				</div>
				<div class="col content-center">
					<button type="submit" class="btn btn-dark content-center">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                        <path
								d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
                    </svg>
					</button>
				</div>
			</div>
		</form>
		<div class="row mt-3">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Data Partenza</th>
						<th>Data Arrivo</th>
						<th>Stazione di Partenza</th>
						<th>Stazione Destinazione</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${viaggiSearch.size() > 0}">
							<c:forEach var="viaggio" items="${viaggiSearch}">
								<tr>
									<td>${viaggio.dataPartenza}</td>
									<td>${viaggio.dataArrivo}</td>
									<td>${viaggio.stazionePartenza}</td>
									<td>${viaggio.stazioneDestinazione}</td>
									<td><a href="prenotaPosto/${viaggio.id}"
										class="btn btn-warning"> Prenota </a></td>


								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:forEach var="viaggio" items="${viaggi}">
								<tr>
									<td>${viaggio.dataPartenza}</td>
									<td>${viaggio.dataArrivo}</td>
									<td>${viaggio.stazionePartenza}</td>
									<td>${viaggio.stazioneDestinazione}</td>
									<td><a href="prenotaPosto/${viaggio.id}"
										class="btn btn-warning"> Prenota </a></td>


								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
	<script>
		const compagnia = document.getElementById('compagnia');

		const defaultOption3 = document.createElement('option');
		defaultOption3.text = 'Compagnia...';
		defaultOption3.disabled = true;
		defaultOption3.selected = true;
		compagnia.appendChild(defaultOption3);

		const compagnie = [ 'Freccia Rossa', 'Trenord' ]

		for (let i = 0; i < compagnie.length; i++) {
			const option = document.createElement('option');
			option.value = i;
			option.text = compagnie[i];
			compagnia.appendChild(option);
		}
	</script>
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