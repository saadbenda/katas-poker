package com.excilys.kataspoker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Paquet {
	private List<Carte> cartes = new ArrayList<>();

	public Paquet() {
		for (Couleur c : Couleur.values()) {
			for (Valeur v : Valeur.values()) {
				this.cartes.add(new Carte(c, v));
			}
		}
	}
	
	public Paquet(List<Carte> cards) {
		this.cartes = cards;
	}

	public List<Carte> getCartes() {
		return cartes;
	}
	
	public void melanger() {
		Collections.shuffle(this.cartes);
	}
	
	public void trierParCouleur() {
		this.cartes.sort(Comparator.comparing(Carte::getCouleur));
	}
	
	public void trierParValeur() {
        this.cartes.sort((c1, c2) -> c1.getValeur().getOrdre() - c2.getValeur().getOrdre());
	}
	
	public List<Carte> piocher(int nb) throws NotEnoughCardsException {
		List<Carte> result = new ArrayList<>();
		
		if (nb > this.cartes.size()) {
			throw new NotEnoughCardsException();
		}
		
		for (int i = 0 ; i < nb ; i++) {
			result.add(this.cartes.remove(0));
		}
		
		return result;
	}
}
