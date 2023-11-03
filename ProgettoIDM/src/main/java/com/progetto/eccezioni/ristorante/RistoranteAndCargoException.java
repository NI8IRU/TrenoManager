package com.progetto.eccezioni.ristorante;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class RistoranteAndCargoException extends RistoranteException {

	public RistoranteAndCargoException(String sigla) {
		super(sigla);
	}

	@Override
	public String soluzione() {
		ArrayList<String> arraySigla = conversioneInArrayList();
		if (arraySigla.contains("P")) {
			while (arraySigla.contains("C")) {
				arraySigla.remove("C");
			}
		} else {
			while (arraySigla.contains("R")) {
				arraySigla.remove("R");
			}
		}
		return "Il treno non può contenere un vagone di tipo Cargo e un vagone di tipo Ristorante assieme, "
				+ "prova con questa soluzione: " + String.join("", arraySigla);
	}

}
