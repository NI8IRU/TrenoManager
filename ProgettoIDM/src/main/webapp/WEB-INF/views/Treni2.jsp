<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<style>
.contenitore{
	display: flex;
	justify-content: space-between;
	margin-bottom: 2rem;
}
</style>
<body>


	<div class="container mt-3">
	<div class="contenitore">
		<div>
			<h1>Crea Treno</h1>
		<a href="addTreni" class="btn btn-primary"> Crea treno </a>
		</div>
		<div>
			<h1>Prenota Viaggio</h1>
			<a href="viaggi" class="btn btn-primary"> Prenota Viaggio </a>
		</div>
	</div>
	
	
		<div class="row">

			<table class="table table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Marca</th>
						<th>Tipo Treno</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="treno" items="${treni}">
						<tr>
							<td class="table-plus">${treno.id}</td>
							<td>${treno.marca}</td>
							<td>${treno.tipoTreno}</td>
							
							<td><a href="createViaggio/${treno.id}" class="btn btn-warning">
									Crea Viaggio </a></td>
							
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>



</body>
</html>