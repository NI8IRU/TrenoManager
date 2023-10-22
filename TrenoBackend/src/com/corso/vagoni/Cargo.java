package com.corso.vagoni;

import com.corso.Colore;

public abstract class Cargo extends VagoneGenerico {

	private Integer numeroMassimoPacchi;
	private Integer numeroPacchi;

	public Cargo(Integer id, String stringId, Integer marca, Double peso, Double lunghezza, Colore colore,
			Integer numeroMassimoPacchi, Integer numeroPacchi) {
		super(id, stringId, marca, peso, lunghezza, colore);
		this.numeroMassimoPacchi = numeroMassimoPacchi;
		this.numeroPacchi = numeroPacchi;
	}

	public Integer getNumeroMassimoPacchi() {
		return numeroMassimoPacchi;
	}

	public void setNumeroMassimoPacchi(Integer numeroMassimoPacchi) {
		this.numeroMassimoPacchi = numeroMassimoPacchi;
	}

	public Integer getNumeroPacchi() {
		return numeroPacchi;
	}

	public void setNumeroPacchi(Integer numeroPacchi) {
		this.numeroPacchi = numeroPacchi;
	}

	@Override
	protected String tipoVagone() {
		return com.corso.enumerati.TipoVagoneEnum.CARGO.getNome();
	}

	@Override
	protected String infoAggiuntive() {
		return "Carico: " + numeroPacchi + "/" + numeroMassimoPacchi + "t";
	}

}
