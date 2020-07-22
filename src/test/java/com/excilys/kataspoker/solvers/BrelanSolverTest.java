package com.excilys.kataspoker.solvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.excilys.kataspoker.model.Carte;
import com.excilys.kataspoker.model.Combinaison;
import com.excilys.kataspoker.model.Couleur;
import com.excilys.kataspoker.model.Main;
import com.excilys.kataspoker.model.Valeur;

public class BrelanSolverTest {
	
	@Test
	public void should_find_brelan() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.CINQ));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.HUIT));
		
		assertEquals(Combinaison.BRELAN, BrelanSolver.calcul(main).getCombinaison());
	}
	
	@Test
	public void should_not_find_brelan_because_other() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.QUATRE));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.CINQ));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.HUIT));
		
		assertNotEquals(Combinaison.BRELAN, BrelanSolver.calcul(main).getCombinaison());
	}
	
	@Test
	public void should_not_find_brelan_because_full() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.TROIS));
		
		assertNotEquals(Combinaison.BRELAN, BrelanSolver.calcul(main).getCombinaison());
	}
	
	@Test
	public void should_not_find_brelan_because_carre() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.PIQUE, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.TROIS));
		
		assertNotEquals(Combinaison.BRELAN, BrelanSolver.calcul(main).getCombinaison());
	}

}
