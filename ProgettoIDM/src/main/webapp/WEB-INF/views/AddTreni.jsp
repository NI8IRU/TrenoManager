<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Crea treno</title>
<link href="../resouces/css/css1.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<style>
.messaggioSuccesso{
	color: green;
}
</style>
<body>
	<div class="container mt-3">
	
	<div>
		<h1>Inserisci treni</h1>
				<c:if test="${not empty msg }">
							<h5 class="text-success">${msg }</h5>
							<c:remove var="msg" />
						</c:if>
						
				<c:if test="${not empty successMsg }">
							<h5 class="messaggioSuccesso">${successMsg }</h5>
							<c:remove var="successMsg" />
						</c:if>
						
		</div>
		
		<a href="treni" class="btn btn-primary"> Visualizza Treni </a>
		
		<form id="insertForm" action="AddTren" method="post">
			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="Scegli marca">Scegli marca</label><br> <input
							type="radio" id="FR" name="marca" value="0" checked="checked">
						<label for="FR">Freccia Rossa</label> <input type="radio" id="TN"
							name="marca" value="1"> <label for="TN">TreNord</label><br>
						<br> <label for="Scegli tipo treno">Scegli tipo treno</label><br>
						<input type="radio" onclick="checkPasseggeri('')" id="Passeggeri"
							name="tipoTreno" value="0"> <label for="Passeggeri">Passeggeri</label>
						<input type="radio" onclick="checkCargo('')" id="Cargo"
							name="tipoTreno" value="1"> <label for="cargo">Cargo</label><br>
						<br> <label for="composizione treno">Composizione
							treno</label>
						<button id="btnSvuota" onclick="SvuotaClick('')"
							class="btn btn-primary">Svuota</button>
						<input onchange="disableRadio" type="text" class="form-control"
							id="ComposizioneTreno" name="ComposizioneTreno"
							placeholder="componi il tuo treno!" readonly>
					</div>

					<button id="btnLocomotiva"  onclick="LocomotivaClick('H')"
						class="btn btn-primary">Locomotiva - H</button>
					<button id="btnPasseggeri"  onclick="PasseggeriClick('P')"
						class="btn btn-primary">Passeggeri - P</button>
					<button id="btnRistorante"  onclick="RistoranteClick('R')"
						class="btn btn-primary">Ristorante - R</button>
					<button id="btnCargo"  onclick="CargoClick('C')"
						class="btn btn-primary">Cargo - C</button>
				</div>
			</div>
			<a href="${pageContext.request.contextPath }/"
				class="btn btn-warning"> Indietro </a>
			<button id="ins" class="btn btn-primary">Inserisci</button>
		</form>
	</div>
	<script>
	function checkPasseggeri(the_text) { 
			document.getElementById('ComposizioneTreno').value = the_text;
			document.getElementById("btnCargo").disabled = true;
			document.getElementById("btnPasseggeri").disabled = false;
			document.getElementById("btnRistorante").disabled = false;
			document.getElementById("btnLocomotiva").disabled = false;
		} 
	
	function checkCargo(the_text) { 
		document.getElementById('ComposizioneTreno').value = the_text;
		document.getElementById("btnPasseggeri").disabled = true;
		document.getElementById("btnRistorante").disabled = true;
		document.getElementById("btnLocomotiva").disabled = false;
		document.getElementById("btnCargo").disabled = false;
	}
	
	function LocomotivaClick(the_text) {
        document.getElementById('ComposizioneTreno').value += the_text;
    return;
    }
	
	function PasseggeriClick(the_text) {
        document.getElementById('ComposizioneTreno').value += the_text;
    return;
    }
	
	function RistoranteClick(the_text) {
        document.getElementById('ComposizioneTreno').value += the_text;
    return;
    }
	
	function CargoClick(the_text) {
        document.getElementById('ComposizioneTreno').value += the_text;
    return;-
    }
	
	function SvuotaClick(the_text) {
        document.getElementById('ComposizioneTreno').value = the_text;
    return;
    }
	/*
	function disableRadio{ 
		if(document.getElementById("ComposizioneTreno").innerText !== null)
		{
			document.getElementById("Cargo").disabled = true;
			document.getElementById("Passeggeri").disabled = true;
		}else
		{
			document.getElementById("Cargo").disabled = false;
			document.getElementById("Passeggeri").disabled = false;
		}
	}
	*/
	</script>
</body>
</html>