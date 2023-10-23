package com.corso.dto;

import java.sql.Date;

public class TrenoDTO {
	private Integer id;
    private Integer marca;
    private Integer idUtente;
    private String composizioneTrenoString;
    private Date dataCreazione;
    
    public TrenoDTO() {
    	
    }
    

    

    public TrenoDTO(Integer id, Integer marca, Integer idUtente, String composizioneTrenoString, Date dataCreazione) {
		super();
		this.id = id;
		this.marca = marca;
		this.idUtente = idUtente;
		this.composizioneTrenoString = composizioneTrenoString;
		this.dataCreazione = dataCreazione;
	}
    
	public Integer getMarca() {
		return marca;
	}

	public void setMarca(Integer marca) {
		this.marca = marca;
	}

	public Integer getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}

	public String getComposizioneTrenoString() {
		return composizioneTrenoString;
	}

	public void setComposizioneTrenoString(String composizioneTrenoString) {
		this.composizioneTrenoString = composizioneTrenoString;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
