package com.progetto.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.progetto.Colore;
import com.progetto.enumerati.ColoriEnum;
import com.progetto.fr_vagoni.FRCargo;
import com.progetto.fr_vagoni.FRLocomotiva;
import com.progetto.fr_vagoni.FRPasseggeri;
import com.progetto.fr_vagoni.FRRistorante;
import com.progetto.vagoni.PostoASedere;



@Component
public class FRFactory extends VagoneFactory {

	private Colore coloreLocomotiva = new Colore(ColoriEnum.GRIGIOSCURO.getNome(), ColoriEnum.GRIGIOSCURO.getR(), ColoriEnum.GRIGIOSCURO.getG(), ColoriEnum.GRIGIOSCURO.getB());
	private Colore colorePasseggeri = new Colore(ColoriEnum.CIANOSCURO.getNome(), ColoriEnum.CIANOSCURO.getR(), ColoriEnum.CIANOSCURO.getG(), ColoriEnum.CIANOSCURO.getB());
	private Colore coloreRistorante = new Colore(ColoriEnum.VERDEACQUASCURO.getNome(), ColoriEnum.VERDEACQUASCURO.getR(),
			ColoriEnum.VERDEACQUASCURO.getG(), ColoriEnum.VERDEACQUASCURO.getB());
	private Colore coloreCargo = new Colore(ColoriEnum.OROSCURO.getNome(), ColoriEnum.OROSCURO.getR(), ColoriEnum.OROSCURO.getG(), ColoriEnum.OROSCURO.getB());
	
	
	@Override
	public String getMarca() {
		return "Frecciarossa";
	}

	

	@Override
	public FRLocomotiva creaLocomotiva() {
		return new FRLocomotiva(getMarca(), 108, 11, coloreLocomotiva,5500, 4000, 0);
	}

	@Override
	public FRPasseggeri creaPasseggeri() {
		List<PostoASedere> listaposti = new ArrayList<>();
		for(int i=0; i<20; i++) {
			listaposti.add(new PostoASedere());
		}
		
		return new FRPasseggeri(getMarca(), 90, 9,
				colorePasseggeri,
				70, 0, listaposti);
	}

	@Override
	public FRRistorante creaRistorante() {
		return new FRRistorante(getMarca(), 90, 9, coloreRistorante, "2 Stelle", "Menu..");
	}

	@Override
	public FRCargo creaCargo() {
		return new FRCargo(getMarca(), 90, 9,
				coloreCargo, 80, 0);
	}
	
}

