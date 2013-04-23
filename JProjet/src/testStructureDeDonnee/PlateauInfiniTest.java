package testStructureDeDonnee;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import structureDeDonnee.Cellule;
import structureDeDonnee.PlateauInfini;

public class PlateauInfiniTest {
	protected PlateauInfini plateau;

	@Before
	public void setUp() throws Exception {
		plateau=new  PlateauInfini("Dossier_Teste/teste_jeu2.LIF");
	}

	@After
	public void tearDown() throws Exception {
	}

		
	
	@Test
	public void testAjouterCellule() {
		Cellule c=new Cellule(8,5, -1, true);
	assertTrue(plateau.ajouterCellule(c));
	}

	
	@Test
	public void testPlateauInfini() {
		plateau=new  PlateauInfini();
	}

	


}
