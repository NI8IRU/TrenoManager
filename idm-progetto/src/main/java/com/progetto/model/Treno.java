package com.progetto.model;

import java.util.ArrayList;
import java.util.List;

import com.progetto.vagoni.Vagone;

import lombok.Data;

@Data
public class Treno {

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

}
