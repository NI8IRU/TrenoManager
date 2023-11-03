package com.progetto.eccezioni.locomotiva;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class LocomotivaSurplussException extends LocomotivaException {

	public LocomotivaSurplussException(String sigla) {
		super(sigla);
	}

	@Override
	public String soluzione() {
		
		ArrayList<String> arraySigla = conversioneInArrayList();
		ArrayList<String> arraySiglaCorretto = new ArrayList<String>();
		while (safetyCheck("H") > 2) {
			arraySigla.remove("H");
			setSigla(String.join("", arraySigla));
		}
		ordinatoreDueLocomotive(arraySigla, arraySiglaCorretto);
		
		return "Ci sono troppe Locomotive nella composizione del treno, "
				+ "prova con questa soluzione: " + String.join("", arraySiglaCorretto);
	}

}
