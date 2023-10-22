package com.corso.dto;

public class RistoranteDTO extends VagoneGenericoDTO{

    private String stelleRistorante;
    private String menu;
    private String colore;

    public RistoranteDTO(Integer id, String stringId, Integer marca, Double peso, Double lunghezza, String stelleRistorante, String menu, String colore) {
    	super(id, stringId, marca, peso, lunghezza);
        this.stelleRistorante = stelleRistorante;
        this.menu = menu;
        this.setColore(colore);
    }

    public String getStelleRistorante() {
        return stelleRistorante;
    }

    public void setStelleRistorante(String stelleRistorante) {
        this.stelleRistorante = stelleRistorante;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}
}
