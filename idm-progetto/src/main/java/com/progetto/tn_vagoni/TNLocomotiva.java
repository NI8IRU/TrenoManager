package com.progetto.tn_vagoni;

import com.progetto.Colore;
import com.progetto.vagoni.Locomotiva;

public class TNLocomotiva extends Locomotiva {

	public TNLocomotiva(Integer id, String marca, double peso, double lunghezza, Colore colore,
			Integer potenzaMotore, Integer carburanteMassimo, Integer carburanteAttuale) {
		super(id, marca, peso, lunghezza, colore, potenzaMotore, carburanteMassimo, carburanteAttuale);
	}

	public TNLocomotiva(String marca, double peso, double lunghezza, Colore colore,
			Integer potenzaMotore, Integer carburanteMassimo, Integer carburanteAttuale) {
		super(marca, peso, lunghezza, colore, potenzaMotore, carburanteMassimo, carburanteAttuale);
	}

	
	


	

}