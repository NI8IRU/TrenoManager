package com.progetto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.progetto.model.PrenotazionePosto;
import com.progetto.service.PostoService;
import com.progetto.vagoni.PostoASedere;


@Component
public class PrenotazionePostoDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	PostoService postoservice;
	
	@Transactional
	public void addPrenotazione(PrenotazionePosto prenotazione, String[] listaId) {
		
		List<PostoASedere> listaPosti = new ArrayList<>();
		float prezzo = 0;
		
		for(int i=0; i<listaId.length; i++) {
			PostoASedere posto = postoservice.findPostoById(Long.parseLong(listaId[i]));
			prezzo += posto.getPrezzo();
			listaPosti.add(posto);
		}
		
		prenotazione.setListaPosti(listaPosti);
		prenotazione.setPrezzo(prezzo);
		hibernateTemplate.save(prenotazione);
		
	}

}
