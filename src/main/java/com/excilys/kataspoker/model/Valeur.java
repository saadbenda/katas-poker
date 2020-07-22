package com.excilys.kataspoker.model;

public enum Valeur {
	DEUX(1, "2"), 
	TROIS(2, "3"), 
	QUATRE(3, "4"), 
	CINQ(4, "5"), 
	SIX(5, "6"), 
	SEPT(6, "7"), 
	HUIT(7, "8"),
	NEUF(8, "9"),
	DIX(9, "10"),
	VALET(10, "Valet"),
	DAME(11, "Dame"),
	ROI(12, "Roi"),
	AS(13, "As");
	
	private int ordre;
	private String nom;
	
	private Valeur(int order, String nom) {
		this.ordre = order;
		this.nom = nom;
	}

	public int getOrdre() {
		return ordre;
	}

	public String getNom() {
		return nom;
	}
	
}
