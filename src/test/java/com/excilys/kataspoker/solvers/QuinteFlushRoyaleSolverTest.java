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

public class QuinteFlushRoyaleSolverTest {
	
	@Test
	public void should_find_quinte_flush_royale() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.AS));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.VALET));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DAME));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.ROI));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DIX));
		
		try {
			assertEquals(Combinaison.QUINTE_FLUSH_ROYALE, QuinteFlushRoyaleSolver.calcul(main).getCombinaison());
		} catch (NotEnoughCardsException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void should_not_find_quinte_flush_royale_because_suite() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.QUATRE));
		main.getCartes().add(new Carte(Couleur.PIQUE, Valeur.CINQ));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.SIX));
		
		try {
			assertNotEquals(Combinaison.QUINTE_FLUSH_ROYALE, QuinteFlushRoyaleSolver.calcul(main).getCombinaison());
		} catch (NotEnoughCardsException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void should_find_not_find_quinte_flush_royale_because_couleur() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.QUATRE));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.CINQ));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DIX));
		
		try {
			assertNotEquals(Combinaison.QUINTE_FLUSH_ROYALE, QuinteFlushRoyaleSolver.calcul(main).getCombinaison());
		} catch (NotEnoughCardsException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void should_find_not_find_quinte_flush_royale_because_not_royale() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.QUATRE));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.CINQ));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.SIX));
		
		try {
			assertNotEquals(Combinaison.QUINTE_FLUSH_ROYALE, QuinteFlushRoyaleSolver.calcul(main).getCombinaison());
		} catch (NotEnoughCardsException e) {
			fail(e.getMessage());
		}
	}
	
	
	
}
