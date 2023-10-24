package com.corso.dto;

import java.sql.Date;

import com.corso.dao.Bean;

public class TrenoDTO implements Bean{
	private Integer id;
    private Integer marca;
    private String composizioneTrenoString;
    private Date dataCreazione;
    
    public TrenoDTO() {
    	
    }
    

    

    public TrenoDTO(Integer id, Integer marca, Integer idUtente, String composizioneTrenoString, Date dataCreazione) {
		super();
		this.id = id;
		this.marca = marca;
		this.composizioneTrenoString = composizioneTrenoString;
		this.dataCreazione = dataCreazione;
	}
    
	public Integer getMarca() {
		return marca;
	}

	public void setMarca(Integer marca) {
		this.marca = marca;
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
