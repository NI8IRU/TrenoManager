<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
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
		<div class="row">
			<div class="col">
				<div class="form-group">
					<a href="${login.jsp}/" class="btn btn-warning"> Logout </a> <a
						href="treniPerUtenteView/"
						class="btn btn-warning"> I tuoi treni </a> <a
						href="AddTreni.jsp"
						class="btn btn-warning">Nuovo treno</a><br>
					<h4>Filtra per data</h4>
					<br>
					<p>Dal:</p>
					<input id="DataDa" name="Date" type="date">
					<p>Al:</p>
					<input id="DataA" name="Date" type="date">
					<button id="cerca" class="btn btn-primary">Cerca</button>
					<table>
						<tr>
							<th>Nome e cognome</th>
							<th>Data creazione</th>
							<th>Composizione treno</th>
							<th>Marca</th>
							<th>Tipo treno</th>
						</tr>
						<%
						for (int i = 0; i < 0/*lunghezza lista treni*/; i++) {
						%>
						<tr>
							<td>${Nome} ${Cognome}</td>
							<td>${DataCreazione}</td>
							<td>${ComposizioneTreno}</td>
							<td>${Marca}</td>
							<td>${TipoTreno}</td>
						</tr>
						<%
						}
						%>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>