package com.progetto.tn_vagoni;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.progetto.Colore;
import com.progetto.vagoni.Passeggeri;
import com.progetto.vagoni.PostoASedere;

@Entity
@DiscriminatorValue("PASSEGGERI_TN")
public class TNPasseggeri extends Passeggeri {

	public TNPasseggeri(Long id, String marca, double peso, double lunghezza, Colore colore,
			Integer numeroMassimoPasseggeri, Integer numeroPasseggeri) {
		super(id, marca, peso, lunghezza, colore, numeroMassimoPasseggeri, numeroPasseggeri);
	}

	public TNPasseggeri(String marca, double peso, double lunghezza, Colore colore,
			Integer numeroMassimoPasseggeri, Integer numeroPasseggeri) {
		super(marca, peso, lunghezza, colore, numeroMassimoPasseggeri, numeroPasseggeri);
		
	}
	
	public TNPasseggeri(String marca, double peso, double lunghezza, Colore colore,
			Integer numeroMassimoPasseggeri, Integer numeroPasseggeri, List<PostoASedere> posti) {
		super(marca, peso, lunghezza, colore, numeroMassimoPasseggeri, numeroPasseggeri, posti);
		
	}
	
	public TNPasseggeri() {}
}
