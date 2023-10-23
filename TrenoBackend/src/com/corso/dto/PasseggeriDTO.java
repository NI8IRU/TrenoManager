package com.corso.dto;

public class PasseggeriDTO extends VagoneGenericoDTO{

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
