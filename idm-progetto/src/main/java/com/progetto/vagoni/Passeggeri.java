package com.progetto.vagoni;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.progetto.Colore;

@Entity
@DiscriminatorValue("VAGONE_PASSEGGERI")
public class Passeggeri extends Vagone {

	private Integer numeroMassimoPasseggeri;
	private Integer numeroPasseggeri;
	private Integer numeroFinestre;

	public Passeggeri(Integer id, String marca, double peso, double lunghezza, Colore colore,
			Integer numeroMassimoPasseggeri, Integer numeroPasseggeri) {
		super(id, marca, peso, lunghezza, colore);
		this.numeroMassimoPasseggeri = numeroMassimoPasseggeri;
		this.numeroPasseggeri = numeroPasseggeri;
		numeroFinestre = numeroMassimoPasseggeri / 2;
	}
	
	public Passeggeri(String marca, double peso, double lunghezza, Colore colore,
			Integer numeroMassimoPasseggeri, Integer numeroPasseggeri) {
		super(marca, peso, lunghezza, colore);
		this.numeroMassimoPasseggeri = numeroMassimoPasseggeri;
		this.numeroPasseggeri = numeroPasseggeri;
		numeroFinestre = numeroMassimoPasseggeri / 2;
	}

	public Integer getNumeroMassimoPasseggeri() {
		return numeroMassimoPasseggeri;
	}

	public void setNumeroMassimoPasseggeri(Integer numeroMassimoPasseggeri) {
		this.numeroMassimoPasseggeri = numeroMassimoPasseggeri;
	}

	public Integer getNumeroPasseggeri() {
		return numeroPasseggeri;
	}

	public void setNumeroPasseggeri(Integer numeroPasseggeri) {
		this.numeroPasseggeri = numeroPasseggeri;
	}

	public Integer getNumeroFinestre() {
		return numeroFinestre;
	}

	public void setNumeroFinestre(Integer numeroFinestre) {
		this.numeroFinestre = numeroFinestre;
	}

	@Override
	protected String tipoVagone() {
		return com.progetto.enumerati.TipoVagoneEnum.PASSEGGERI.getNome();
	}

	@Override
	protected String infoAggiuntive() {
		return "Passeggeri: " + numeroPasseggeri + "/" + numeroMassimoPasseggeri;
	}

}
