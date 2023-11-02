package com.progetto.eccezioni;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class PasseggeriAndCargoException extends TrenoIrregolareException {

	public PasseggeriAndCargoException(String sigla) {
		super(sigla);
	}

	@Override
	public String soluzione() {
		ArrayList<String> arraySiglaA = conversioneInArrayList();
		ArrayList<String> arraySiglaB = conversioneInArrayList();
		
		while (arraySiglaA.contains("C")) {
			arraySiglaA.remove("C");
		}
		
		while (arraySiglaB.contains("P")) {
			arraySiglaB.remove("P");
		}
		
		return "Il treno non può contenere contemporaneamente vagoni Passeggeri e vagoni Cargo, "
				+ "puoi provare con una di queste due soluzioni: " + String.join("", arraySiglaA)
				+ ", " + String.join("", arraySiglaB);
	}

}
