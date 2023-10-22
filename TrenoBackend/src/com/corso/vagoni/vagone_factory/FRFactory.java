package com.corso.vagoni.vagone_factory;

import com.corso.Colore;
import com.corso.enumerati.ColoriEnum;
import com.corso.vagoni.Cargo;
import com.corso.vagoni.Locomotiva;
import com.corso.vagoni.Passeggeri;
import com.corso.vagoni.Ristorante;
import com.corso.vagoni.fr_vagoni.FRCargo;
import com.corso.vagoni.fr_vagoni.FRLocomotiva;
import com.corso.vagoni.fr_vagoni.FRPasseggeri;
import com.corso.vagoni.fr_vagoni.FRRistorante;

public class FRFactory extends VagoneFactory {

	@Override
	public Integer getMarca() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Locomotiva creaLocomotiva() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Passeggeri creaPasseggeri() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ristorante creaRistorante() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cargo creaCargo() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public String getMarca() {
//		return "Frecciarossa";
//	}
//
//	@Override
//	public FRLocomotiva creaLocomotiva() {
//		return new FRLocomotiva("H", getMarca(), 108, 11,
//				new Colore(ColoriEnum.GRIGIOSCURO.getR(), ColoriEnum.GRIGIOSCURO.getG(), ColoriEnum.GRIGIOSCURO.getB()),
//				5500, 4000, 0);
//	}
//
//	@Override
//	public FRPasseggeri creaPasseggeri() {
//		return new FRPasseggeri("P", getMarca(), 90, 9,
//				new Colore(ColoriEnum.CIANOSCURO.getR(), ColoriEnum.CIANOSCURO.getG(), ColoriEnum.CIANOSCURO.getB()),
//				70, 0);
//	}
//
//	@Override
//	public FRRistorante creaRistorante() {
//		return new FRRistorante("R", getMarca(), 90, 9, new Colore(ColoriEnum.VERDEACQUASCURO.getR(),
//				ColoriEnum.VERDEACQUASCURO.getG(), ColoriEnum.VERDEACQUASCURO.getB()), "2 Stelle", "Menu..");
//	}
//
//	@Override
//	public FRCargo creaCargo() {
//		return new FRCargo("C", getMarca(), 90, 9,
//				new Colore(ColoriEnum.OROSCURO.getR(), ColoriEnum.OROSCURO.getG(), ColoriEnum.OROSCURO.getB()), 80, 0);
//	}

}
