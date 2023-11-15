<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<style>
.filterForm{
	display: flex;
	justify-content: space-between;
	flex-wrap = wrap;
	
}
.bloccoInput{
	position: relative;
}

.divSuggerimento{
	border-bottom: 1px solid gray; 
	cursor: pointer;
}
.divSuggerimento:hover{
	backgroundColor: yellow;
}
</style>
<body>


	<div class="container mt-3">
	<h1>Lista Viaggi</h1>
	
	<!-- FILTRI RICERCA -->
	<button onclick="mostraFormFiltri()">Filtri</button>

		<div id="sezioneFiltri" style="display: none;">
		    <form action="searchViaggi" method="post" class="filterForm">
		        
		        <label>Data Partenza:</label>
		        <input type="date" name="dataPartenza" ><br>
				
			    <label>Stazione Partenza:</label>
			    <div class="bloccoInput">
			        <input id="cercaPartenza" type="text" name="stazionePartenza" oninput="checkStringPartenza(this, 'suggerimentiPartenza')"><br>
			        <div id="suggerimentiPartenza"></div>
				</div>	
				
		        <label>Stazione Destinazione:</label>
		        <div class="bloccoInput">
		        	<input id="cercaArrivo" type="text" name="stazioneDestinazione" oninput="checkStringPartenza(this, 'suggerimentiDestinazione')"><br>
		        	<div id="suggerimentiDestinazione"></div>
		        </div>	
		        	
		        <label>Compagnia</label>
		        <select name="marca">
		        	<option value="">Seleziona Compagnia</option>
				    <option value="Frecciarossa">Frecciarossa</option>
				    <option value="Trenonord">Trenonord</option>
				</select>
				
				
		        <button type="submit">Invia</button>
		    </form>
		</div>
		
		<!-- FINE FILTRI RICERCA -->

	
		<div class="row">

			<table class="table table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Data Partenza</th>
						<th>Data Arrivo</th>
						<th>Stazione di Partenza</th>
						<th>Stazione Destinazione</th>
						<th>Marca Treno</th>
						
					</tr>
				</thead>
				<tbody>
				
				<c:choose>
    						<c:when test="${viaggiSearch.size() > 0}">
        						<c:forEach var="viaggio" items="${viaggiSearch}">
						<tr>
							<td class="table-plus">${viaggio.id}</td>
							<td>${viaggio.dataPartenza}</td>
							<td>${viaggio.dataArrivo}</td>
							<td>${viaggio.stazionePartenza}</td>
							<td>${viaggio.stazioneDestinazione}</td>
							<td>${viaggio.treno.marca}</td>
							<td><a href="prenotaPosto/${viaggio.id}" class="btn btn-warning">
									prenota </a></td>
							
							
						</tr>
						</c:forEach>
    						</c:when>
    						<c:otherwise>
        						<c:forEach var="viaggio" items="${viaggi}">
						<tr>
							<td class="table-plus">${viaggio.id}</td>
							<td>${viaggio.dataPartenza}</td>
							<td>${viaggio.dataArrivo}</td>
							<td>${viaggio.stazionePartenza}</td>
							<td>${viaggio.stazioneDestinazione}</td>
							<td>${viaggio.treno.marca}</td>
							<td><a href="prenotaPosto/${viaggio.id}" class="btn btn-warning">
									prenota </a></td>
							
							
						</tr>
						</c:forEach>
    						</c:otherwise>
						</c:choose>
				
						
					
				</tbody>
			</table>
		</div>
	</div>

<script>

function mostraFormFiltri() {
    var sezioneFiltri = document.getElementById('sezioneFiltri');
    sezioneFiltri.style.display = (sezioneFiltri.style.display === 'none') ? 'block' : 'none';
}

function checkStringPartenza(e, id){
	let contenitoreSuggerimenti = document.getElementById(id)
	contenitoreSuggerimenti.innerHTML = "";  
	let arraySuggerimenti = findProvinciaByInsertString(e.value)
	for(let i=0; i<arraySuggerimenti.length; i++){
		// Creazione di un nuovo elemento div
		var nuovoDiv = document.createElement("div")
		// Aggiunta di un contenuto (testo) all'interno del div
		nuovoDiv.textContent = arraySuggerimenti[i]
		//nuovoDiv.textContent = transformString(e.value, nomiProvince)
		// Aggiunta di una classe al div (opzionale)
		nuovoDiv.classList.add("divSuggerimento")
		// Aggiunta del div al contenitore di suggerimenti
		contenitoreSuggerimenti.appendChild(nuovoDiv)
		nuovoDiv.onclick = function () {
			let input = document.getElementById("cercaPartenza")
			input.value = arraySuggerimenti[i]
           
		}
	}
	
}

function findProvinciaByInsertString(string){
	let matchedProvince = []
	if(string !== ""){
		for(let i=0; i<nomiProvince.length; i++){
			if(nomiProvince[i].toUpperCase().startsWith(string.toUpperCase())){
				console.log("si")
				matchedProvince.push(nomiProvince[i])
				if (matchedProvince.length === 3) {
                    break;  // Esce dal loop se ha raggiunto 3 valori
                }
			}	
	}
	
	}
	return matchedProvince
}

//lista province
var nomiProvince = [
        'Agrigento','Alessandria','Ancona','Aosta','Aquila','Arezzo','Ascoli Piceno','Asti','Avellino',
        'Bari','Belluno','Benevento','Bergamo','Biella','Bologna','Bolzano','Brescia','Brindisi',
        'Cagliari','Caltanissetta','Campobasso','Caserta','Catania','Catanzaro','Chieti','Como','Cosenza','Cremona','Crotone','Cuneo',
        'Enna',
        'Ferrara','Firenze','Foggia','Forlì e Cesena','Frosinone',
        'Genova','Gorizia','Grosseto',
        'Imperia','Isernia',
        'La Spezia','Latina','Lecce','Lecco','Livorno','Lodi','Lucca',
        'Macerata','Mantova','Massa-Carrara','Matera','Messina','Milano','Modena',
        'Napoli','Novara','Nuoro',
        'Oristano',
        'Padova','Palermo','Parma','Pavia','Perugia','Pesaro e Urbino','Pescara','Piacenza','Pisa','Pistoia','Pordenone','Potenza','Prato',
        'Ragusa','Ravenna','Reggio Calabria','Reggio Emilia','Rieti','Rimini','Roma','Rovigo',
        'Salerno','Sassari','Savona','Siena','Siracusa','Sondrio',
        'Taranto','Teramo','Terni','Torino','Trapani','Trento','Treviso','Trieste',
        'Udine',
        'Varese','Venezia','Verbano-Cusio-Ossola','Vercelli','Verona','Vibo Valentia','Vicenza','Viterbo'];

</script>

</body>
</html>