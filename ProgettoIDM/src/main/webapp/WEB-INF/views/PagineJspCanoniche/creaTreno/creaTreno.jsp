<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">

<head>
<title>Crea treno</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
body {
	font-family: 'Arial', sans-serif;
	background-color: #f8f9fa;
}

.container {
	margin-top: 80px;
	background-color: #ffffff;
	border-radius: 10px;
	padding: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.head {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 1rem;
}

h1, h5 {
	margin: 0;
	color: #343a40;
}

.text-danger {
	color: red;
}

.messaggioSuccesso {
	color: green;
}

.bottoneTreni {
	display: flex;
	align-items: center;
	text-decoration: none;
	color: #fff;
}

.bottoneTreni:hover {
	color: #fff;
}

.form-group {
	margin-bottom: 1rem;
}

#ComposizioneTreno {
	width: 100%;
}

/* Style for radio buttons */
input[type="radio"] {
	margin-right: 0.3rem;
}

.btn {
	display: inline-block;
	padding: 12px;
	text-align: center;
	color: #fff;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.btn-primary {
	background-color: #030f1b;
	border-style: solid;
	border-color: #030f1b;
}

.btn:hover {
	opacity: 0.9;
	background-color: #fff;
	color: #030f1b;
	border-color: #030f1b;
}

.glow {
	-webkit-box-shadow: 0px 0px 150px 10px rgba(7, 31, 24, 0.9);
	-moz-box-shadow: 0px 0px 150px 10px rgba(7, 31, 24, 0.9);
	box-shadow: 0px 0px 150px 10px rgba(7, 31, 24, 0.9);
}
</style>
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
	<div class="container glow">
		<div class="head">
			<div class="col-6 text-right">
				<h1>Inserisci treni</h1>
				<c:if test="${not empty msg }">
					<h5 class="text-danger">${msg }</h5>
					<c:remove var="msg" />
				</c:if>
				<c:if test="${not empty successMsg }">
					<h5 class="messaggioSuccesso">${successMsg }</h5>
					<c:remove var="successMsg" />
				</c:if>
			</div>
			<div class="col-3 text-right">
				<a href="treni" class="btn btn-primary bottoneTreni"> Visualizza
					Treni </a>
			</div>
		</div>
		<form id="insertForm" action="AddTreni" method="post">
			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="ScegliMarca">Scegli marca</label> <br> <input
							type="radio" id="FR" name="marca" value="FR" checked="checked">
						<label onclick="leggiValoreMarca()" for="FR">Freccia Rossa</label>
						<input type="radio" id="TN" name="marca" value="TN"> <label
							for="TN">TreNord</label><br> <br> <label
							for="composizioneTreno">Composizione treno</label> <input
							type="text" class="form-control" id="ComposizioneTreno"
							name="ComposizioneTreno" placeholder="HPPP...">
					</div>
				</div>
			</div>
			<a href="${pageContext.request.contextPath }/"
				class="btn btn-primary"> Indietro </a>
			<button type="submit" class="btn btn-primary">Inserisci</button>
		</form>
	</div>
	<script>
	function leggiValoreMarca() {
	    var radioSelezionato = document.querySelector('input[name="marca"]:checked');
	    if (radioSelezionato) {
	        var valoreSelezionato = radioSelezionato.value;
	        console.log("Valore selezionato: " + valoreSelezionato);
	    } else {
	        console.log("Nessun valore selezionato");
	    }
	}

	function CheckForm() {
	    let StringaTreno = document.getElementById('ComposizioneTreno').value;
	    if (StringaTreno.length === 0) {
	        window.alert("Inserisci una stringa");
	    }
	    leggiValoreMarca()
	}</script>
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