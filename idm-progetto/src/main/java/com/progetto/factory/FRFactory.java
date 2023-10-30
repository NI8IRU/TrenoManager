package com.progetto.factory;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.progetto.Colore;
import com.progetto.dao.ColoreDao;
import com.progetto.enumerati.ColoriEnum;
import com.progetto.fr_vagoni.FRCargo;
import com.progetto.fr_vagoni.FRLocomotiva;
import com.progetto.fr_vagoni.FRPasseggeri;
import com.progetto.fr_vagoni.FRRistorante;
import com.progetto.service.ColoreService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class FRFactory extends VagoneFactory {

	private Colore coloreLocomotiva = new Colore(ColoriEnum.GRIGIOSCURO.getR(), ColoriEnum.GRIGIOSCURO.getG(), ColoriEnum.GRIGIOSCURO.getB());
	private Colore colorePasseggeri = new Colore(ColoriEnum.CIANOSCURO.getR(), ColoriEnum.CIANOSCURO.getG(), ColoriEnum.CIANOSCURO.getB());
	private Colore coloreRistorante = new Colore(ColoriEnum.VERDEACQUASCURO.getR(),
			ColoriEnum.VERDEACQUASCURO.getG(), ColoriEnum.VERDEACQUASCURO.getB());
	private Colore coloreCargo = new Colore(ColoriEnum.OROSCURO.getR(), ColoriEnum.OROSCURO.getG(), ColoriEnum.OROSCURO.getB());
	
	
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
		return new FRPasseggeri(getMarca(), 90, 9,
				colorePasseggeri,
				70, 0);
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

