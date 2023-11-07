<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Crea Viaggio</title>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<style>
.lista_vagoni{
	display: flex;
    align-items: center;
    flex-direction: column;
}

.vagone{
	background-color: "lightgray";
	display: flex;
    justify-content: space-around;
    width: 100%;
    border: 1px solid gray;
}

</style>

<body>
	<div class="container mt-3">

		<h1>Inserisci viaggio</h1>
		<form id="insertForm" action="AddViaggio" method="post">
			<div class="row">
				<div class="col">
					<div class="form-group">
					<span class="spanIdTreno">${treno}</span>
						<label for="dataPartenza">Data di Partenza:</label>
        					<input type="datetime-local" id="dataPartenza" name="dataPartenza" required><br>

        					<label for="dataArrivo">Data di Arrivo:</label>
					        <input type="datetime-local" id="dataArrivo" name="dataArrivo" required><br>
					
					        <label for="stazionePartenza">Stazione di Partenza:</label>
					        <input type="text" id="stazionePartenza" name="stazionePartenza" required><br>
					
					        <label for="stazioneDestinazione">Stazione di Destinazione:</label>
					        <input type="text" id="stazioneDestinazione" name="stazioneDestinazione" required><br>
					
							
							<input type="hidden" name="idTreno" id="idTreno">
					        
					     
					     
					</div>
					</div>
				</div>
			</div>
			<a href="${pageContext.request.contextPath }/"
				class="btn btn-warning"> Indietro </a>
			<button type="submit" id="ins" class="btn btn-primary">Inserisci</button>
		</form>
	</div>
	<script>
	
	
	document.addEventListener("DOMContentLoaded", function() {
        var vagoniInput = document.getElementById("idTreno");
        var span = document.querySelector(".spanIdTreno")

        var insButton = document.getElementById("ins");

        insButton.addEventListener("click", function() {
            vagoniInput.value = span.innerText;
        });
    });
	
	function leggiValoreMarca() {
        // Ottieni l'elemento radio selezionato
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
	         // Impedisce l'invio del modulo
	       
	    }
	    leggiValoreMarca()
	    
	    //return true; // Consente l'invio del modulo
	}
	
	</script>
</body>
</html>