package com.progetto.factory;

import com.progetto.vagoni.Cargo;
import com.progetto.vagoni.Locomotiva;
import com.progetto.vagoni.Passeggeri;
import com.progetto.vagoni.Ristorante;

public abstract class VagoneFactory {

	public abstract String getMarca();

	public abstract Locomotiva creaLocomotiva();

	public abstract Passeggeri creaPasseggeri();

	public abstract Ristorante creaRistorante();

	public abstract Cargo creaCargo();
}
