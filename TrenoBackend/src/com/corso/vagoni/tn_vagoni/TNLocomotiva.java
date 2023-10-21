package com.corso.vagoni.tn_vagoni;

import com.corso.Colore;
import com.corso.vagoni.Locomotiva;

public class TNLocomotiva extends Locomotiva {

	public TNLocomotiva(String stringId, String marca, Integer peso, Integer lunghezza, Colore colore,
			Integer potenzaMotore, Integer carburanteMassimo, Integer carburanteAttuale) {
		super(stringId, marca, peso, lunghezza, colore, potenzaMotore, carburanteMassimo, carburanteAttuale);
	}

}
