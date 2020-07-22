package com.excilys.kataspoker.model;

public class Carte {

	private Couleur couleur;
	private Valeur valeur;
	
	public Carte(Couleur couleur, Valeur valeur) {
		this.couleur = couleur;
		this.valeur = valeur;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public Valeur getValeur() {
		return valeur;
	}
	
	
}
