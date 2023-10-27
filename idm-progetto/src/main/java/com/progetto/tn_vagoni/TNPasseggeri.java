package com.progetto.tn_vagoni;

import com.progetto.Colore;
import com.progetto.vagoni.Passeggeri;

public class TNPasseggeri extends Passeggeri {

	public TNPasseggeri(Integer id, String stringId, Integer marca, Double peso, Double lunghezza, Colore colore,
			Integer numeroMassimoPasseggeri, Integer numeroPasseggeri) {
		super(id, stringId, marca, peso, lunghezza, colore, numeroMassimoPasseggeri, numeroPasseggeri);
	}

}
