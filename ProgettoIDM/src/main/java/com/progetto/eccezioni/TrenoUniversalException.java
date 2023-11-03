package com.progetto.eccezioni;

@SuppressWarnings("serial")
public class TrenoUniversalException extends Exception {
	
	private String sigla;
	
	public TrenoUniversalException(String sigla) {
		this.sigla = sigla;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
