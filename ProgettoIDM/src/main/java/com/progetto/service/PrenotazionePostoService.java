package com.progetto.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progetto.dao.PrenotazionePostoDao;
import com.progetto.model.PrenotazionePosto;


@Service
public class PrenotazionePostoService {

	@Autowired 
	PrenotazionePostoDao prenotazioneDao;
	
	public void addPrenotazione(PrenotazionePosto prenotazione, String[] listaposti) {	
		prenotazioneDao.addPrenotazione(prenotazione, listaposti);
		
	}
}
