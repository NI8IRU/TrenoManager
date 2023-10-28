package com.backend.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Colore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer r;
	private Integer g;
	private Integer b;
	
	@OneToMany(mappedBy = "coloreId")
	private Set<Locomotiva> locomotiva;
	@OneToMany(mappedBy = "coloreId")
	private Set<Passeggeri> passeggeri;
	@OneToMany(mappedBy = "coloreId")
	private Set<Ristorante> ristorante;
	@OneToMany(mappedBy = "coloreId")
	private Set<Cargo> cargo;
	
	

	public Set<Locomotiva> getLocomotiva() {
		return locomotiva;
	}

	public void setLocomotiva(Set<Locomotiva> locomotiva) {
		this.locomotiva = locomotiva;
	}

	public Set<Passeggeri> getPasseggeri() {
		return passeggeri;
	}

	public void setPasseggeri(Set<Passeggeri> passeggeri) {
		this.passeggeri = passeggeri;
	}

	public Set<Ristorante> getRistorante() {
		return ristorante;
	}

	public void setRistorante(Set<Ristorante> ristorante) {
		this.ristorante = ristorante;
	}

	public Set<Cargo> getCargo() {
		return cargo;
	}

	public void setCargo(Set<Cargo> cargo) {
		this.cargo = cargo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getR() {
		return r;
	}

	public void setR(Integer r) {
		this.r = r;
	}

	public Integer getG() {
		return g;
	}

	public void setG(Integer g) {
		this.g = g;
	}

	public Integer getB() {
		return b;
	}

	public void setB(Integer b) {
		this.b = b;
	}

}