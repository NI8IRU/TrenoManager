package com.progetto.enumerati;

public enum TipoVagoneEnum {

	LOCOMOTIVA("Locomotiva", "H"),
	PASSEGGERI("Passeggeri", "P"),
	RISTORANTE("Ristorante", "R"),
	CARGO("Cargo", "C");

	private String nome;
	private String id;

	private TipoVagoneEnum(String nome, String id) {
		this.nome = nome;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getId() {
		return id;
	}

}