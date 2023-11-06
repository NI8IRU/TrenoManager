<!DOCTYPE html>
<html lang="en">
<head>
<title>The Beast Trains</title>
<meta charset="UTF-8">
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
				href="#" class="w3-bar-item w3-button w3-padding-large">HOME</a> <a
				href="#contact"
				class="w3-bar-item w3-button w3-padding-large w3-hide-small">CONTATTI</a>

			<a class="w3-bar-item w3-button w3-padding-large w3-hide-small">Benvenut*
				${utenteLoggato.username}</a>

			<div class="w3-dropdown-hover w3-hide-small">
				<button class="w3-padding-large w3-button" title="More">
					MENU <i class="fa fa-caret-down"></i>
				</button>
				<div class="w3-dropdown-content w3-bar-block w3-card-4">
					<a href="addTreno" class="w3-bar-item w3-button">Nuovo Treno</a> <a
						href="addTreni" class="w3-bar-item w3-button">Nuovo Treno 2</a> <a
						href="myTrain" class="w3-bar-item w3-button">I miei treni</a> <a
						href="profilo" class="w3-bar-item w3-button">Profilo</a>
				</div>
			</div>
			<a
				href="HomePage"
				class="w3-bar-item w3-button w3-padding-large w3-hide-small">LOGOUT</a>
		</div>
		<!-- 
		<a href="javascript:void(0)"
			class="w3-padding-large w3-hover-red w3-hide-small w3-right"><i
			class="fa fa-search"></i></a>
			 -->
	</div>

	<!-- Navbar on small screens (remove the onclick attribute if you want the navbar to always show on top of the content when clicking on the links) -->
	<!--
	<div id="navDemo"
		class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top"
		style="margin-top: 46px">
		<a href="#band" class="w3-bar-item w3-button w3-padding-large"
			onclick="myFunction()">BAND</a> <a href="#tour"
			class="w3-bar-item w3-button w3-padding-large" onclick="myFunction()">TOUR</a>
		<a href="#contact" class="w3-bar-item w3-button w3-padding-large"
			onclick="myFunction()">CONTATTI</a> <a href="#"
			class="w3-bar-item w3-button w3-padding-large" onclick="myFunction()">MERCH</a>
	</div>
	-->
	<!-- Page content -->
	<div class="w3-content" style="max-width: 2000px; margin-top: 46px">

		<!-- Automatic Slideshow Images -->
		<!--
		<div class="mySlides w3-display-container w3-center">
			<img src="/w3images/la.jpg" style="width: 100%">
			<div
				class="w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small">
				<h3>Los Angeles</h3>
				<p>
					<b>We had the best time playing at Venice Beach!</b>
				</p>
			</div>
		</div>
		<div class="mySlides w3-display-container w3-center">
			<img src="/w3images/ny.jpg" style="width: 100%">
			<div
				class="w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small">
				<h3>New York</h3>
				<p>
					<b>The atmosphere in New York is lorem ipsum.</b>
				</p>
			</div>
		</div>
		<div class="mySlides w3-display-container w3-center">
			<img src="/w3images/chicago.jpg" style="width: 100%">
			<div
				class="w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small">
				<h3>Chicago</h3>
				<p>
					<b>Thank you, Chicago - A night we won't forget.</b>
				</p>
			</div>
		</div>
				-->
		<!-- The Band Section -->
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
						alt="Random Name" style="width: 70%">
				</div>
				<div class="w3-third">
					<p>Ristornate</p>
					<img src="resources\img\r.jpg" class="w3-round w3-margin-bottom"
						alt="Random Name" style="width: 70%">
				</div>
				<div class="w3-third">
					<p>Cargo</p>
					<img src="resources\img\c.jpg" class="w3-round" alt="Random Name"
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
							<!--  
							<button class="w3-button w3-black w3-margin-bottom"
								onclick="document.getElementById('ticketModal').style.display='block'">Buy
								Tickets</button>
								-->
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
							<!--  
							<button class="w3-button w3-black w3-margin-bottom"
								onclick="document.getElementById('ticketModal').style.display='block'">Buy
								Tickets</button>
								-->
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
							<!--  
							<button class="w3-button w3-black w3-margin-bottom"
								onclick="document.getElementById('ticketModal').style.display='block'">Buy
								Tickets</button>
								-->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Ticket Modal -->
	<div id="ticketModal" class="w3-modal">
		<div class="w3-modal-content w3-animate-top w3-card-4">
			<header class="w3-container w3-teal w3-center w3-padding-32">
				<span
					onclick="document.getElementById('ticketModal').style.display='none'"
					class="w3-button w3-teal w3-xlarge w3-display-topright">×</span>
				<h2 class="w3-wide">
					<i class="fa fa-suitcase w3-margin-right"></i>Tickets
				</h2>
			</header>
			<div class="w3-container">
				<p>
					<label><i class="fa fa-shopping-cart"></i> Tickets, $15 per
						person</label>
				</p>
				<input class="w3-input w3-border" type="text"
					placeholder="How many?">
				<p>
					<label><i class="fa fa-user"></i> Send To</label>
				</p>
				<input class="w3-input w3-border" type="text"
					placeholder="Enter email">
				<button
					class="w3-button w3-block w3-teal w3-padding-16 w3-section w3-right">
					PAY <i class="fa fa-check"></i>
				</button>
				<button class="w3-button w3-red w3-section"
					onclick="document.getElementById('ticketModal').style.display='none'">
					Close <i class="fa fa-remove"></i>
				</button>
				<p class="w3-right">
					Need <a href="#" class="w3-text-blue">help?</a>
				</p>
			</div>
		</div>
	</div>

	<!-- The Contact Section -->
	<div class="w3-container w3-content w3-padding-64"
		style="max-width: 800px" id="contact">
		<h2 class="w3-wide w3-center">Contatti</h2>
		<p class="w3-opacity w3-center">
			<i>Ti piacciono i treni? Droppaci una nota!</i>
		</p>
		<div class="w3-row w3-padding-32">
			<div class="w3-col m6 w3-large w3-margin-bottom">
				<i class="fa fa-map-marker" style="width: 30px"></i> Predappio, FC<br>
				<i class="fa fa-phone" style="width: 30px"></i> Phone: +39 333 333
				3333<br> <i class="fa fa-envelope" style="width: 30px"> </i>
				Email: ole@mail.com<br>
			</div>
			<div class="w3-col m6">
				<form action="/action_page.php" target="_blank">
					<div class="w3-row-padding" style="margin: 0 -16px 8px -16px">
						<div class="w3-half">
							<input class="w3-input w3-border" type="text" placeholder="Nome"
								required name="Name">
						</div>
						<div class="w3-half">
							<input class="w3-input w3-border" type="text" placeholder="Email"
								required name="Email">
						</div>
					</div>
					<input class="w3-input w3-border" type="text"
						placeholder="Messaggio" required name="Message">
					<button class="w3-button w3-black w3-section w3-right"
						type="submit">INVIA</button>
				</form>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<footer
		class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge">
		<a href="https://www.youtube.com/watch?v=mc6uB_RlTFI" target="_blank">
			<i class="fa fa-youtube w3-hover-opacity"></i>
		</a> <a href="https://www.linkedin.com/in/alfonso-d-angiolella-270a8a235/"
			target="_blank"><i class="fa fa-linkedin w3-hover-opacity"> </i></a>
		<a href="https://www.linkedin.com/in/roberto-tursi/" target="_blank"><i
			class="fa fa-linkedin w3-hover-opacity"> </i></a> <a
			href="https://www.linkedin.com/in/francesco-tornamb%C3%A8-8a5055278/"
			target="_blank"><i class="fa fa-linkedin w3-hover-opacity"> </i></a>
		<a href="https://www.cicciottocartofer.it/" target="_blank">
			<p class="w3-medium">Powered by Cicciotto Cartofer</p>
		</a> <a href="https://www.youtube.com/@CodeWithNaval" target="_blank">
			<p class="w3-medium">Ringrazio colui senza il quale non avremmo
				potuto fare nulla</p>
		</a>
	</footer>

	<script>
		// Automatic Slideshow - change image every 4 seconds
		var myIndex = 0;
		carousel();

		function carousel() {
			var i;
			var x = document.getElementsByClassName("mySlides");
			for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";
			}
			myIndex++;
			if (myIndex > x.length) {
				myIndex = 1
			}
			x[myIndex - 1].style.display = "block";
			setTimeout(carousel, 4000);
		}

		// Used to toggle the menu on small screens when clicking on the menu button
		function myFunction() {
			var x = document.getElementById("navDemo");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}

		// When the user clicks anywhere outside of the modal, close it
		var modal = document.getElementById('ticketModal');
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>

</body>
</html>
