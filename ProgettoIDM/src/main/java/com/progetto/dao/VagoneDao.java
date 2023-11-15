package com.progetto.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.progetto.vagoni.Vagone;

@Component
public class VagoneDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public Vagone findVagoneById(Long id) {
		return hibernateTemplate.get(Vagone.class, id);
	}
}
