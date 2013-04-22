package testJeuDeLaVie;

import interface_.Matrice;

import org.junit.After;
import org.junit.Before;
import structureDeDonnee.PlateauFini;

public class LectureJeuDeLaVieTest {
	protected Matrice plateau;
	protected String nomFichier;
	
	@Before
	public void setUp() throws Exception {
		plateau = new PlateauFini();
		nomFichier = "Dossier_Teste/teste_jeu.LIF";
	}

	@After
	public void tearDown() throws Exception { 
	}
/*
	@Test
	public void testLectureJeu() throws FileNotFoundException, LectureException {
		LectureJeuDeLaVie.LectureJeu(nomFichier, plateau);
		assertEquals(3,plateau.getTailleCelluleVivante());
		assertTrue(plateau.contains(new Cellule(0, 0)) 
				&& plateau.contains(new Cellule(0,1))
				&& plateau.contains(new Cellule(0,2)));
		assertEquals(1, plateau.getTailleRegleVie());
		assertTrue(plateau.containsRegleVie(3));
		assertEquals(2, plateau.getTailleRegleMort());
		assertTrue(plateau.containsRegleMort(2)
				&& plateau.containsRegleMort(3));
	}
*/
}
