package com.progetto.fr_vagoni;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.progetto.Colore;
import com.progetto.vagoni.Passeggeri;

@Entity
@DiscriminatorValue("VAGONE_FR_PASSEGGERI")
public class FRPasseggeri extends Passeggeri {

	public FRPasseggeri(Integer id, String marca, double peso, double lunghezza, Colore colore,
			Integer numeroMassimoPasseggeri, Integer numeroPasseggeri) {
		super(id, marca, peso, lunghezza, colore, numeroMassimoPasseggeri, numeroPasseggeri);
	}

	public FRPasseggeri(String marca, double peso, double lunghezza, Colore colore,
			Integer numeroMassimoPasseggeri, Integer numeroPasseggeri) {
		super(marca, peso, lunghezza, colore, numeroMassimoPasseggeri, numeroPasseggeri);
	}

}
