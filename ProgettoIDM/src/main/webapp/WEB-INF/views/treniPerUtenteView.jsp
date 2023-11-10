<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
<title>Treni di {utenteLoggato.nome}</title>
</head>
<style>
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
<body>
	<div class="container mt-3">

		<h3>Ciao ${utenteLoggato.nome} ecco i tuoi treni</h3>

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
					<c:forEach var="treno" items="${treniPerUtente}">
						<tr>
							<td class="table-plus">${treno.id}</td>
							<td>${treno.marca}</td>
							<td>${treno.tipoTreno}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<a href="${pageContext.request.contextPath }/"
				class="btn btn-warning"> Back </a>
	</div>

</body>
</html>