package com.progetto.tn_vagoni;

import com.progetto.Colore;
import com.progetto.vagoni.Passeggeri;

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
