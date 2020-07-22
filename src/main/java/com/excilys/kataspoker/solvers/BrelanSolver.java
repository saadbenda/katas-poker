package com.excilys.kataspoker.solvers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.excilys.kataspoker.model.Carte;
import com.excilys.kataspoker.model.Combinaison;
import com.excilys.kataspoker.model.Main;
import com.excilys.kataspoker.model.Score;
import com.excilys.kataspoker.model.Valeur;

public class BrelanSolver {
	public static Score calcul(Main main) {
		Map<Valeur, List<Carte>> groupe = main.getCartes().stream().collect(Collectors.groupingBy(Carte::getValeur));

		List<List<Carte>> filtrerPar2 = groupe.values().stream().filter(l -> l.size() == 2).collect(Collectors.toList());
		List<List<Carte>> filtrerPar3 = groupe.values().stream().filter(l -> l.size() == 3).collect(Collectors.toList());
		
		if (!filtrerPar3.isEmpty() && filtrerPar3.size() == 1  && filtrerPar2.isEmpty()) {
			return new Score(Combinaison.BRELAN, filtrerPar3.get(0).get(0));
		}
		
		return new Score(Combinaison.AUTRE, main.getCartes().get(main.getCartes().size() - 1));
	}
}
