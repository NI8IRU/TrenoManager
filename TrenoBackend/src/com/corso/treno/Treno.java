package com.corso.treno;

import java.util.ArrayList;
import java.util.List;

import com.corso.dao.Bean;
import com.corso.vagoni.Vagone;

public class Treno implements Bean{

	private Integer id;
	private Integer marca;
	private List<Vagone> treno;

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

	public Integer getMarca() {
		return marca;
	}

	public void setMarca(Integer marca) {
		this.marca = marca;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
