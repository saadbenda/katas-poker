package com.excilys.kataspoker.solvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.excilys.kataspoker.model.Carte;
import com.excilys.kataspoker.model.Combinaison;
import com.excilys.kataspoker.model.Couleur;
import com.excilys.kataspoker.model.Main;
import com.excilys.kataspoker.model.Valeur;

public class DoublePaireSolverTest {
	
	@Test
	public void should_find_double_pair() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.HUIT));
		
		assertEquals(Combinaison.DOUBLE_PAIRE, DoublePaireSolver.calcul(main).getCombinaison());
	}
	
	@Test
	public void should_not_find_double_pair_because_high_card() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.QUATRE));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.CINQ));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.HUIT));
		
		assertNotEquals(Combinaison.DOUBLE_PAIRE, DoublePaireSolver.calcul(main).getCombinaison());
	}
	
	@Test
	public void should_not_find_double_pair_because_full() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.TROIS));
		
		assertNotEquals(Combinaison.DOUBLE_PAIRE, DoublePaireSolver.calcul(main).getCombinaison());
	}
	

}
