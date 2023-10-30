<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualizza treni</title>
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
				<h4>Filtra per data</h4>
				<br>
				<p>Dal:</p>
				<input id="DataDa" name="Date" type="date">
				<p>Al:</p>
				<input id="DataA" name="Date" type="date">
				<button id="cerca" class="btn btn-primary">Cerca</button>
	<table>
		<tr>
			<th>Data creazione</th>
			<th>Composizione treno</th>
			<th>Marca</th>
			<th>Tipo treno</th>
		</tr>
		<%
		for (int i = 0; i < 0/*lunghezza lista treni*/; i++) {
		%>
		<tr>
			<td>${DataCreazione}</td>
			<td>${ComposizioneTreno}</td>
			<td>${Marca}</td>
			<td>${TipoTreno}</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>