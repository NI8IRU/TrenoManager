package com.progetto.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class ViaggioSearchRequest {

	private LocalDate dataPartenza;
	private String stazionePartenza;
	private String stazioneDestinazione;
	private String marca;
	
	public LocalDate getDataPartenza() {
		return dataPartenza;
	}
	public void setDataPartenza(LocalDate dataPartenza) {
		this.dataPartenza = dataPartenza;
	}
	
	public String getStazionePartenza() {
		return stazionePartenza;
	}
	public void setStazionePartenza(String stazionePartenza) {
		this.stazionePartenza = stazionePartenza;
	}
	public String getStazioneDestinazione() {
		return stazioneDestinazione;
	}
	public void setStazioneDestinazione(String stazioneDestinazione) {
		this.stazioneDestinazione = stazioneDestinazione;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
}
