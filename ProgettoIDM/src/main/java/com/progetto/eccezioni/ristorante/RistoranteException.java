package com.progetto.eccezioni.ristorante;

import com.progetto.eccezioni.TrenoIrregolareException;

@SuppressWarnings("serial")
public abstract class RistoranteException extends TrenoIrregolareException {

	public RistoranteException(String sigla) {
		super(sigla);
	}
	
}
