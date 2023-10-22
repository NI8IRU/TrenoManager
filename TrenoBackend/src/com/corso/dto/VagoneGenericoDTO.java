package com.corso.dto;

public abstract class VagoneGenericoDTO {

    private Integer id;
    private String stringId;
    private Integer marca;
    private Double peso;
    private Double lunghezza;
    
	public VagoneGenericoDTO(Integer id, String stringId, Integer marca, Double peso, Double lunghezza) {
		this.id = id;
		this.stringId = stringId;
		this.marca = marca;
		this.peso = peso;
		this.lunghezza = lunghezza;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStringId() {
		return stringId;
	}

	public void setStringId(String stringId) {
		this.stringId = stringId;
	}

	public Integer getMarca() {
		return marca;
	}

	public void setMarca(Integer marca) {
		this.marca = marca;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(Double lunghezza) {
		this.lunghezza = lunghezza;
	}
    
}
