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
						<th>Marca<th>
						<th>Tipo Vagone</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vagone" items="${vagoni}">
						<tr>
							<td class="table-plus">${vagone.id}</td>
							<td>${vagone.marca}</td>
							<td>${vagone.tipoVagone}</td>
							
							<td><a href="prenotaPosto" class="btn btn-warning">
									Prenota </a></td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>