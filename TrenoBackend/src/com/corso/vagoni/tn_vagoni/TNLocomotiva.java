package com.corso.vagoni.tn_vagoni;

import com.corso.Colore;
import com.corso.vagoni.Locomotiva;

public class TNLocomotiva extends Locomotiva {

	public TNLocomotiva(Integer id, String stringId, Integer marca, Double peso, Double lunghezza, Colore colore,
			Integer potenzaMotore, Integer carburanteMassimo, Integer carburanteAttuale) {
		super(id, stringId, marca, peso, lunghezza, colore, potenzaMotore, carburanteMassimo, carburanteAttuale);
	}

}
