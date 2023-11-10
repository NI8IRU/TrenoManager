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

		<h1>Registration form</h1>
		<form action="insertUtente" method="post">

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="username">Nome</label> <input type="text" required
							class="form-control" id="nome" name="nome"
							placeholder="Enter Nome">
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="username">Username</label> <input type="text"
							class="form-control" id="username" name="username"
							placeholder="Enter Username">
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="designation">Password</label> <input type="password"
							class="form-control" id="password" name="password"
							placeholder="Enter password">
					</div>
				</div>
				
				<div class="col">
					<div class="form-group">
						<label for="designation">Codice fiscale</label> <input required
							class="form-control" id="codiceFiscale" name="codiceFiscale"
							placeholder="Enter CF">
					</div>
				</div>
				
			</div>
			
			
			


			<a href="${pageContext.request.contextPath }/"
				class="btn btn-warning"> Back </a>
			<button type="submit" class="btn btn-primary">Sign in</button>
		</form>

	</div>
	
	<script type="text/javascript">
	
		var country_list = [ "Afghanistan", "Albania", "Algeria", "Andorra",
				"Angola", "Anguilla", "Antigua &amp; Barbuda", "Argentina",
				"Armenia", "Aruba", "Australia", "Austria", "Azerbaijan",
				"Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus",
				"Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
				"Bosnia &amp; Herzegovina", "Botswana", "Brazil",
				"British Virgin Islands", "Brunei", "Bulgaria", "Burkina Faso",
				"Burundi", "Cambodia", "Cameroon", "Cape Verde",
				"Cayman Islands", "Chad", "Chile", "China", "Colombia",
				"Congo", "Cook Islands", "Costa Rica", "Cote D Ivoire",
				"Croatia", "Cruise Ship", "Cuba", "Cyprus", "Czech Republic",
				"Denmark", "Djibouti", "Dominica", "Dominican Republic",
				"Ecuador", "Egypt", "El Salvador", "Equatorial Guinea",
				"Estonia", "Ethiopia", "Falkland Islands", "Faroe Islands",
				"Fiji", "Finland", "France", "French Polynesia",
				"French West Indies", "Gabon", "Gambia", "Georgia", "Germany",
				"Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guam",
				"Guatemala", "Guernsey", "Guinea", "Guinea Bissau", "Guyana",
				"Haiti", "Honduras", "Hong Kong", "Hungary", "Iceland",
				"India", "Indonesia", "Iran", "Iraq", "Ireland", "Isle of Man",
				"Israel", "Italy", "Jamaica", "Japan", "Jersey", "Jordan",
				"Kazakhstan", "Kenya", "Kuwait", "Kyrgyz Republic", "Laos",
				"Latvia", "Lebanon", "Lesotho", "Liberia", "Libya",
				"Liechtenstein", "Lithuania", "Luxembourg", "Macau",
				"Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives",
				"Mali", "Malta", "Mauritania", "Mauritius", "Mexico",
				"Moldova", "Monaco", "Mongolia", "Montenegro", "Montserrat",
				"Morocco", "Mozambique", "Namibia", "Nepal", "Netherlands",
				"Netherlands Antilles", "New Caledonia", "New Zealand",
				"Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan",
				"Palestine", "Panama", "Papua New Guinea", "Paraguay", "Peru",
				"Philippines", "Poland", "Portugal", "Puerto Rico", "Qatar",
				"Reunion", "Romania", "Russia", "Rwanda",
				"Saint Pierre &amp; Miquelon", "Samoa", "San Marino",
				"Satellite", "Saudi Arabia", "Senegal", "Serbia", "Seychelles",
				"Sierra Leone", "Singapore", "Slovakia", "Slovenia",
				"South Africa", "South Korea", "Spain", "Sri Lanka",
				"St Kitts &amp; Nevis", "St Lucia", "St Vincent", "St. Lucia",
				"Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland",
				"Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand",
				"Timor L'Este", "Togo", "Tonga", "Trinidad &amp; Tobago",
				"Tunisia", "Turkey", "Turkmenistan", "Turks &amp; Caicos",
				"Uganda", "Ukraine", "United Arab Emirates", "United Kingdom",
				"Uruguay", "Uzbekistan", "Venezuela", "Vietnam",
				"Virgin Islands (US)", "Yemen", "Zambia", "Zimbabwe" ];
		var option = "";
		for (var i = 0; i < country_list.length; i++) {
			option += '<option value= "'+ country_list[i] +'">'
					+ country_list[i] + "</option>";
		}
		document.getElementById('nazione').innerHTML += option;
	</script>
</body>
</html>