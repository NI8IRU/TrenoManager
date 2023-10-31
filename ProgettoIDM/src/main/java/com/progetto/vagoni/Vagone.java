package com.progetto.vagoni;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import com.progetto.Colore;

@Entity
@Table(name="Vagone")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_vagone")
public abstract class Vagone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String marca;
	private double peso;
	private double lunghezza;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Colore colore;

	public Vagone(Integer id, String marca, double peso, double lunghezza, Colore colore) {
		this.id = id;
		this.marca = marca;
		this.peso = peso;
		this.lunghezza = lunghezza;
		this.colore = colore;
	}
	
	public Vagone(String marca, double peso, double lunghezza, Colore colore) {
		this.marca = marca;
		this.peso = peso;
		this.lunghezza = lunghezza;
		this.colore = colore;
	}
	
	public Vagone() {}
	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}




	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(double lunghezza) {
		this.lunghezza = lunghezza;
	}

	public Colore getColore() {
		return colore;
	}

	public void setColore(Colore colore) {
		this.colore = colore;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return tipoVagone() + ": " + colore + " " + lunghezza + "m " + peso + "t " + infoAggiuntive();
	}

	protected abstract String tipoVagone();

	protected abstract String infoAggiuntive();

}
