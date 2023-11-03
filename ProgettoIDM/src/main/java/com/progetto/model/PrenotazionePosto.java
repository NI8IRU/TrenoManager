package com.progetto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.progetto.vagoni.PostoASedere;

@Entity
public class PrenotazionePosto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PrenotazioneId")
	private List<PostoASedere> listaPosti;
	private float prezzo;
	
	
	
	public PrenotazionePosto() {
		super();
	}
	public PrenotazionePosto(List<PostoASedere> listaPosti, float prezzo) {
		super();
		this.listaPosti = listaPosti;
		this.prezzo = prezzo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<PostoASedere> getListaPosti() {
		return listaPosti;
	}
	public void setListaPosti(List<PostoASedere> listaPosti) {
		this.listaPosti = listaPosti;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	
	
	
}
