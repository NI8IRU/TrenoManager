package com.progetto.fr_vagoni;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.progetto.Colore;
import com.progetto.vagoni.Cargo;

@Entity
@DiscriminatorValue("VAGONE_FR_CARGO")
public class FRCargo extends Cargo {

	public FRCargo(Integer id, String marca, double peso, double lunghezza, Colore colore,
			Integer numeroMassimoPacchi, Integer numeroPacchi) {
		super(id, marca, peso, lunghezza, colore, numeroMassimoPacchi, numeroPacchi);
	}

	public FRCargo(String marca, double peso, double lunghezza, Colore colore,
			Integer numeroMassimoPacchi, Integer numeroPacchi) {
		super(marca, peso, lunghezza, colore, numeroMassimoPacchi, numeroPacchi);
	}
	

}

