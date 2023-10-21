package com.corso.treno;

import com.corso.vagoni.Vagone;
import com.corso.vagoni.vagone_factory.VagoneFactory;

public class ConcreteBuilder extends TrenoBuilder {

	VagoneFactory vf;

	public ConcreteBuilder(VagoneFactory vf) {
		this.vf = vf;
	}

	@Override
	protected String getMarca() {
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
