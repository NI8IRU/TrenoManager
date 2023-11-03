<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<style>

.container {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
}

.vagone {
 display: grid;
  grid-template-columns: 10% 48% 10% 10%;
  grid-gap: 10px;
  background-color: #2196F3;
  padding: 10px;
  width: 40%;
  border-radius:10px 10px 0 0
}

.posto {
  width: 55px;
  height: 55px;
  border: 1px solid #999;
  margin: 15px 5px;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 5px
}

.posto:hover{
	cursor:pointer;
}

.libero{
	background-color: lightgreen;
	transition: all 0.3s ease; /* Effetto di transizione per una transizione fluida */

    /* Stile dell'ombra del div */
    box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3); /* Ombra leggermente colorata */
}

.libero:hover{
	 width: 60px; /* Larghezza aumentata al passaggio del mouse sopra */
    height: 60px; /* Altezza aumentata al passaggio del mouse sopra */
    box-shadow: 4px 4px 10px rgba(0, 0, 0, 0.5); /* Ombra più pronunciata e colorata */
}

.occupato{
	background-color: gray;
}

.contenitore-posto{
	width:60px;
	height:60px;
	disply:flex;
	justify-content:center;
	align-items: center;
}



</style>
<body>

	<h1>Prenota qui il tuo posto</h1>
	<div class="container mt-3">
				<div class="vagone">
					<c:forEach var="posto" items="${posti}">
						<div class="contenitore-posto">
						<!-- c:choose con all'interno c:when e c:otherwise sarebbe il 
						corrispettivo dell'if else -->
						<c:choose>
    						<c:when test="${!posto.occupato}">
        						<div class="posto libero" onclick="selectSeat(this, '${posto.id}')" onmouseover="changeColor(this)" onmouseout="resetColor(this)">
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
				
			<form id="postiForm" method="post" action="ConfermaPrenotazione">
      			<!-- Campo nascosto per contenere l'elenco dei posti selezionati -->
      			<input type="hidden" name="postiSelezionati" id="postiSelezionati">
     			 <!-- Pulsante di invio per inviare la richiesta POST -->
      			<button type="submit" class="btn btn-warning">Conferma Posti</button>
    		</form>

	</div>
	
	
	<script>
	var postiSelezionati = []; // Array per tenere traccia dei posti selezionati

    //function changeColor(element) {
      //element.style.backgroundColor = "#00FF00"; // Cambia il colore quando il mouse è sopra il posto
    //}

    //function resetColor(element) {
      //element.style.backgroundColor = "#ccc"; // Ripristina il colore originale quando il mouse si sposta via
    //}

    function selectSeat(element, postoId) {
      // Cambia il colore quando un posto viene selezionato
      element.style.backgroundColor = "#0000FF"; // Colore blu per i posti selezionati
      postiSelezionati.push(postoId); // Aggiunge il posto selezionato all'array
      // Aggiorna il campo nascosto con l'elenco dei posti selezionati
      let input = document.getElementById("postiSelezionati")
      input.value = postiSelezionati.join(",");
      console.log(input)
    }
</script>
	
</body>
</html>