package com.progetto.tn_vagoni;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.progetto.Colore;
import com.progetto.vagoni.Ristorante;

@Entity
@DiscriminatorValue("RISTORANTE_TN")
public class TNRistorante extends Ristorante {

	public TNRistorante(Long id,  String marca, double peso, double lunghezza, Colore colore,
			String stelleRistorante, String menu) {
		super(id, marca, peso, lunghezza, colore, stelleRistorante, menu);
	}

	
	public TNRistorante(String marca, double peso, double lunghezza, Colore colore,
			String stelleRistorante, String menu) {
		super(marca, peso, lunghezza, colore, stelleRistorante, menu);
	}
	
	public TNRistorante() {}
}
