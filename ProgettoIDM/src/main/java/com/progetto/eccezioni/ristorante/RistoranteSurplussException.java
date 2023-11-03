package com.progetto.eccezioni.ristorante;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class RistoranteSurplussException extends RistoranteException {

	public RistoranteSurplussException(String sigla) {
		super(sigla);
	}
	
	@Override
	public String soluzione() {
		ArrayList<String> arraySigla = conversioneInArrayList();
		
		while (safetyCheck("R") > 1) {
			arraySigla.remove("R");
			super.setSigla(String.join("", arraySigla));
		}
		return "Il treno non può contenere più di un Ristorante, "
				+ "prova con questa soluzione: " + super.getSigla();
	}

}
