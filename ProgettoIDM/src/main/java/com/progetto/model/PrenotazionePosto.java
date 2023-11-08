package com.progetto.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.springframework.stereotype.Component;
import com.progetto.vagoni.PostoASedere;

@Entity
@Component
public class PrenotazionePosto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float prezzo;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "prenotazione_posti",
          joinColumns = @JoinColumn(name = "prenotazione_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "posto_id", referencedColumnName = "id")
	)
	private List<PostoASedere> listaPosti;
	
	public PrenotazionePosto() {
		super();
	}
	public PrenotazionePosto(float prezzo) {
		super();
		
		this.prezzo = prezzo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	public List<PostoASedere> getListaPosti() {
		return listaPosti;
	}
	public void setListaPosti(List<PostoASedere> listaPosti) {
		this.listaPosti = listaPosti;
	}
	
}
