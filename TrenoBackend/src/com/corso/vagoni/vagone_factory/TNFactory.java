package com.corso.vagoni.vagone_factory;

import com.corso.Colore;
import com.corso.enumerati.ColoriEnum;
import com.corso.vagoni.Cargo;
import com.corso.vagoni.Locomotiva;
import com.corso.vagoni.Passeggeri;
import com.corso.vagoni.Ristorante;
import com.corso.vagoni.tn_vagoni.TNCargo;
import com.corso.vagoni.tn_vagoni.TNLocomotiva;
import com.corso.vagoni.tn_vagoni.TNPasseggeri;
import com.corso.vagoni.tn_vagoni.TNRistorante;

public class TNFactory extends VagoneFactory {

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
//		return "Trenonord";
//	}
//
//	@Override
//	public TNLocomotiva creaLocomotiva() {
//		return new TNLocomotiva("H", getMarca(), 108, 11,
//				new Colore(ColoriEnum.GRIGIOSCURO.getR(), ColoriEnum.GRIGIOSCURO.getG(), ColoriEnum.GRIGIOSCURO.getB()),
//				5500, 4000, 0);
//	}
//
//	@Override
//	public TNPasseggeri creaPasseggeri() {
//		return new TNPasseggeri("P", getMarca(), 90, 9,
//				new Colore(ColoriEnum.CIANOSCURO.getR(), ColoriEnum.CIANOSCURO.getG(), ColoriEnum.CIANOSCURO.getB()),
//				70, 0);
//	}
//
//	@Override
//	public TNRistorante creaRistorante() {
//		return new TNRistorante("R", getMarca(), 90, 9, new Colore(ColoriEnum.VERDEACQUASCURO.getR(),
//				ColoriEnum.VERDEACQUASCURO.getG(), ColoriEnum.VERDEACQUASCURO.getB()), "2 Stelle", "Menu..");
//	}
//
//	@Override
//	public TNCargo creaCargo() {
//		return new TNCargo("C", getMarca(), 90, 9,
//				new Colore(ColoriEnum.OROSCURO.getR(), ColoriEnum.OROSCURO.getG(), ColoriEnum.OROSCURO.getB()), 80, 0);
//	}

}
