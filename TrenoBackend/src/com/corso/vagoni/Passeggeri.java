package com.corso.vagoni;

import com.corso.Colore;

public abstract class Passeggeri extends VagoneGenerico {

	private Integer numeroMassimoPasseggeri;
	private Integer numeroPasseggeri;
	private Integer numeroFinestre;

	public Passeggeri(String stringId, String marca, Integer peso, Integer lunghezza, Colore colore,
			Integer numeroMassimoPasseggeri, Integer numeroPasseggeri) {
		super(stringId, marca, peso, lunghezza, colore);
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
		return com.corso.enumerati.TipoVagoneEnum.PASSEGGERI.getNome();
	}

	@Override
	protected String infoAggiuntive() {
		return "Passeggeri: " + numeroPasseggeri + "/" + numeroMassimoPasseggeri;
	}

}
