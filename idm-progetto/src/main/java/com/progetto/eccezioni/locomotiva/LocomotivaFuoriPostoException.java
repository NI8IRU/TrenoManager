package com.progetto.eccezioni.locomotiva;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class LocomotivaFuoriPostoException extends LocomotivaException {



	public LocomotivaFuoriPostoException(String sigla) {
		super(sigla);
	}

	@Override
	public String soluzione() {
		Integer check = safetyCheck("H");
		ArrayList<String> arraySigla = conversioneInArrayList();
		ArrayList<String> arraySiglaCorretto = new ArrayList<String>();
		
			if (check == 1) ordinatoreUnaLocomotiva(arraySigla, arraySiglaCorretto);
			
			if (check == 2) ordinatoreDueLocomotive(arraySigla, arraySiglaCorretto);
		
		if (check <= 2) {
			String newSigla = String.join("", arraySiglaCorretto);
			return "La locomotiva non è posizionata all'inizio e/o alla fine della coda, "
					+ "prova con questa soluzione: " + newSigla;
		} else {
			return "Non è stato possibile calcolare una soluzione, vi sono più di 2 locomotive nella stringa.";
		}
		
	}
	
}
