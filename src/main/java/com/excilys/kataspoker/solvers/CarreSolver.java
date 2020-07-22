package com.excilys.kataspoker.solvers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.excilys.kataspoker.model.Carte;
import com.excilys.kataspoker.model.Combinaison;
import com.excilys.kataspoker.model.Main;
import com.excilys.kataspoker.model.Score;
import com.excilys.kataspoker.model.Valeur;

public class CarreSolver {
	public static Score calcul(Main main) {
		Map<Valeur, List<Carte>> groupe = main.getCartes().stream().collect(Collectors.groupingBy(Carte::getValeur));
		
		List<List<Carte>> filtre = groupe.values().stream().filter(l -> l.size() == 4).collect(Collectors.toList());
		
		if (filtre.size() == 1 ) {
			return new Score(Combinaison.CARRE, filtre.get(0).get(0));
		}
		
		return new Score(Combinaison.AUTRE, main.getCartes().get(main.getCartes().size() - 1));
	}
}
