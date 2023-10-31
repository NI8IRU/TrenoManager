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
	
	public void occupaPosto() {
		this.occupato = true;
	}
	
	public void liberaPosto() {
		this.occupato = false;
	}
	
	public boolean getStatoPosto() {
		return this.occupato;
	}
}
