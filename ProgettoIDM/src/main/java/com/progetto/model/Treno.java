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
import com.progetto.vagoni.Vagone;


@Entity
public class Treno {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private String tipoTreno;
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "TrenoId")
	private List<Vagone> treno = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "TrenoId")
	private List<Viaggio> listaViaggi = new ArrayList<>();
	
	
	public Treno() {
		treno = new ArrayList<>();
	}

	public List<Vagone> getTreno() {
		return treno;
	}

	public void addVagone(Vagone v) {
		treno.add(v);
	}

	public void removeVagone(Vagone v) {
		treno.remove(v);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setTreno(List<Vagone> treno) {
		this.treno = treno;
	}
	
	public List<Viaggio> getListaViaggi() {
		return listaViaggi;
	}

	public void setListaViaggi(List<Viaggio> listaViaggi) {
		this.listaViaggi = listaViaggi;
	}

	@Override
	public String toString() {
		return "Sono un treno";
	}

	public String getTipoTreno() {
		return tipoTreno;
	}

	public void setTipoTreno(String tipoTreno) {
		this.tipoTreno = tipoTreno;
	}
	
	

}
