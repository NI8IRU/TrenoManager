package com.progetto.fr_vagoni;

import com.progetto.Colore;
import com.progetto.vagoni.Passeggeri;

public class FRPasseggeri extends Passeggeri {

	public FRPasseggeri(Integer id, String stringId, Integer marca, Double peso, Double lunghezza, Colore colore,
			Integer numeroMassimoPasseggeri, Integer numeroPasseggeri) {
		super(id, stringId, marca, peso, lunghezza, colore, numeroMassimoPasseggeri, numeroPasseggeri);
	}

}
