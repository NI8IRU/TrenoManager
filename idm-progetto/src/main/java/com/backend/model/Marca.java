package com.backend.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sigla;

	@OneToMany(mappedBy = "marcaId")
	private Set<Locomotiva> locomotiva;
	@OneToMany(mappedBy = "marcaId")
	private Set<Passeggeri> passeggeri;
	@OneToMany(mappedBy = "marcaId")
	private Set<Ristorante> ristorante;
	@OneToMany(mappedBy = "marcaId")
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
