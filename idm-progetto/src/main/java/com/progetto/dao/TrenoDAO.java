package com.progetto.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.progetto.builder.ConcreteBuilder;
import com.progetto.eccezioni.TrenoIrregolareException;
import com.progetto.factory.FRFactory;
import com.progetto.model.Treno;

@Component
public class TrenoDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	ColoreDao coloredao;

	@Transactional
	public void addTreno(String stringa) {
		FRFactory frFactory = new FRFactory();
		coloredao.addColore(frFactory.getColoreCargo());
		coloredao.addColore(frFactory.getColoreLocomotiva());
		coloredao.addColore(frFactory.getColorePasseggeri());
		coloredao.addColore(frFactory.getColoreRistorante());
		ConcreteBuilder builder = new ConcreteBuilder(frFactory);
		Treno treno = new Treno();
		try {
			treno = builder.assemblaTreno(stringa);
		} catch (TrenoIrregolareException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(treno);
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

