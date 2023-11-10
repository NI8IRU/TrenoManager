package com.progetto.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progetto.dao.UtenteDAO;
import com.progetto.model.PrenotazionePosto;
import com.progetto.model.Utente;

@Service
@Transactional
public class UtenteService {

	@Autowired
	UtenteDAO utenteDAO;

	public void addUtente(Utente utente) {
		utenteDAO.addUtente(utente);
	}

	public List<Utente> getAllUtente() {
		return utenteDAO.getAllUtente();
	}

	public Utente getUtenteById(Long id) {
		return utenteDAO.getUtenteById(id);
	}
	
	public Utente findUtenteByUsername(String username) {
		return utenteDAO.findUtenteByUsername(username);
	}

	public void updateUtente(Utente utente) {
		utenteDAO.updateUtente(utente);
	}

	public void deleteUtente(Long id) {
		utenteDAO.deleteUtente(id);
	}
	
	public void updatePrenotazioniUtente(PrenotazionePosto prenotazione, float prezzo) {
		utenteDAO.updatePrenotazioniUtente(prenotazione, prezzo);
	}
	
	public Utente findUtenteByPrenotazioneId(Long prenotazioneId) {
		return utenteDAO.findUtenteByPrenotazioneId(prenotazioneId);
	}
}

