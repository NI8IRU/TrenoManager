package com.progetto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progetto.dao.UtenteDAO;
import com.progetto.model.Utente;

@Service
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
}

