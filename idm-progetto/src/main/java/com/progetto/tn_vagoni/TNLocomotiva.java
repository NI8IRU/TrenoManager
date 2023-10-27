package com.progetto.tn_vagoni;

import com.progetto.Colore;
import com.progetto.vagoni.Locomotiva;

public class TNLocomotiva extends Locomotiva {

	public TNLocomotiva(Integer id, String stringId, Integer marca, Double peso, Double lunghezza, Colore colore,
			Integer potenzaMotore, Integer carburanteMassimo, Integer carburanteAttuale) {
		super(id, stringId, marca, peso, lunghezza, colore, potenzaMotore, carburanteMassimo, carburanteAttuale);
	}

}