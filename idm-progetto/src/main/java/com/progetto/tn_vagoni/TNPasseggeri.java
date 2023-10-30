package com.progetto.tn_vagoni;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.progetto.Colore;
import com.progetto.vagoni.Passeggeri;

@Entity
@DiscriminatorValue("VAGONE_TN_PASSEGGERI")
public class TNPasseggeri extends Passeggeri {

	public TNPasseggeri(Integer id, String marca, double peso, double lunghezza, Colore colore,
			Integer numeroMassimoPasseggeri, Integer numeroPasseggeri) {
		super(id, marca, peso, lunghezza, colore, numeroMassimoPasseggeri, numeroPasseggeri);
	}

	public TNPasseggeri(String marca, double peso, double lunghezza, Colore colore,
			Integer numeroMassimoPasseggeri, Integer numeroPasseggeri) {
		super(marca, peso, lunghezza, colore, numeroMassimoPasseggeri, numeroPasseggeri);
	}
	
}
