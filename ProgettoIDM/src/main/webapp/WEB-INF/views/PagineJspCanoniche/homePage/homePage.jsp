<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">

<head>
<title>Train Manager</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
	font-family: Arial, sans-serif;
}

.mySlides {
	display: none
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

.w3-row {
	display: flex;
	justify-content: center;
}

.w3-col {
	text-align: center;
}
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>

<body>

	<!-- Navbar -->
	<div class="w3-top fixed-top">
		<div class="w3-bar w3-black w3-card">
			<a
				class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right"
				title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a> <a
				href="#" class="w3-bar-item w3-button w3-padding-large">HOME</a> <a
				href="#contact"
				class="w3-bar-item w3-button w3-padding-large w3-hide-small">CONTATTI</a>

			<c:if test="${not empty utenteLoggato }">
				<div class="w3-dropdown-hover w3-hide-small">
					<button class="w3-padding-large w3-button" title="More">
						MENU</button>
					<div class="w3-dropdown-content w3-bar-block w3-card-4">
						<a href="viaggi" class="w3-bar-item w3-button">Prenota un
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


	<!-- Page content -->
	<div class="w3-content" style="max-width: 2000px; margin-top: 46px">

		<div class="w3-container w3-content w3-center w3-padding-64"
			style="max-width: 800px" id="band">
			<h2 class="w3-wide">THE BEAST TRAINS</h2>
			<p class="w3-opacity">
				<i>Noi amiamo i treni</i>
			</p>
			<p class="w3-justify">Nel trasporto ferroviario, un treno è una
				serie di carrozze ferroviarie collegate che corrono lungo un binario
				ferroviario e trasportano persone o merci, tipicamente trainate o
				spinte da una o più locomotive. Il treno è adatto alla circolazione
				sulle ferrovie composto da un insieme di elementi identificabili,
				uniti permanentemente o temporaneamente a formare un unico
				convoglio. Ha rappresentato un punto di svolta per l'evoluzione
				industriale delle nazioni ottocentesche, arrivando a rivestire per
				molti anni un ruolo centrale nella struttura politica, economica e
				sociale delle nazioni, nonché conquistando un posto di primo piano
				nell'immaginario collettivo.</p>
			<br>
			<p class="w3-opacity">
				<i>I nostri vagoni</i>
			</p>
			<div class="w3-row w3-padding-32">
				<div class="w3-third">
					<p>Passeggeri</p>
					<img src="resources\img\p.jpg" class="w3-round w3-margin-bottom"
						alt="Vagone Passeggeri" style="width: 70%">
				</div>
				<div class="w3-third">
					<p>Ristornate</p>
					<img src="resources\img\r.jpg" class="w3-round w3-margin-bottom"
						alt="Vagone Ristorante" style="width: 70%">
				</div>
				<div class="w3-third">
					<p>Cargo</p>
					<img src="resources\img\c.jpg" class="w3-round" alt="Vagone Cargo"
						style="width: 70%">
				</div>
			</div>
		</div>

		<!-- The Tour Section -->
		<div class="w3-black" id="tour">
			<div class="w3-container w3-content w3-padding-64"
				style="max-width: 800px">
				<h2 class="w3-wide w3-center">LE NOSTRE POTENTI LOCOMOTIVE</h2>
				<p class="w3-opacity w3-center">
					<i>Ricordati di amare i treni</i>
				</p>
				<br>

				<div class="w3-row-padding w3-padding-32" style="margin: 0 -16px">
					<div class="w3-third w3-margin-bottom">
						<img src="resources\img\1.jpg" alt="New York" style="width: 100%"
							class="w3-hover-opacity">
						<div class="w3-container w3-white">
							<p>
								<b>Freccia Rossa</b>
							</p>
							<p class="w3-opacity">27600 cv</p>
							<p>Una potente ed aerodinamica locomotiva per le alte
								velocità.</p>

						</div>
					</div>

					<div class="w3-third w3-margin-bottom">
						<img src="resources\img\2.jpg" alt="San Francisco"
							style="width: 100%" class="w3-hover-opacity">
						<div class="w3-container w3-white">
							<p>
								<b>Trenord</b>
							</p>
							<p class="w3-opacity">16000 cv</p>
							<p>Confortevole locomotiva per il più classico dei regionali.</p>

						</div>
					</div>

					<div class="w3-third w3-margin-bottom">
						<img src="resources\img\3.jpg" alt="New York" style="width: 100%"
							class="w3-hover-opacity">
						<div class="w3-container w3-white">
							<p>
								<b>CarGo</b>
							</p>
							<p class="w3-opacity">35000 cv</p>
							<p>Questo bestione da 35000 cavalli è il più potente della
								categoria, per i carichi più pesanti.</p>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<!-- The Contact Section -->
	<div class="w3-container w3-content w3-padding-64"
		style="max-width: 800px" id="contact">
		<h2 class="w3-wide w3-center">Contatti</h2>
		<p class="w3-opacity w3-center">
			<i>Profili LinkedIn degli Sviluppatori</i>
		</p>
		<div class="w3-row w3-padding-32 w3-center">
			<div class="w3-col m4 w3-large w3-margin-bottom">
				<a href="https://www.linkedin.com/in/roberto-tursi/" target="_blank"><i
					class="fa fa-linkedin w3-hover-opacity"> </i> Roberto Tursi</a>
			</div>
			<div class="w3-col m4 w3-large w3-margin-bottom">
				<a
					href="https://www.linkedin.com/in/francesco-tornamb%C3%A8-8a5055278/"
					target="_blank"><i class="fa fa-linkedin w3-hover-opacity">
				</i> Francesco Tornambè</a>
			</div>
			<div class="w3-col m4 w3-large w3-margin-bottom">
				<a
					href="https://www.linkedin.com/in/alfonso-d-angiolella-270a8a235/"
					target="_blank"><i class="fa fa-linkedin w3-hover-opacity">
				</i> Alfonso D'Angiolella</a>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<footer
		class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge">
		<p>Questo progetto è stato realizzato a scopo didattico</p>
		<a href="https://github.com/NI8IRU/TrenoManager" target="_blank">
			<p class="w3-medium">GitHub Repository</p>
		</a>
</body>

</html>