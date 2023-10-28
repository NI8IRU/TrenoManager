package com.backend.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public abstract class Locomotiva extends VagoneGenerico {

	private Integer potenzaMotore;
	private Integer carburante;
	
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
	

	public Integer getPotenzaMotore() {
		return potenzaMotore;
	}

	public void setPotenzaMotore(Integer potenzaMotore) {
		this.potenzaMotore = potenzaMotore;
	}

	public Integer getCarburante() {
		return carburante;
	}

	public void setCarburante(Integer carburanteMassimo) {
		this.carburante = carburanteMassimo;
	}

}
