package com.progetto.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.stereotype.Component;
import javax.persistence.JoinColumn;

@Entity
@Component
public class Viaggio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime dataPartenza;
    private LocalDateTime dataArrivo;
	private String stazionePartenza;
	private String stazioneDestinazione;
	
	@ManyToOne
	@JoinColumn(name = "TrenoId")
	private Treno treno;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ViaggioId")
	private List<PrenotazionePosto> listaPrenotazioni;
	
	
	
	public Viaggio() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Treno getTreno() {
		return treno;
	}
	public void setTreno(Treno treno) {
		this.treno = treno;
	}
	public List<PrenotazionePosto> getListaPrenotazioni() {
		return listaPrenotazioni;
	}
	public void setListaPrenotazioni(List<PrenotazionePosto> listaPrenotazioni) {
		this.listaPrenotazioni = listaPrenotazioni;
	}
	
	
//	public List<PostoASedere> getListaPosti() {
//		return listaPosti;
//	}
//	public void setListaPosti(List<PostoASedere> listaPosti) {
//		this.listaPosti = listaPosti;
//	}
	
	
	
	
}
