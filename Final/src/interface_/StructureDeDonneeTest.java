package interface_;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import code_du_jeu.Cellule;
import code_du_jeu.Grille;
import code_du_jeu.LectureJeuDeLaVie;

public class StructureDeDonneeTest {
	protected StructureDeDonnee structure;
	@Before
	public void setUp() throws Exception {
		structure =new Grille();
		LectureJeuDeLaVie.LectureJeu("html/jeu.LIF", structure);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAjouterCellule() {
		Cellule p=new Cellule(2,3);
		assertTrue(structure.ajouterCellule(p));
	}

	@Test
	public void testSupprimer() {
		Cellule p=new Cellule(0,0);
		assertTrue(structure.supprimer(p));
	}

	@Test
	public void testAjouterRegleVie() {
		assertTrue(structure.ajouterRegleVie(2));
	}

	@Test
	public void testAjouterRegleMort() {
		assertTrue(structure.ajouterRegleMort(7));

	}

	@Test
	public void testEstVide() {
		structure=new Grille();
		assertTrue(structure.estVide());
	}

	@Test
	public void testIterer() {
		Iterator<Cellule> it= structure.iterer();
		int i=0;
		while(it.hasNext()){
			assertTrue(structure.contains(it.next()));
			i++;
		}

		assertTrue(i==structure.taille());
	}

	@Test
	public void testContains() {
		structure.ajouterCellule(new Cellule(-1,-1));
		assertTrue(structure.contains(new Cellule(-1,-1)));
	}

	@Test
	public void testContainsRegleMort() {
		assertTrue(structure.containsRegleMort(3));
		assertTrue(structure.containsRegleMort(2));
	}

	@Test
	public void testContainsRegleVie() {
		assertTrue(structure.containsRegleVie(3));
		assertFalse(structure.containsRegleVie(4));
	}

	@Test
	public void testTaille() {
		assertTrue(structure.taille()==22);
	}

	@Test
	public void testGetCellule() {
		assertTrue(structure.getCellule(7).equals(new Cellule(2,0)));
	}

	@Test
	public void testNombreVoisinCellule() {
		assertTrue(structure.nombreVoisinCellule(structure.getCellule(structure.taille()-1))==0);
	}

}
