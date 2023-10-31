package com.progetto.factory;

import java.util.ArrayList;
import java.util.List;

import com.progetto.Colore;
import com.progetto.enumerati.ColoriEnum;
import com.progetto.tn_vagoni.TNCargo;
import com.progetto.tn_vagoni.TNLocomotiva;
import com.progetto.tn_vagoni.TNPasseggeri;
import com.progetto.tn_vagoni.TNRistorante;
import com.progetto.vagoni.PostoASedere;

public class TNFactory extends VagoneFactory {

	private Colore coloreLocomotiva = new Colore(ColoriEnum.GRIGIOSCURO.getR(), ColoriEnum.GRIGIOSCURO.getG(), ColoriEnum.GRIGIOSCURO.getB());
	private Colore colorePasseggeri = new Colore(ColoriEnum.CIANOSCURO.getR(), ColoriEnum.CIANOSCURO.getG(), ColoriEnum.CIANOSCURO.getB());
	private Colore coloreRistorante = new Colore(ColoriEnum.VERDEACQUASCURO.getR(),
			ColoriEnum.VERDEACQUASCURO.getG(), ColoriEnum.VERDEACQUASCURO.getB());
	private Colore coloreCargo = new Colore(ColoriEnum.OROSCURO.getR(), ColoriEnum.OROSCURO.getG(), ColoriEnum.OROSCURO.getB());
	
	@Override
	public String getMarca() {
		return "Trenonord";
	}


	@Override
	public TNLocomotiva creaLocomotiva() {
		return new TNLocomotiva(getMarca(), 108D, 11D, coloreLocomotiva,(Integer)5500, (Integer)4000, (Integer)0);
	}


	
	@Override
	public TNPasseggeri creaPasseggeri() {
		
		List<PostoASedere> listaposti = new ArrayList<>();
		for(int i=0; i<28; i++) {
			listaposti.add(new PostoASedere());
		}
		return new TNPasseggeri(getMarca(), 90, 9, colorePasseggeri, 70, 0, listaposti);
	}

	
	@Override
	public TNRistorante creaRistorante() {
		return new TNRistorante(getMarca(), 90, 9, coloreRistorante, "2 Stelle", "Menu..");
	}

	
	@Override
	public TNCargo creaCargo() {
		return new TNCargo(getMarca(), 90d, 9d, coloreCargo, 80, 0);
	}
	
	
//	@Override
//	public Integer getMarca() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Locomotiva creaLocomotiva() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Passeggeri creaPasseggeri() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Ristorante creaRistorante() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Cargo creaCargo() {
//		// TODO Auto-generated method stub
//		return null;
//	}



}