package com.excilys.kataspoker.model;

public class Score {

	private Combinaison combinaison;
	private Carte carteHaute;
	
	public Score(Combinaison combinaison, Carte carteHaute) {
		this.combinaison = combinaison;
		this.carteHaute = carteHaute;
	}

	public Combinaison getCombinaison() {
		return combinaison;
	}
	
}
