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

import lombok.Data;

@Data
@Entity
public class Treno {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String marca;
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "TrenoId")
	private List<Vagone> treno = new ArrayList<>();

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