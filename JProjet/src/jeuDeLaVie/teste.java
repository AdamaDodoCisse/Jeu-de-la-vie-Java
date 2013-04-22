package jeuDeLaVie;

import java.io.FileNotFoundException;

import evolution.HTMLGenerateur;
import exception.HTMLException;
import exception.LectureException;
import structureDeDonnee.PlateauFini;
import interface_.Matrice;

public class teste {
public static void main(String []args) throws FileNotFoundException, HTMLException, LectureException{
	Matrice plateau = new PlateauFini("Dossier_Teste/AQUA33.LIF");
	@SuppressWarnings("unused")
	JeuDeLaVie jeu = new JeuDeLaVie(plateau);
	@SuppressWarnings("unused")
	HTMLGenerateur html = new HTMLGenerateur("Dossier_Teste", 500, 2, "ess");
}

}
