package com.progetto.eccezioni.locomotiva;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class NoLocomotivaException extends LocomotivaException {

	public NoLocomotivaException(String sigla) {
		super(sigla);
	}

	@Override
	public String soluzione() {
		ArrayList<String> arraySigla = conversioneInArrayList();
		ArrayList<String> arraySiglaCorretto = new ArrayList<String>();
		aggiungiLocomotivaInTesta(arraySigla, arraySiglaCorretto);
		return "La stringa non contiene Locomotive, "
				+ "prova con questa soluzione: " + String.join("", arraySiglaCorretto);
	}

}
