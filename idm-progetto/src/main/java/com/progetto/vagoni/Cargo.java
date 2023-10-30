package com.progetto.vagoni;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.progetto.Colore;

@Entity
@DiscriminatorValue("VAGONE_CARGO")
public class Cargo extends Vagone {

	private Integer numeroMassimoPacchi;
	private Integer numeroPacchi;

	public Cargo(Integer id, String marca, double peso, double lunghezza, Colore colore,
			Integer numeroMassimoPacchi, Integer numeroPacchi) {
		super(id, marca, peso, lunghezza, colore);
		this.numeroMassimoPacchi = numeroMassimoPacchi;
		this.numeroPacchi = numeroPacchi;
	}

	public Cargo(String marca, double peso, double lunghezza, Colore colore,
			Integer numeroMassimoPacchi, Integer numeroPacchi) {
		super(marca, peso, lunghezza, colore);
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
		return com.progetto.enumerati.TipoVagoneEnum.CARGO.getNome();
	}

	@Override
	protected String infoAggiuntive() {
		return "Carico: " + numeroPacchi + "/" + numeroMassimoPacchi + "t";
	}

}
