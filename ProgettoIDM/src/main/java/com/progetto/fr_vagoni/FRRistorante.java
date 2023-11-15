package com.progetto.fr_vagoni;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.progetto.Colore;
import com.progetto.vagoni.Ristorante;

@Entity
@DiscriminatorValue("RISTORANTE_FR")
public class FRRistorante extends Ristorante {

	public FRRistorante(Long id,  String marca, double peso, double lunghezza, Colore colore,
			String stelleRistorante, String menu) {
		super(id, marca, peso, lunghezza, colore, stelleRistorante, menu);
	}
	
	public FRRistorante(String marca, double peso, double lunghezza, Colore colore,
			String stelleRistorante, String menu) {
		super(marca, peso, lunghezza, colore, stelleRistorante, menu);
	}

	public FRRistorante() {}
}