package com.corso.vagoni.vagone_factory;

import com.corso.vagoni.Cargo;
import com.corso.vagoni.Locomotiva;
import com.corso.vagoni.Passeggeri;
import com.corso.vagoni.Ristorante;

public abstract class VagoneFactory {

	public abstract Integer getMarca();

	public abstract Locomotiva creaLocomotiva();

	public abstract Passeggeri creaPasseggeri();

	public abstract Ristorante creaRistorante();

	public abstract Cargo creaCargo();
}
