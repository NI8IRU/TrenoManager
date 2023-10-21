package com.corso.enumerati;

public enum ColoriEnum {

	GRIGIOSCURO("Grigio Scuro", 169, 169, 169),
	OROSCURO("Oro Scuro", 184, 134, 11),
	CIANOSCURO("Ciano Scuro", 0, 139, 139),
	VERDEACQUASCURO("Verde Acqua Scuro", 143, 188, 143);

	private String nome;
	private int R;
	private int G;
	private int B;

	private ColoriEnum(String nome, int r, int g, int b) {
		this.nome = nome;
		R = r;
		G = g;
		B = b;
	}

	public String getNome() {
		return nome;
	}

	public int getR() {
		return R;
	}

	public int getG() {
		return G;
	}

	public int getB() {
		return B;
	}

}
