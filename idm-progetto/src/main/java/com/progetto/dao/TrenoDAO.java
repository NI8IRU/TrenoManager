package com.progetto.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.progetto.builder.ConcreteBuilder;
import com.progetto.dto.TrenoDTO;
import com.progetto.eccezioni.TrenoIrregolareException;
import com.progetto.factory.FRFactory;
import com.progetto.model.Treno;

@Component
public class TrenoDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public void addTreno(String stringa) {
		FRFactory frFactory = new FRFactory();
		ConcreteBuilder builder = new ConcreteBuilder(frFactory);
		Treno treno = new Treno();
		try {
			treno = builder.assemblaTreno("HPRPP");
		} catch (TrenoIrregolareException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		hibernateTemplate.save(treno);
	}
	
//	@Transactional
//	public void addTreno(TrenoDTO treno) {
//		hibernateTemplate.save(treno);
//	}

	public List<TrenoDTO> getAllTreno() {
		return hibernateTemplate.loadAll(TrenoDTO.class);
	}

	@Transactional
	public TrenoDTO getTrenoById(Long id) {
		TrenoDTO treno= hibernateTemplate.get(TrenoDTO.class, id);
		return treno;
	}

	@Transactional
	public void updateTreno(TrenoDTO treno) {
		hibernateTemplate.update(treno);
	}

	@Transactional
	public void deleteTreno(Long id) {
		hibernateTemplate.delete(hibernateTemplate.load(TrenoDTO.class, id));
	}
}

