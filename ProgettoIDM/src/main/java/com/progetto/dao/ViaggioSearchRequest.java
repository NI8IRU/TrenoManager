package com.progetto.dao;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class ViaggioSearchRequest {

	private LocalDateTime dataPartenza;
	private LocalDateTime dataArrivo;
	private String stazionePartenza;
	private String stazioneDestinazione;
	
	public LocalDateTime getDataPartenza() {
		return dataPartenza;
	}
	public void setDataPartenza(LocalDateTime dataPartenza) {
		this.dataPartenza = dataPartenza;
	}
	public LocalDateTime getDataArrivo() {
		return dataArrivo;
	}
	public void setDataArrivo(LocalDateTime dataArrivo) {
		this.dataArrivo = dataArrivo;
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
	
	
}
