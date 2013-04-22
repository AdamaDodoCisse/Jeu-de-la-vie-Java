package testStructureDeDonnee;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import structureDeDonnee.PlateauCirculaire;


public class PlateauCirculaireTest {

	protected PlateauCirculaire structure;
	@Before
	public void setUp() throws Exception {
		structure = new PlateauCirculaire("Dossier_Teste/teste_jeu2.LIF");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNombreVoisin() {
		
	}

}
