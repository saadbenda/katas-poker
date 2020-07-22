package com.excilys.kataspoker.solvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.excilys.kataspoker.model.Carte;
import com.excilys.kataspoker.model.Combinaison;
import com.excilys.kataspoker.model.Couleur;
import com.excilys.kataspoker.model.Main;
import com.excilys.kataspoker.model.Valeur;

public class CarreSolverTest {
	
	@Test
	public void should_find_carre() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.PIQUE, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.HUIT));
		
		assertEquals(Combinaison.CARRE, CarreSolver.calcul(main).getCombinaison());
	}
	
	@Test
	public void should_not_find_carre_because_high_card() {
		Main main = new Main();
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.TROIS));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.QUATRE));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.CINQ));
		main.getCartes().add(new Carte(Couleur.CARREAU, Valeur.HUIT));
		
		assertNotEquals(Combinaison.CARRE, CarreSolver.calcul(main).getCombinaison());
	}

}
