package com.corso.utente;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.corso.treno.Treno;
import com.corso.dao.Bean;

public class Utente implements Bean{
	
	private int id;
	private String username;
	private String password;
	private List<Treno> listaTreni;
	private Set<Ruolo> ruoli = new HashSet<>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Treno> getListaTreni() {
		return listaTreni;
	}
	public void setListaTreni(List<Treno> listaTreni) {
		this.listaTreni = listaTreni;
	}
	public Set<Ruolo> getRuoli() {
		return ruoli;
	}
	public void setRuoli(Set<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}
	
	
	
	public Utente() {
		super();
	}
	public Utente(String username, String password, Set<Ruolo> ruoli) {
		super();
		this.username = username;
		this.password = password;
		this.ruoli = ruoli;
	}
	
	public Utente(String username, String password, Set<Ruolo> ruoli, List<Treno> listaTreni) {
		super();
		this.username = username;
		this.password = password;
		this.ruoli = ruoli;
		this.listaTreni = listaTreni;
	}
//	@Override
//	public String toString() {
//		return "Utente [id=" + id + ", username=" + username + ", password=" + password + ", listaTreni=" + listaTreni
//				+ ", ruoli=" + getRuoli() + "]";
//	}
	
	
	
}
