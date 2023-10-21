package com.corso.vagoni;

import com.corso.Colore;

public abstract class Locomotiva extends VagoneGenerico {

	private Integer potenzaMotore;
	private Integer carburanteMassimo;
	private Integer carburanteAttuale;

	public Locomotiva(String stringId, String marca, Integer peso, Integer lunghezza, Colore colore,
			Integer potenzaMotore, Integer carburanteMassimo, Integer carburanteAttuale) {
		super(stringId, marca, peso, lunghezza, colore);
		this.potenzaMotore = potenzaMotore;
		this.carburanteMassimo = carburanteMassimo;
		this.carburanteAttuale = carburanteAttuale;
	}

	public Integer getPotenzaMotore() {
		return potenzaMotore;
	}

	public void setPotenzaMotore(Integer potenzaMotore) {
		this.potenzaMotore = potenzaMotore;
	}

	public Integer getCarburanteMassimo() {
		return carburanteMassimo;
	}

	public void setCarburanteMassimo(Integer carburanteMassimo) {
		this.carburanteMassimo = carburanteMassimo;
	}

	public Integer getCarburanteAttuale() {
		return carburanteAttuale;
	}

	public void setCarburanteAttuale(Integer carburanteAttuale) {
		this.carburanteAttuale = carburanteAttuale;
	}

	@Override
	protected String tipoVagone() {

		return com.corso.enumerati.TipoVagoneEnum.LOCOMOTIVA.getNome();
	}

	@Override
	protected String infoAggiuntive() {

		return potenzaMotore + "KW" + " Carburante: " + carburanteAttuale + "/" + carburanteMassimo;
	}

}
