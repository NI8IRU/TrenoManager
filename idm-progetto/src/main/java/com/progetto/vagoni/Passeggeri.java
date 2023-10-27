package com.progetto.vagoni;

import com.progetto.Colore;

public abstract class Passeggeri extends VagoneGenerico {

	private Integer numeroMassimoPasseggeri;
	private Integer numeroPasseggeri;
	private Integer numeroFinestre;

	public Passeggeri(Integer id, String stringId, Integer marca, Double peso, Double lunghezza, Colore colore,
			Integer numeroMassimoPasseggeri, Integer numeroPasseggeri) {
		super(id, stringId, marca, peso, lunghezza, colore);
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
