package com.progetto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.progetto.Bean;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Utente implements Bean{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "UtenteId")
//    @MapKeyColumn(name = "type")
    private List<Treno> listaTreni = new ArrayList<>();

	private String ruolo;
//    @ManyToMany
//    @JoinTable(
//        name = "joining_utente_ruolo",
//        joinColumns = @JoinColumn(name = "id_utente"),
//        inverseJoinColumns = @JoinColumn(name = "id_ruolo")
//    )
//    private Set<Ruolo> ruoli;
}
