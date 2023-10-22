package com.corso.vagoni.tn_vagoni;

import com.corso.Colore;
import com.corso.vagoni.Cargo;

public class TNCargo extends Cargo {

	public TNCargo(Integer id, String stringId, Integer marca, Double peso, Double lunghezza, Colore colore,
			Integer numeroMassimoPacchi, Integer numeroPacchi) {
		super(id, stringId, marca, peso, lunghezza, colore, numeroMassimoPacchi, numeroPacchi);
	}

}
