package com.corso.vagoni.fr_vagoni;

import com.corso.Colore;
import com.corso.vagoni.Locomotiva;

public class FRLocomotiva extends Locomotiva {

	public FRLocomotiva(String stringId, String marca, Integer peso, Integer lunghezza, Colore colore,
			Integer potenzaMotore, Integer carburanteMassimo, Integer carburanteAttuale) {
		super(stringId, marca, peso, lunghezza, colore, potenzaMotore, carburanteMassimo, carburanteAttuale);
	}

}
