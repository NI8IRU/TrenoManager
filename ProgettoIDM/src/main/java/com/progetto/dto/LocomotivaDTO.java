package com.progetto.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Locomotiva")
public class LocomotivaDTO extends VagoneGenericoDTO{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private Integer potenzaMotore;
    private Integer carburanteMassimo;
    private String colore;
    
    public LocomotivaDTO(){
    	
    }

    public LocomotivaDTO(Integer id, String stringId, Integer marca, Double peso, Double lunghezza, Integer potenzaMotore, Integer carburanteMassimo, String colore) {
    	super(id, stringId, marca, peso, lunghezza);
        this.potenzaMotore = potenzaMotore;
        this.carburanteMassimo = carburanteMassimo;
        this.colore = colore;
    }

    public Integer getPotenzaMotore() {
        return potenzaMotore;
    }

    public void setPotenzaMotore(Integer potenzaMotore) {
        this.potenzaMotore = potenzaMotore;
    }

    public Integer getCarburanteMassimo() {
        return carburanteMassimo;
    }

    public void setCarburanteMassimo(Integer carburanteMassimo) {
        this.carburanteMassimo = carburanteMassimo;
    }

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}
}
