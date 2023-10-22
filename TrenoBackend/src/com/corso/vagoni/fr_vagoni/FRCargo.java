package com.corso.vagoni.fr_vagoni;

import com.corso.Colore;
import com.corso.vagoni.Cargo;

public class FRCargo extends Cargo {

	public FRCargo(Integer id, String stringId, Integer marca, Double peso, Double lunghezza, Colore colore,
			Integer numeroMassimoPacchi, Integer numeroPacchi) {
		super(id, stringId, marca, peso, lunghezza, colore, numeroMassimoPacchi, numeroPacchi);
	}

}
