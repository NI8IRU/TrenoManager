package com.corso.dao;

import java.util.List;

import com.corso.treno.Treno;
import com.corso.utente.Ruolo;
import com.corso.utente.Utente;

public interface UtenteDAO {
	
	public Integer createAdmin(String username, String password,  List<Treno> listaTreni);
	public Integer createUtente(String username, String password,  List<Treno> listaTreni);
	public void update(Utente bean);
	public void delete(Utente bean);
	public Utente findById(Integer id);
	public Utente findUtenteByUsername(String username);
	public Ruolo findRuoloByTipoRuolo(String ruolo);
}
