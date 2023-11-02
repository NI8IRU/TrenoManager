package com.progetto.dao;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.progetto.builder.ConcreteBuilder;
import com.progetto.eccezioni.TrenoIrregolareException;
import com.progetto.eccezioni.TrenoUniversalException;
import com.progetto.factory.FRFactory;
import com.progetto.factory.TNFactory;
import com.progetto.model.Treno;
import com.progetto.model.Utente;
import com.progetto.service.UtenteService;

@Component
public class TrenoDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	UtenteService utenteservice;
	
	@Autowired 
	HttpSession session;
	
	@Autowired
	ColoreDao coloredao;

	@Transactional
	public void addTrenoFR(String stringa) throws TrenoUniversalException {
		FRFactory frFactory = new FRFactory();
		
		ConcreteBuilder builder = new ConcreteBuilder(frFactory);
		Treno treno = new Treno();
		try {
			treno = builder.assemblaTreno(stringa);
		} catch (TrenoIrregolareException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(treno);
		
		for(int i=0; i<treno.getTreno().size(); i++) {
			coloredao.addColore(treno.getTreno().get(i).getColore());
		}
		
		Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato");
//		utenteLoggato.getListaTreni().add(treno);
//		utenteservice.updateUtente(utenteLoggato);
		Utente utenteStaccato = utenteservice.getUtenteById(utenteLoggato.getId());
	    utenteStaccato.getListaTreni().add(treno);
	    utenteservice.updateUtente(utenteStaccato);
		hibernateTemplate.save(treno);
	}
	
	@Transactional
	public void addTrenoTN(String stringa) throws TrenoUniversalException {
		TNFactory tnFactory = new TNFactory();
		
		ConcreteBuilder builder = new ConcreteBuilder(tnFactory);
		Treno treno = new Treno();
		try {
			treno = builder.assemblaTreno(stringa);
		} catch (TrenoIrregolareException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(treno);
		for(int i=0; i<treno.getTreno().size(); i++) {
			coloredao.addColore(treno.getTreno().get(i).getColore());
		}
		
		Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato");
//		utenteLoggato.getListaTreni().add(treno);
//		utenteservice.updateUtente(utenteLoggato);
		Utente utenteStaccato = utenteservice.getUtenteById(utenteLoggato.getId());
	    utenteStaccato.getListaTreni().add(treno);
	    utenteservice.updateUtente(utenteStaccato);
		hibernateTemplate.save(treno);
	}
	
	
//	@Transactional
//	public void addTreno(TrenoDTO treno) {
//		hibernateTemplate.save(treno);
//	}

	public List<Treno> getAllTreno() {
		return hibernateTemplate.loadAll(Treno.class);
	}

	@Transactional
	public Treno getTrenoById(Long id) {
		Treno treno= hibernateTemplate.get(Treno.class, id);
		return treno;
	}

	@Transactional
	public void updateTreno(Treno treno) {
		hibernateTemplate.update(treno);
	}

	@Transactional
	public void deleteTreno(Long id) {
		hibernateTemplate.delete(hibernateTemplate.load(Treno.class, id));
	}
}

