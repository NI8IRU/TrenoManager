package com.progetto.tn_vagoni;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.progetto.Colore;
import com.progetto.vagoni.Cargo;

@Entity
@DiscriminatorValue("VAGONE_TN_CARGO")
public class TNCargo extends Cargo {

	public TNCargo(Integer id, String marca, double peso, double lunghezza, Colore colore,
			Integer numeroMassimoPacchi, Integer numeroPacchi) {
		super(id, marca, peso, lunghezza, colore, numeroMassimoPacchi, numeroPacchi);
	}

	public TNCargo(String marca, double peso, double lunghezza, Colore colore,
			Integer numeroMassimoPacchi, Integer numeroPacchi) {
		super(marca, peso, lunghezza, colore, numeroMassimoPacchi, numeroPacchi);
	}

	
	
}
