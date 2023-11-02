package com.progetto.eccezioni;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("serial")
public abstract class TrenoIrregolareException extends TrenoUniversalException {

	public TrenoIrregolareException(String sigla) {
		super(sigla);
	}
	
	public ArrayList<String> conversioneInArrayList() {
		String[] charArray = super.getSigla().split("");
		ArrayList<String> arraySigla = new ArrayList<String>(Arrays.asList(charArray));
		return arraySigla;
	}
	
	public Integer safetyCheck(String c) {
		ArrayList<String> arraySigla = conversioneInArrayList();
		Integer iteratore = 0;
		for (String carattere : arraySigla) {
			if (carattere.equals(c)) {
				iteratore++;
			}
		}

		return iteratore;
	}
	
	public abstract String soluzione();
	
}
