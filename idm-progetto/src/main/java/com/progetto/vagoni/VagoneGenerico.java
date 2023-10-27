package com.progetto.vagoni;

import com.progetto.Colore;

public abstract class VagoneGenerico implements Vagone {
	
	private Integer id;
	private String stringId;
	private Integer marca;
	private Double peso;
	private Double lunghezza;
	private Colore colore;

	public VagoneGenerico(Integer id, String stringId, Integer marca, Double peso, Double lunghezza, Colore colore) {
		this.id = id;
		this.stringId = stringId;
		this.marca = marca;
		this.peso = peso;
		this.lunghezza = lunghezza;
		this.colore = colore;
	}
	
	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getStringId() {
		return stringId;
	}

	public void setStringId(String stringId) {
		this.stringId = stringId;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(Double lunghezza) {
		this.lunghezza = lunghezza;
	}

	public Colore getColore() {
		return colore;
	}

	public void setColore(Colore colore) {
		this.colore = colore;
	}

	public Integer getMarca() {
		return marca;
	}

	public void setMarca(Integer marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return tipoVagone() + ": " + colore + " " + lunghezza + "m " + peso + "t " + infoAggiuntive();
	}

	protected abstract String tipoVagone();

	protected abstract String infoAggiuntive();

}
