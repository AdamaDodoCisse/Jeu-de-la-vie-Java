package testStructureDeDonnee;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import structureDeDonnee.Cellule;
import structureDeDonnee.PlateauFini;

public class PlateauFiniTest {
	protected PlateauFini plateau ;

	@Before
	public void setUp() throws Exception {
		plateau=new PlateauFini("Dossier_Teste/teste_jeu2.LIF");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test public void testPlateauFini(){
		plateau=new PlateauFini();
	}
	@Test
	public void testAjouterCellule() {
		plateau.ajouterCellule(new Cellule(0, 3, -1, true));
		plateau.ajouterCellule(new Cellule(-11, 3, -1, true));
		plateau.ajouterCellule(new Cellule(0, 1000, -1, true));
		plateau.ajouterCellule(new Cellule(1000, 1000, -1, true));
		plateau.ajouterCellule(new Cellule(000, 1000, -1, true));
		plateau.ajouterCellule(new Cellule(-11, -11, -1, true));
		plateau.ajouterCellule(new Cellule(-11, 7, -1, true));
		assertEquals(plateau.getTailleCelluleVivante(),18);
	}

	@Test
	public void testAjouterRegleVie() {
		plateau.ajouterRegleVie(3);
		assertTrue(plateau.containsRegleVie(3));
	}

	@Test
	public void testAjouterRegleMort() {
		plateau.ajouterRegleMort(2);
		plateau.ajouterRegleMort(3);
		assertTrue(plateau.containsRegleMort(2));
		assertTrue(plateau.containsRegleMort(3));

	}
	

	@Test
	public void testAjouterElement() {

	}

	@Test
	public void testClone() {
		assertNotSame(plateau.clone(),plateau);
	}

	@Test
	public void testContains() {
		assertTrue(plateau.contains(new Cellule(0, 0, 3, false)));
	}

	@Test
	public void testContainsRegleMort() {
		assertTrue(plateau.containsRegleMort(2));
		assertTrue(plateau.containsRegleMort(3));
	}

	@Test
	public void testContainsRegleVie() {
		assertTrue(plateau.containsRegleMort(3));
	}

	@Test
	public void testEstVide() {
		assertFalse(plateau.estVide());;
	}

	@Test
	public void testEvoluer() {
		plateau.evoluer();
		assertEquals(plateau.getTailleCelluleVivante(),17);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testCalculerEvolution() {
		ArrayList<Cellule> it=new ArrayList<Cellule>();
		it.add(new Cellule(1, 0, -1, true));
		it.add(new Cellule(0, 0, -1, true));
		plateau.calculerEvolution(it);
		plateau.calculerEvolution((ArrayList<Cellule>)plateau.getCelluleVivante());
assertNotSame(plateau.getTailleCelluleVivante(),it.size());

	}

	@Test
	public void testGetCellule() {
		Cellule c=new Cellule(0, 0, -1, true);
		assertEquals(plateau.getCellule(0), c);
	}

	@Test
	public void testGetCelluleVivante() {
		Iterator<Cellule> it=plateau.getIterateurCellule();
		int i=0;
		while(it.hasNext()){
			assertTrue(plateau.getCellule(i).equals(it.next()));
			i++;
		}
		assertEquals(plateau.getTailleCelluleVivante(),i);
	}
	

	@SuppressWarnings("unchecked")
	@Test
	public void testGetIterateurCellule() {
		assertNotSame(plateau.getIterateurCellule(),((ArrayList<Cellule>)(plateau.getCelluleVivante())).iterator());
	}

	@Test
	public void testGetTailleCelluleVivante() {
		assertEquals(plateau.getTailleCelluleVivante(),17);
	}

	@Test
	public void testGetTailleRegleVie() {
		assertEquals(plateau.getTailleRegleMort(),2);
	}

	@Test
	public void testGetTailleRegleMort() {
		assertEquals(plateau.getTailleRegleMort(),2);
	}

	@Test
	public void testSupprimerCellule() {
		Cellule c=new Cellule(0, 0, -1, true);
		assertTrue(plateau.supprimerCellule(c));
	}

	@Test
	public void testTrierCellule() {
		plateau.trierCellule();
		assertEquals(plateau.getTailleCelluleVivante(),17);
	}

	@Test
	public void testTranslation() {
		
		

	}

}
