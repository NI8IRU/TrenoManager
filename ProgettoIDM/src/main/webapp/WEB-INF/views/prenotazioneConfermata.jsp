<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>


	<div class="container mt-3">

		<h1 class="text-success">Prenotazione Effettuata</h1>
		<h3>Riepilogo Prenotazione:</h3>
		
		

			<div class="row">
				<div class="col">
					<div class="form-group">
						<h5>Dati prenotazione</h5>
						<span>Id prenotazione: ${prenotazione.id }</span><br />
						<span>Prezzo: ${prenotazione.prezzo }</span><br />
						
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<h5>Dati utente</h5>
						<span>Username: ${utenteLoggato.username}</span><br />
						
					</div>
				</div>
			</div>
			
			<h5>Dati viaggio</h5>
			<p>Ha effettuato l'aquisto di ??? per il vagone ??? nel treno con id ${t }</p>
			

			

			<a href="${pageContext.request.contextPath }/"
				class="btn btn-warning"> Back </a>



	</div>

</body>
</html>