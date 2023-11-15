package com.progetto.vagoni;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.progetto.Colore;

@Entity
@DiscriminatorValue("Locomotiva")
public class Locomotiva extends Vagone {

	private Integer potenzaMotore;
	private Integer carburanteMassimo;
	private Integer carburanteAttuale;
	private final String tipoVagone = "LOCOMOTIVA";

	public Locomotiva(Long id, String marca, double peso, double lunghezza, Colore colore,
			Integer potenzaMotore, Integer carburanteMassimo, Integer carburanteAttuale) {
		super(id, marca, peso, lunghezza, colore);
		this.potenzaMotore = potenzaMotore;
		this.carburanteMassimo = carburanteMassimo;
		this.carburanteAttuale = carburanteAttuale;
	}
	
	public Locomotiva(String marca, double peso, double lunghezza, Colore colore,
			Integer potenzaMotore, Integer carburanteMassimo, Integer carburanteAttuale) {
		super(marca, peso, lunghezza, colore);
		this.potenzaMotore = potenzaMotore;
		this.carburanteMassimo = carburanteMassimo;
		this.carburanteAttuale = carburanteAttuale;
	}
	
	public Locomotiva() {}

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

		return com.progetto.enumerati.TipoVagoneEnum.LOCOMOTIVA.getNome();
	}

	@Override
	protected String infoAggiuntive() {

		return potenzaMotore + "KW" + " Carburante: " + carburanteAttuale + "/" + carburanteMassimo;
	}

	public String getTipoVagone() {
		return tipoVagone;
	}

	
}
