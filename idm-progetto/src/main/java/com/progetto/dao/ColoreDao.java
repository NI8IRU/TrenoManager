package com.progetto.dao;

import java.awt.Color;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.progetto.Colore;
import com.progetto.model.Utente;

@Component
public class ColoreDao {

	
	@Autowired
	SessionFactory factory;

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void addColore(Colore colore) {
		if(existsByRgb(colore.getC()) == null) {
			hibernateTemplate.save(colore);
		}
		
	}
	
	@Transactional
	public Colore existsByRgb(java.awt.Color colore) {

		return hibernateTemplate.get(Colore.class, colore);
		
	}

}
