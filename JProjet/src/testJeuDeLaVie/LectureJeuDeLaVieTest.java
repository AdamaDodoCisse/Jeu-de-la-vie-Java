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
		plateau = new PlateauInfini();			//initialisation du jeu 
	}

	@After
	public void tearDown() throws Exception {
	}
	/*
	 * Fonction qui teste si le jeu a bien été initialiser 
	 * a partir d'un fichier Au depart notre fichier contient 4 cellules 
	 *
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testLectureJeu() throws LectureException, IOException {
		lecture.LectureJeu("Dossier_Teste/teste_jeu.LIF", plateau);
		assertEquals(plateau.getTailleCelluleVivante(), 4);			//teste si le fichier contient bien quatre cellule
		assertTrue(plateau.contains(new Cellule(0,0,-1,true)));		//teste si la cellule en position 0 0 a bien été enregistré
		assertTrue(plateau.contains(new Cellule(0,1,-1,true)));		//teste si la cellule en position 0 1 a bien été enregistré
		assertTrue(plateau.contains(new Cellule(1,0,-1,true)));		//teste si la cellule en position 1 0 a bien été enregistré
		assertTrue(plateau.contains(new Cellule(1,1,-1,true)));		//teste si la cellule en position 1 1 a bien été enregistré
		plateau = new PlateauInfini();
		lecture.LectureJeu("Dossier_Teste/teste.LIF",plateau);
		try{
			lecture.LectureJeu("fichier", plateau);					//teste sur les exceptions au cas ou le fichier est introuvable 
			fail("une exception doit être lever");					
		}catch(LectureException e){
			assertTrue(true);										//teste que l'exception a étét bien lever
		}
		
		
	}

	@SuppressWarnings("static-access")
	@Test
	public void testAjouterRegle() {
		String ligne = "#R 3/23";
		lecture.ajouterRegle(ligne, plateau);						//ajout des regles du jeu 
		assertEquals(plateau.getTailleRegleMort(),2);				//teste si la taille de la règle de mort est bien 2 vu qui qu'il doit contenir 2 et 3
		assertEquals(plateau.getTailleRegleVie(),1);				//teste si la taille de la règle de vie est bien 1 vu qu'il doit contenir 3 		
		assertTrue(plateau.containsRegleMort(3));					//verification que règle de mort contient bien 3
		assertTrue(plateau.containsRegleMort(2));					//verification que règle de mort contient bien 2 aussi
		assertTrue(plateau.containsRegleVie(3));					//verification que règle de vie contient 3
				
	}

}
