package com.progetto.eccezioni;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class NoPasseggeriWithRistoranteException extends TrenoIrregolareException {

	public NoPasseggeriWithRistoranteException(String sigla) {
		super(sigla);
	}

	@Override
	public String soluzione() {
		ArrayList<String> arraySigla = conversioneInArrayList();
		
		arraySigla.add("P");
		
		return "Il treno contiene un vagone Ristorante ma non sono presenti vagoni Passeggeri, "
				+ "prova con questa soluzione: " + String.join("", arraySigla);
	}

}
