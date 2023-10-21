package com.corso.vagoni;

import com.corso.Colore;

public abstract class VagoneGenerico implements Vagone {

	private String stringId;
	private String marca;
	private Integer peso;
	private Integer lunghezza;
	private Colore colore;

	public VagoneGenerico(String stringId, String marca, Integer peso, Integer lunghezza, Colore colore) {
		this.stringId = stringId;
		this.marca = marca;
		this.peso = peso;
		this.lunghezza = lunghezza;
		this.colore = colore;
	}

	public String getStringId() {
		return stringId;
	}

	public void setStringId(String stringId) {
		this.stringId = stringId;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(Integer lunghezza) {
		this.lunghezza = lunghezza;
	}

	public Colore getColore() {
		return colore;
	}

	public void setColore(Colore colore) {
		this.colore = colore;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return tipoVagone() + ": " + colore + " " + lunghezza + "m " + peso + "t " + infoAggiuntive();
	}

	protected abstract String tipoVagone();

	protected abstract String infoAggiuntive();

}
