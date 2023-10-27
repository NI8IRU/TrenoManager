package com.progetto.builder;

import com.progetto.factory.VagoneFactory;
import com.progetto.vagoni.Vagone;

public class ConcreteBuilder extends TrenoBuilder {

	VagoneFactory vf;

	public ConcreteBuilder(VagoneFactory vf) {
		this.vf = vf;
	}

	@Override
	protected Integer getMarca() {
		return vf.getMarca();
	}

	@Override
	protected Vagone costruisciLocomotiva() {
		return vf.creaLocomotiva();
	}

	@Override
	protected Vagone costruisciPasseggeri() {
		return vf.creaPasseggeri();
	}

	@Override
	protected Vagone costruisciRistorante() {
		return vf.creaRistorante();
	}

	@Override
	protected Vagone costruisciCargo() {
		return vf.creaCargo();
	}

}

