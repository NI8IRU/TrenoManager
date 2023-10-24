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

	<table>
		<tr>
			<th>id Utente</th>
			<th>Data creazione</th>
			<th>Composizione treno</th>
			<th>Marca</th>
			<th>Tipo treno</th>
		</tr>
		<%
		for (int i = 0; i < 0/*lunghezza lista treni*/; i++) {
		%>
		<tr>
			<td>${idUtenteCreazione}</td>
			<td>${DataCreazione}</td>
			<td>${ComposzioneTreno}</td>
			<td>${Marca}</td>
			<td>${TipoTreno}</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>