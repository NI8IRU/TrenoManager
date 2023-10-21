package com.corso.treno;

import java.util.ArrayList;
import java.util.List;
import com.corso.vagoni.Vagone;

public class Treno {

	private String marca;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
