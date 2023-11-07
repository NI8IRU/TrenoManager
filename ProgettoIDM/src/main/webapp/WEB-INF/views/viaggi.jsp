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
					<c:forEach var="viaggio" items="${viaggi}">
						<tr>
							<td class="table-plus">${viaggio.dataPartenza}</td>
							<td>${viaggio.dataArrivo}</td>
							<td>${viaggio.stazionePartenza}</td>
							<td>${viaggio.stazioneDestinazione}</td>
							<td><a href="prenotaPosto/${viaggio.id}" class="btn btn-warning">
									prenota </a></td>
							
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>