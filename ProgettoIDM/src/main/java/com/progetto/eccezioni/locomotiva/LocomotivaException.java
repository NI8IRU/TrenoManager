package com.progetto.eccezioni.locomotiva;

import java.util.ArrayList;

import com.progetto.eccezioni.TrenoIrregolareException;

@SuppressWarnings("serial")
public abstract class LocomotivaException extends TrenoIrregolareException {

	public LocomotivaException(String sigla) {
		super(sigla);
	}
	
	public void aggiungiLocomotivaInTesta(ArrayList<String> arraySigla, ArrayList<String> arraySiglaCorretto) {
		arraySiglaCorretto.add("H");
		arraySiglaCorretto.addAll(arraySigla);
	}
	
	public void creaCargoSenzaLocomotiva(ArrayList<String> arraySigla) {
		arraySigla.clear();
		arraySigla.add("C");
		arraySigla.add("C");
		arraySigla.add("C");
	}
	
	public void creaPasseggeroSenzaLocomotiva(ArrayList<String> arraySigla) {
		arraySigla.clear();
		arraySigla.add("P");
		arraySigla.add("P");
		arraySigla.add("P");
	}

	public void ordinatoreDueLocomotive(ArrayList<String> arraySigla, ArrayList<String> arraySiglaCorretto) {
		arraySigla.remove("H");
		arraySigla.remove("H");
		aggiungiLocomotivaInTesta(arraySigla, arraySiglaCorretto);
		arraySiglaCorretto.add("H");
	}

	public void ordinatoreUnaLocomotiva(ArrayList<String> arraySigla, ArrayList<String> arraySiglaCorretto) {
		arraySigla.remove("H");
		aggiungiLocomotivaInTesta(arraySigla, arraySiglaCorretto);
	}


}
