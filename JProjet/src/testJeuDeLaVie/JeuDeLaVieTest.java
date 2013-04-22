package testJeuDeLaVie;

import jeuDeLaVie.JeuDeLaVie;
import structureDeDonnee.PlateauInfini;

public class JeuDeLaVieTest {
	JeuDeLaVie jeux;

	public void setUp() throws Exception {
		jeux = new JeuDeLaVie(new PlateauInfini("Dossier_Teste/teste_jeu.LIF"));
	}

}
