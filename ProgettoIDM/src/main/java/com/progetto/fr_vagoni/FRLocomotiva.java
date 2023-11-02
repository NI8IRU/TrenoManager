package com.progetto.fr_vagoni;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.progetto.Colore;
import com.progetto.vagoni.Locomotiva;

@Entity
@DiscriminatorValue("LOCOMOTIVA_FR")
public class FRLocomotiva extends Locomotiva {

	public FRLocomotiva(Integer id, String marca, double peso, double lunghezza, Colore colore,
			Integer potenzaMotore, Integer carburanteMassimo, Integer carburanteAttuale) {
		super(id, marca, peso, lunghezza, colore, potenzaMotore, carburanteMassimo, carburanteAttuale);
	}

	public FRLocomotiva(String marca, double peso, double lunghezza, Colore colore,
			Integer potenzaMotore, Integer carburanteMassimo, Integer carburanteAttuale) {
		super(marca, peso, lunghezza, colore, potenzaMotore, carburanteMassimo, carburanteAttuale);
	}

	public FRLocomotiva() {}
}
