package com.corso.vagoni.tn_vagoni;

import com.corso.Colore;
import com.corso.vagoni.Cargo;

public class TNCargo extends Cargo {

	public TNCargo(String stringId, String marca, Integer peso, Integer lunghezza, Colore colore,
			Integer numeroMassimoPacchi, Integer numeroPacchi) {
		super(stringId, marca, peso, lunghezza, colore, numeroMassimoPacchi, numeroPacchi);
	}

}
