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
	<h1>Lista Viaggi</h1>
	
	<!-- FILTRI RICERCA -->
	<button onclick="mostraFormFiltri()">Filtri</button>

		<div id="sezioneFiltri" style="display: none;">
		    <form action="searchViaggi" method="post">
		        
		        <label>Data Partenza:</label>
		        <input type="datetime-local" name="dataPartenza" ><br>
		
		        <label>Data Arrivo:</label>
		        <input type="datetime-local" name="dataArrivo" ><br>
		        
		
		        <label>Stazione Partenza:</label>
		        <input type="text" name="stazionePartenza" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}"><br>
		
		        <label>Stazione Destinazione:</label>
		        <input type="text" name="stazioneDestinazione" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}"><br>
				
				
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
</script>

</body>
</html>