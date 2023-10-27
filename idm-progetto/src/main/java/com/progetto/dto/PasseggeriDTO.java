package com.progetto.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vagone_Passeggeri")
public class PasseggeriDTO extends VagoneGenericoDTO{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private Integer numeroMassimoPasseggeri;
    private Integer numeroFinestre;
    private String colore;
    
    public PasseggeriDTO() {
    	
    }

    public PasseggeriDTO(Integer id, String stringId, Integer marca, Double peso, Double lunghezza, Integer numeroMassimoPasseggeri, String colore, Integer numeroFinestre) {
    	super(id, stringId, marca, peso, lunghezza);
        this.numeroMassimoPasseggeri = numeroMassimoPasseggeri;
        this.numeroFinestre = numeroFinestre;
        this.setColore(colore);
    }

    public Integer getNumeroMassimoPasseggeri() {
        return numeroMassimoPasseggeri;
    }

    public void setNumeroMassimoPasseggeri(Integer numeroMassimoPasseggeri) {
        this.numeroMassimoPasseggeri = numeroMassimoPasseggeri;
    }

    public Integer getNumeroFinestre() {
        return numeroFinestre;
    }

    public void setNumeroFinestre(Integer numeroFinestre) {
        this.numeroFinestre = numeroFinestre;
    }

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}
}
