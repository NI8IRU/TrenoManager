<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento treni</title>
</head>
<body>
	<div>
		<label for="ComposizioneTreno">Componi treno:</label> <input
		<input type="radio" name="Passeggeri" value="Passeggeri" />Passeggeri
		<input type="radio" name="Cargo" value="Cargo" />Cargo
		
			type="text" id="ComposizioneTreno" name="ComposizioneTreno" required>
			
		<select name="Marca">
			<%
			for (int i = 0; i < 0/*lunghezza lista marche*/; i++) {
			%>
			<option value="category_id">${Marca}</option>
			<%
			}
			%>
		</select>
		<label for="ComposizioneTreno">Tipo treno:</label>
		
	</div>
	<div>
		<input type="submit" value="Login">
	</div>
</body>
</html>