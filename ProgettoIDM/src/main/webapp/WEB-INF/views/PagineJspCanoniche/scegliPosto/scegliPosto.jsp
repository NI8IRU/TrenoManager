<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.container {
	display: flex;
	flex-direction: row;
	flex-wrap: wrap;
	justify-content: center;
}

.vagone {
	display: grid;
	grid-template-columns: 10% 60% 10% 10%;
	grid-gap: 10px;
	background-color: #ccc;
	padding: 10px;
	width: 50%;
	border-radius: 8px
}

.posto {
	width: 50px;
	height: 50px;
	margin: 5px;
	display: flex;
	justify-content: center;
	align-items: center;
	border: 2px;
	border-radius: 5px
}

.posto:hover {
	cursor: pointer;
}

.libero {
	background-color: rgb(245, 250, 245);
	border-style: solid;
	border-color: black;
	transition: all 0.3s ease;
	/* Effetto di transizione per una transizione fluida */
	/* Stile dell'ombra del div */
	box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
	/* Ombra leggermente colorata */
}

.libero:hover {
	width: 50px;
	/* Larghezza aumentata al passaggio del mouse sopra */
	height: 50px;
	/* Altezza aumentata al passaggio del mouse sopra */
	box-shadow: 4px 4px 10px rgba(0, 0, 0, 0.5);
	/* Ombra più pronunciata e colorata */
}

.occupato {
	background-color: #030f1b;
	color: #ffff;
	border-style: solid;
	border-color: #ffff;
}

.contenitore-posto {
	width: 60px;
	height: 60px;
}

.glow {
	-webkit-box-shadow: 0px 0px 105px 24px rgba(7, 31, 24, 0.9);
	-moz-box-shadow: 0px 0px 105px 24px rgba(7, 31, 24, 0.9);
	box-shadow: 0px 0px 105px 24px rgba(7, 31, 24, 0.9);
}

.btn {
	display: block;
	width: 100%;
	padding: 12px;
	margin-top: 20px;
	text-align: center;
	color: #fff;
	border-radius: 4px;
	border: 2px;
	cursor: pointer;
	background-color: #030f1b;
	border-style: solid;
	border-color: #e6ebf0;
}

.btn:hover {
	opacity: 0.9;
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

	<div class="container text-center m-3 w3-padding-top-32">
		<h2>Prenota qui il tuo posto</h2>
		<div class="container mt-3">
			<div class="vagone glow">
				<c:forEach var="posto" items="${posti}">
					<div class="contenitore-posto">
						<!-- c:choose con all'interno c:when e c:otherwise sarebbe il 
						corrispettivo dell'if else -->
						<c:choose>
							<c:when test="${!postiOccupati.contains(posto.id)}">
								<div class="posto libero"
									onclick="selectSeat(this, '${posto.id}')">
									<div>${posto.id}</div>

								</div>
							</c:when>
							<c:otherwise>
								<!-- Blocco da visualizzare quando la condizione è falsa -->
								<div class="posto occupato">
									<div>${posto.id}</div>

								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</c:forEach>
			</div>
		</div>
		<form id="postiForm" method="post" action="ConfermaPrenotazione">
			<!-- Campo nascosto per contenere l'elenco dei posti selezionati -->
			<input type="hidden" name="postiSelezionati" id="postiSelezionati">
			<!-- Pulsante di invio per inviare la richiesta POST -->
			<button id="confermaPosti" type="submit" class="btn" disabled>Conferma
				Posti</button>
		</form>
	</div>
	<script>
	var postiSelezionati = []; // Array per tenere traccia dei posti selezionati

	const liberoStyles =
	    `background-color: rgb(245, 250, 245);
	    border-style: solid;
	    border-color: black;
	    transition: all 0.3s ease;
	    box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);`
	const occupatoStyles =
	    `background-color: #030f1b;
	    color: #ffff;
	    border-style: solid;
	    border-color: #ffff;`

	let buttonConfermaPosti = document.getElementById("confermaPosti");

	let input = document.getElementById("postiSelezionati")

	function selectSeat(element, postoId) {
	    if (postiSelezionati.includes(postoId)) {
	        let index = postiSelezionati.indexOf(postoId)
	        postiSelezionati.splice(index, 1)
	        element.style.cssText = liberoStyles;

	    } else {
	        // Cambia il colore quando un posto viene selezionato
	        element.style.cssText = occupatoStyles;
	        postiSelezionati.push(postoId); // Aggiunge il posto selezionato all'array	
	    }
	    //Aggiorna il campo nascosto con l'elenco dei posti selezionati
	    input.value = postiSelezionati.join(",");
	    console.log(input)

	    if (input.value.trim() !== "") {
	        buttonConfermaPosti.removeAttribute("disabled");
	    } else {
	        buttonConfermaPosti.setAttribute("disabled", true);
	    }



	}</script>
</body>

</html>