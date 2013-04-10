

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteStructure {
	protected Grille structure;
	@Before
	public void setUp() throws Exception {
		structure = new Grille();
		LectureJeuDeLaVie.LectureJeu("jeu.LIF",structure);
	}

	@After
	public void tearDown() throws Exception {
	
	}
	@Test
	public void testAjouterCellule() {
		Point p = new Point(3,8);
		structure.ajouterCellule(p);
		assertEquals(4, structure.taille());
	}
	@Test
    public void testContains(){
    	Point p = new Point(2,3);
    	structure.ajouterCellule(p);
    	assertTrue(structure.contains(p));
    }
	@Test
	public void testSupprimerCellule(){
		Point p = new Point(3,8);
		structure.supprimer(p);
		assertFalse(structure.contains(p));
	}
	@Test
	public void testVide(){
		assertTrue((new Grille()).estVide());
	}
	@Test
	public void testNombreVoisinCellule(){
		Point p=new Point(0,0);
		Point p1=new Point (0,1);
		Point p2=new Point(0,2);
		assertEquals(1, structure.nombreVoisinCellule(p));
		assertEquals(2, structure.nombreVoisinCellule(p1));
		assertEquals(1, structure.nombreVoisinCellule(p2));
	
	}
	
	@Test
	public void testContainsRegleMort(){
		assertTrue(structure.containsRegleMort(3)&&structure.containsRegleMort(2));
	}
	@Test 
	public void testContainsRegleVie(){
		assertTrue(structure.containsRegleVie(3));
	}
	@Test 
	public void testIterator(){
		Iterator<Point> it = structure.iterer();
		int i=0;
		while(it.hasNext()){
			assertTrue(structure.contains(it.next()));
			i++;
		}
		assertTrue(i==structure.taille());
		
	}
	@Test
	public void testeGetCellule(){
		assertTrue(structure.getCellule(0).equals(new Point(0,0)));
	}

}
