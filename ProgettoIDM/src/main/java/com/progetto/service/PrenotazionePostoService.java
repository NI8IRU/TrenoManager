package com.progetto.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progetto.dao.PrenotazionePostoDao;
import com.progetto.model.PrenotazionePosto;
import com.progetto.vagoni.PostoASedere;


@Service
public class PrenotazionePostoService {

	@Autowired 
	PrenotazionePostoDao prenotazioneDao;
	
	public Long addPrenotazione(PrenotazionePosto prenotazione, String[] listaposti) {	
		return prenotazioneDao.addPrenotazione(prenotazione, listaposti);
		
	}
	
	public PrenotazionePosto findPrenotazioneById(Long id) {
		return prenotazioneDao.findPrenotazioneById(id);
	}
	
	public List<PrenotazionePosto> findPrenotazioniByViaggioId(Long id) {
		return prenotazioneDao.findPrenotazioniByViaggioId(id);
	}
	
	public List<PostoASedere> findPostiByPrenotazioneId(Long idPrenotazione) {
		return prenotazioneDao.findPostiByPrenotazioneId(idPrenotazione);
	}
}
