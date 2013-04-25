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
/*
 * Permet de tester  le constructeur de notre PlateauFini
 */
	@Test public void testPlateauFini(){
		plateau=new PlateauFini();
	}
	
	/*
	 * Nous permet de savoir si notre methode ajouterCellule marche
	 */
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

	/*
	 * Nous permet de savoir si notre méthode ajouterRegleVie fonctionnne
	 */
	@Test
	public void testAjouterRegleVie() {
		plateau.ajouterRegleVie(3);
		assertTrue(plateau.containsRegleVie(3));
	}

	/*
	 * Nous permet de savoir si notre méthode ajouterregleMort fonctionne
	 */
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

	/*
	 * Permet de tester notre méthode close
	 */
	@Test
	public void testClone() {
		assertNotSame(plateau.clone(),plateau);
	}
	/*
	 * Nous permet de savoir si notre méthode contains  fait son boulo
	 */

	@Test
	public void testContains() {
		assertTrue(plateau.contains(new Cellule(0, 0, 3, false)));
	}

	/*
	 * Permet de tester la méthode containsRegleMort
	 */
	@Test
	public void testContainsRegleMort() {
		assertTrue(plateau.containsRegleMort(2));
		assertTrue(plateau.containsRegleMort(3));
	}

	/*
	 * Permet de tester la méthode containsRegleVie
	 */
	@Test
	public void testContainsRegleVie() {
		assertTrue(plateau.containsRegleMort(3));
	}
/*
 * Nous permet de savoir que notre méthode estVide marche
 */
	@Test
	public void testEstVide() {
		assertFalse(plateau.estVide());;
	}
/*
 * Permet de savoir que la methode evoluer fait ce qu'on attend d'elle
 */
	@Test
	public void testEvoluer() {
		plateau.evoluer();
		assertEquals(plateau.getTailleCelluleVivante(),17);
	}

	@SuppressWarnings("unchecked")
	@Test
	/*
	 * permet de tester la méthode calculerEvolution
	 */
	public void testCalculerEvolution() {
		ArrayList<Cellule> it=new ArrayList<Cellule>();
		it.add(new Cellule(1, 0, -1, true));
		it.add(new Cellule(0, 0, -1, true));
		plateau.calculerEvolution(it);
		plateau.calculerEvolution((ArrayList<Cellule>)plateau.getCelluleVivante());
assertNotSame(plateau.getTailleCelluleVivante(),it.size());

	}
/*
 * Nous permet de savoir si effectivement la méthode getcellule retourne bien une cellule
 */
	@Test
	public void testGetCellule() {
		Cellule c=new Cellule(0, 0, -1, true);
		assertEquals(plateau.getCellule(0), c);
	}
/*
 * Nous permet de savoir si effectivement la méthode getcelluleVivante retourne bien l'ensemble des cellules vivantes
 */
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
	/*
	 * permet de savoir si la méthode getIterateurCellule fait bien son travail retournée un iterator sur les cellules
	 */
	public void testGetIterateurCellule() {
		assertNotSame(plateau.getIterateurCellule(),((ArrayList<Cellule>)(plateau.getCelluleVivante())).iterator());
	}
/*
 * permet de savoir la taille de la liste des cellules vivantes 
 */
	@Test
	public void testGetTailleCelluleVivante() {
		assertEquals(plateau.getTailleCelluleVivante(),17);
	}
/*
 * Nous permet de savoir la taille de la liste de regle vie
 */
	@Test
	public void testGetTailleRegleVie() {
		assertEquals(plateau.getTailleRegleVie(),1);
	}
/*
 * Nous permet de savoir la taille de la liste de regle mort
 */
	@Test
	public void testGetTailleRegleMort() {
		assertEquals(plateau.getTailleRegleMort(),2);
	}
/*
 * permet de savoir si la méthode supprimerCellule fonctionne
 */
	@Test
	public void testSupprimerCellule() {
		Cellule c=new Cellule(0, 0, -1, true);
		assertTrue(plateau.supprimerCellule(c));
	}
/*
 * Permet de savoir si la lise de cellules vivantes est trée
 */
	@Test
	public void testTrierCellule() {
		plateau.trierCellule();
		assertEquals(plateau.getTailleCelluleVivante(),17);
	}

	@Test
	public void testTranslation() {
		
		

	}

}
