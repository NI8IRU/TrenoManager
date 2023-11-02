package com.progetto.eccezioni.locomotiva;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class OnlyLocomotiveException extends LocomotivaException {

	public OnlyLocomotiveException(String sigla) {
		super(sigla);
	}

	@Override
	public String soluzione() {
		int counter = safetyCheck("H");
		ArrayList<String> arraySiglaA = conversioneInArrayList();
		ArrayList<String> arraySiglaB = conversioneInArrayList();
		ArrayList<String> arraySiglaCorrettoA = new ArrayList<String>();
		ArrayList<String> arraySiglaCorrettoB = new ArrayList<String>();
		while (counter > 2) {
			arraySiglaA.remove("H");
			counter--;
		}
		
		if (counter == 2) {
			creaPasseggeroSenzaLocomotiva(arraySiglaA);
			aggiungiLocomotivaInTesta(arraySiglaA, arraySiglaCorrettoA);
			arraySiglaCorrettoA.add("H");
		}
		
		if (counter == 1) {
			creaCargoSenzaLocomotiva(arraySiglaA);
			aggiungiLocomotivaInTesta(arraySiglaA, arraySiglaCorrettoA);
		}
		
		while (counter > 2) {
			arraySiglaB.remove("H");
			counter--;
		}
		
		if (counter == 2) {
			creaCargoSenzaLocomotiva(arraySiglaB);
			aggiungiLocomotivaInTesta(arraySiglaB, arraySiglaCorrettoB);
			arraySiglaCorrettoB.add("H");
		}
		
		if (counter == 1) {
			creaCargoSenzaLocomotiva(arraySiglaB);
			aggiungiLocomotivaInTesta(arraySiglaB, arraySiglaCorrettoB);
		}
		return "La stringa contiene solamente Locomotive, "
				+ "prova con una di queste soluzioni: " + String.join("", arraySiglaCorrettoA)
						+ ", " + String.join("", arraySiglaCorrettoB);
	}

}
