import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class LectureJeuDeLaVieTest {
	protected StructureDeDonnee<?> structure;
	@Before
	public void setUp() throws Exception {
		structure  = new Grille();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws FileNotFoundException {
		LectureJeuDeLaVie.LectureJeu("jeu.LIF", structure);
		assertEquals(3,structure.taille());
		assertTrue(structure.contains(new Point(0,0))
				&& structure.contains(new Point(0,1)) && structure.contains(new Point(0,2)));
		
	}

}
