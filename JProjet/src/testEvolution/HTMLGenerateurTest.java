package testEvolution;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import evolution.HTMLGenerateur;
import exception.HTMLException;
import exception.LectureException;

public class HTMLGenerateurTest {
	protected HTMLGenerateur generateur;
	@Test
	public void testHTMLGenerateur() throws HTMLException, FileNotFoundException, LectureException {
		generateur = new HTMLGenerateur("Dossier_Teste",50,2,"teste");
		File fichier = new File("teste.html");
		assertTrue(fichier.isFile());
		BufferedReader reader = new BufferedReader(
								new FileReader(fichier));
		String chaine;
		try {
			chaine = reader.readLine();
			assertTrue(! chaine.equals(null));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
