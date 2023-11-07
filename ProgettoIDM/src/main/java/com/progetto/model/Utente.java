package com.progetto.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import com.progetto.Bean;



@Entity
public class Utente implements Bean{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private float saldo;
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "UtenteId")
	private List<PrenotazionePosto> listaPrenotazioni;

	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "UtenteId")
    private List<Treno> listaTreni = new ArrayList<>();
	private String ruolo;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public List<PrenotazionePosto> getListaPrenotazioni() {
		return listaPrenotazioni;
	}

	public void setListaPrenotazioni(List<PrenotazionePosto> listaPrenotazioni) {
		this.listaPrenotazioni = listaPrenotazioni;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
	
}
