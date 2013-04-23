package testJeuDeLaVie;

import static org.junit.Assert.*;
import java.io.IOException;

import jeuDeLaVie.LectureJeuDeLaVie;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exception.LectureException;

import structureDeDonnee.Cellule;
import structureDeDonnee.PlateauInfini;

public class LectureJeuDeLaVieTest {
	LectureJeuDeLaVie lecture;
	protected PlateauInfini plateau;
	@Before
	public void setUp() throws Exception {
		plateau = new PlateauInfini();
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("static-access")
	@Test
	public void testLectureJeu() throws LectureException, IOException {
		lecture.LectureJeu("Dossier_Teste/teste_jeu.LIF", plateau);
		assertEquals(plateau.getTailleCelluleVivante(), 4);
		assertTrue(plateau.contains(new Cellule(0,0,-1,true)));
		assertTrue(plateau.contains(new Cellule(0,1,-1,true)));
		assertTrue(plateau.contains(new Cellule(1,0,-1,true)));
		assertTrue(plateau.contains(new Cellule(1,1,-1,true)));
		plateau = new PlateauInfini();
		lecture.LectureJeu("Dossier_Teste/teste.LIF",plateau);
		try{
			lecture.LectureJeu("fichier", plateau);
		}catch(LectureException e){
			
		}
		
		
	}

	@SuppressWarnings("static-access")
	@Test
	public void testAjouterRegle() {
		String ligne = "#R 3/23";
		lecture.ajouterRegle(ligne, plateau);
		assertEquals(plateau.getTailleRegleMort(),2);
		assertEquals(plateau.getTailleRegleVie(),1);		
		assertTrue(plateau.containsRegleMort(3));
		assertTrue(plateau.containsRegleMort(2));
		assertTrue(plateau.containsRegleVie(3));
				
	}

}
