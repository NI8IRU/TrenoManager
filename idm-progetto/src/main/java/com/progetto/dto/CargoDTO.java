package com.progetto.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vagone_Cargo")
public class CargoDTO extends VagoneGenericoDTO{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private Integer numeroMassimoPacchi;
    private String colore;

    public CargoDTO() {
    	
    }
    
    public CargoDTO(Integer id, String stringId, Integer marca, Double peso, Double lunghezza, Integer numeroMassimoPacchi, String colore) {
    	super(id, stringId, marca, peso, lunghezza);
        this.numeroMassimoPacchi = numeroMassimoPacchi;
        this.colore = colore;
    }

    public Integer getNumeroMassimoPacchi() {
        return numeroMassimoPacchi;
    }

    public void setNumeroMassimoPacchi(Integer numeroMassimoPacchi) {
        this.numeroMassimoPacchi = numeroMassimoPacchi;
    }

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}
}