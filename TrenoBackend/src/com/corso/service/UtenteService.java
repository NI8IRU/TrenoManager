package com.corso.service;


import java.util.List;

import com.corso.dao.Bean;
import com.corso.dao.UtenteDAO;
import com.corso.dao.UtenteDAOImpl;
import com.corso.dto.TrenoDTO;
import com.corso.utente.Utente;


public class UtenteService {
	
	private UtenteDAO dao = new UtenteDAOImpl();

	public void creaAdmin(String username, String password,  List<TrenoDTO> listaTreni) {
		Integer id = dao.createAdmin(username, password, listaTreni);
		System.out.println("Creatol'admin con id: " + id);
	}
	
	public void creaUtente(String username, String password,  List<TrenoDTO> listaTreni) {
		Integer id = dao.createUtente(username, password, listaTreni);
		System.out.println("Creatol'utente con id: " + id);
	}
	
	public void update(Utente utente) {
		dao.update(utente);
		System.out.println("modificato l'utente con id: " + utente.getId());
	}
	
	public void delete(Utente utente) {
		dao.delete(utente);
		System.out.println("L'utente: " + utente + " è stato correttamente eliminato");
	}
	//commento
	public Utente findById(int id) {
		System.out.println("L'utente con id" + id + "è stato trovato");
		return dao.findById(id);
		
	}
	public Utente findByUsername(String username) {
		System.out.println("L'utente con username" + username + "è stato trovato");
		return dao.findUtenteByUsername(username);
	}
	
	public List<Bean> findAll(String classe){
		return dao.findAll(classe);
	}
}
