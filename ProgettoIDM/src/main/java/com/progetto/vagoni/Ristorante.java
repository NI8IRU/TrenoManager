package com.progetto.vagoni;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.progetto.Colore;

@Entity
@DiscriminatorValue("VAGONE_RISTORANTE")
public class Ristorante extends Vagone {

	private String stelleRistorante;
	private String menu;
	private final String tipoVagone = "RISTORANTE";

	public Ristorante(Integer id, String marca, double peso, double lunghezza, Colore colore,
			String stelleRistorante, String menu) {
		super(id, marca, peso, lunghezza, colore);
		this.stelleRistorante = stelleRistorante;
		this.menu = menu;
	}

	public Ristorante(String marca, double peso, double lunghezza, Colore colore,
			String stelleRistorante, String menu) {
		super(marca, peso, lunghezza, colore);
		this.stelleRistorante = stelleRistorante;
		this.menu = menu;
	}
	
	public Ristorante() {}
	
	public String getStelleRistorante() {
		return stelleRistorante;
	}

	public void setStelleRistorante(String stelleRistorante) {
		this.stelleRistorante = stelleRistorante;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	@Override
	protected String tipoVagone() {
		return com.progetto.enumerati.TipoVagoneEnum.RISTORANTE.getNome();
	}

	@Override
	protected String infoAggiuntive() {
		return stelleRistorante + " " + menu;
	}

	public String getTipoVagone() {
		return tipoVagone;
	}
	
	

}
