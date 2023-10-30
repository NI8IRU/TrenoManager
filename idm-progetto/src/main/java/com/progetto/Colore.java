package com.progetto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Colore {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;

	private java.awt.Color c;

	public Colore(int R, int G, int B) {
		this.c = new java.awt.Color(R, G, B);
	}

	public int getR() {
		return c.getRed();
	}

	public int getG() {
		return c.getGreen();
	}

	public int getB() {
		return c.getBlue();
	}

	public java.awt.Color getC() {
		return c;
	}

	public void setC(java.awt.Color c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Colore [R=" + getR() + ", G=" + getG() + ", B=" + getB() + "]";
	}

}
