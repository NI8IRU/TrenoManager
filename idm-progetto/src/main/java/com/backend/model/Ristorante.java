package com.backend.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public abstract class Ristorante extends VagoneGenerico {

	private String posti;
	private String menu;
	
	@ManyToOne
	@JoinColumn(name = "marcaId")
	private Marca marcaId;

	@ManyToOne
	@JoinColumn(name = "coloreId")
	private Colore coloreId;

	public Colore getColoreId() {
		return coloreId;
	}

	public void setColoreId(Colore colore) {
		this.coloreId = colore;
	}

	public Marca getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(Marca marca) {
		this.marcaId = marca;
	}

	public String getPosti() {
		return posti;
	}

	public void setPosti(String stelleRistorante) {
		this.posti = stelleRistorante;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

}
