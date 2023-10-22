package com.corso.vagoni;

import com.corso.Colore;

public abstract class Ristorante extends VagoneGenerico {

	private String stelleRistorante;
	private String menu;

	public Ristorante(Integer id, String stringId, Integer marca, Double peso, Double lunghezza, Colore colore,
			String stelleRistorante, String menu) {
		super(id, stringId, marca, peso, lunghezza, colore);
		this.stelleRistorante = stelleRistorante;
		this.menu = menu;
	}

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
		return com.corso.enumerati.TipoVagoneEnum.RISTORANTE.getNome();
	}

	@Override
	protected String infoAggiuntive() {
		return stelleRistorante + " " + menu;
	}

}
