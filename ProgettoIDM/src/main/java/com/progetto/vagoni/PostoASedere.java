package com.progetto.vagoni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PostoASedere {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private boolean occupato = false;
	private final float prezzo = 8.5f;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isOccupato() {
		return occupato;
	}

	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}

	public void occupaPosto() {
		this.occupato = true;
	}
	
	public void liberaPosto() {
		this.occupato = false;
	}
	
	public boolean getStatoPosto() {
		return this.occupato;
	}

	public float getPrezzo() {
		return prezzo;
	}

	
	
}
