<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profilo di ${utenteLoggato.nome}</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
	font-family: "Lato", sans-serif
}

.mySlides {
	display: none
}
</style>
</head>
<body>
	<!-- Navbar -->
	<div class="w3-top">
		<div class="w3-bar w3-black w3-card">
			<a
				class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right"
				href="javascript:void(0)" onclick="myFunction()"
				title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a> <a
				href="homeProfilo" class="w3-bar-item w3-button w3-padding-large">HOME</a>
			<a class="w3-bar-item w3-button w3-padding-large w3-hide-small">Benvenut*
				${utenteLoggato.nome}</a>

			<div class="w3-dropdown-hover w3-hide-small">
				<button class="w3-padding-large w3-button" title="More">
					MENU <i class="fa fa-caret-down"></i>
				</button>
				<div class="w3-dropdown-content w3-bar-block w3-card-4">
					<a href="treni" class="w3-bar-item w3-button">Treni</a> <a
						href="myTrain" class="w3-bar-item w3-button">I miei treni</a> <a
						href="profilo" class="w3-bar-item w3-button">Profilo</a>
				</div>
			</div>
			<a
				href="logout"
				class="w3-bar-item w3-button w3-padding-large w3-hide-small">LOGOUT</a>
		</div>
		</div>
	<h3>Profilo</h3>
	<div class="container mt-3">
		<div class="row">
			<div class="col">
				<div class="form-group">
					<p>
						Identificativo: <b>${utenteLoggato.id}</b>
					</p>
					<p>
						Nome: <b>${utenteLoggato.nome}</b>
					</p>
					<p>
						Username: <b>${utenteLoggato.username}</b>
					</p>
					<p>
						Nazione: <b>${utenteLoggato.nazione}</b>
					</p>
					<p>
						Codice fiscale: <b>${utenteLoggato.codiceFiscale}</b>
					</p>
										<p>
						Saldo: <b>${utenteLoggato.saldo}</b>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>