package com.excilys.kataspoker.solvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.excilys.kataspoker.model.Carte;
import com.excilys.kataspoker.model.Combinaison;
import com.excilys.kataspoker.model.Couleur;
import com.excilys.kataspoker.model.Main;
import com.excilys.kataspoker.model.NotEnoughCardsException;
import com.excilys.kataspoker.model.Valeur;

public class CouleurSolverTest {
	
	@Test
	public void should_find_couleur() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.QUATRE));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.CINQ));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.NEUF));
		
		try {
			assertEquals(Combinaison.COULEUR, CouleurSolver.calcul(main).getCombinaison());
		} catch (NotEnoughCardsException e) {
			fail();
		}
	}
	
	@Test
	public void should_not_find_couleur_because_suite_couleur() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.QUATRE));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.CINQ));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.SIX));
		
		try {
			assertNotEquals(Combinaison.COULEUR, CouleurSolver.calcul(main).getCombinaison());
		} catch (NotEnoughCardsException e) {
			fail();
		}
	}
	
}
