package testEvolution;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import structureDeDonnee.StructureDeDonneeFactory;

import evolution.HTMLGenerateur;

public class HTMLGenerateurTest {
	protected HTMLGenerateur generateur;
	@Before
	public void setUp() throws Exception {
		generateur = new HTMLGenerateur("Dossier_Teste",StructureDeDonneeFactory.PLATEAU_INFINI,1,"Teste");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHTMLGenerateur() {
		fail("Not yet implemented");
	}

	@Test
	public void testAnalyser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGenerer() {
		fail("Not yet implemented");
	}

	@Test
	public void testParser() {
		fail("Not yet implemented");
	}

}
