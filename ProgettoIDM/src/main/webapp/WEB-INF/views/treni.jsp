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

		<h1>Crea Treno</h1>
		<a href="addTreni" class="btn btn-primary"> Crea treno </a>
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
							
							<td><a href="prenotaPosto/${treno.id}" class="btn btn-warning">
									Modifica </a></td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>