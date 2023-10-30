package com.progetto.fr_vagoni;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.progetto.Colore;
import com.progetto.vagoni.Ristorante;

@Entity
@DiscriminatorValue("VAGONE_FR_RISTORANTE")
public class FRRistorante extends Ristorante {

	public FRRistorante(Integer id,  String marca, double peso, double lunghezza, Colore colore,
			String stelleRistorante, String menu) {
		super(id, marca, peso, lunghezza, colore, stelleRistorante, menu);
	}
	
	public FRRistorante(String marca, double peso, double lunghezza, Colore colore,
			String stelleRistorante, String menu) {
		super(marca, peso, lunghezza, colore, stelleRistorante, menu);
	}

}