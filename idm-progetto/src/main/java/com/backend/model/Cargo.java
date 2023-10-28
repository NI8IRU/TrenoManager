package com.backend.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public abstract class Cargo extends VagoneGenerico {

	private Integer numeroPacchi;
	
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

	public Integer getNumeroPacchi() {
		return numeroPacchi;
	}

	public void setNumeroPacchi(Integer numeroPacchi) {
		this.numeroPacchi = numeroPacchi;
	}

}
