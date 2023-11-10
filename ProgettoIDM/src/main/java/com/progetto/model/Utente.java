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

import org.springframework.stereotype.Component;

import com.progetto.Bean;


@Component
@Entity
public class Utente implements Bean{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String nome;
	private String nazione;
	private String codiceFiscale;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	
	
}
