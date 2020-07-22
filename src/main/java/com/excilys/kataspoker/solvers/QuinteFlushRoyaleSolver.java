package com.excilys.kataspoker.solvers;

import java.util.stream.Collectors;

import com.excilys.kataspoker.model.Carte;
import com.excilys.kataspoker.model.Combinaison;
import com.excilys.kataspoker.model.Main;
import com.excilys.kataspoker.model.NotEnoughCardsException;
import com.excilys.kataspoker.model.Score;
import com.excilys.kataspoker.model.Valeur;

public class QuinteFlushRoyaleSolver {

	public static Score calcul(Main main) throws NotEnoughCardsException {
		if (main.getCartes().size() < 5) {
			throw new NotEnoughCardsException();
		}
		
		main.trierParValeur();
		boolean allSameColor = main.getCartes().stream().collect(Collectors.groupingBy(Carte::getCouleur)).keySet().size() == 1;
		
		if (allSameColor && main.getCartes().get(0).getValeur().equals(Valeur.DIX) && main.getCartes().get(4).getValeur().getOrdre() == (main.getCartes().get(0).getValeur().getOrdre() + 4)) {
			return new Score(Combinaison.QUINTE_FLUSH_ROYALE, main.getCartes().get(0));
		}
		
		return new Score(Combinaison.AUTRE, main.getCartes().get(main.getCartes().size() - 1));
	}
}
