package jeuDeLaVie;

import interface_.Matrice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import exception.LectureException;
import structureDeDonnee.Cellule;
import structureDeDonnee.PlateauCirculaire;
import structureDeDonnee.PlateauFini;
import structureDeDonnee.PlateauInfini;

/**
 * <b>LectureJeuDeLaVie est la classe permettant d'initialiser un plateau du jeu de la vie.</b>
 * @see JeuDeLaVie
 * @author kouyate
 *
 */

public class LectureJeuDeLaVie {
	/**
	 * Initialise le plateau du jeu (Structure de donnée) à partir d'un fichier au format LIF.
	 * @param nomFichier
	 * 				Un nom de fichier LIF(fichier comportant le jeu de la vie).
	 * @param plateau
	 * 				Une structure de donnée répresentant un plateau du jeu de la vie.
	 * @throws LectureException 
	 * 				Lève une exception si le nom de fichier passer en paramètre n'existe pas.
	 * @throws FileNotFoundException 
	 * @see Matrice
	 * @see PlateauFini
	 * @see PlateauInfini
	 * @see PlateauCirculaire
	 * 
	 */
	public static void LectureJeu(String nomFichier,Matrice plateau) throws LectureException, FileNotFoundException{
		BufferedReader reader = null;
		File fichier=new File(nomFichier);
		int abscisse=0;
		int ordonnee=0;
		String line = null; 
		Scanner scanner  = null;
		if( fichier.isFile() && fichier.getAbsolutePath().matches("\\.[Ll][Ii][Ff]$")
				|| fichier.isFile() && fichier.getAbsolutePath().endsWith(".LIF")){

			reader = new BufferedReader(new FileReader(fichier));
			try {
				while((line = reader.readLine())!=null){
					if(line.matches("^#P[\\s0-9-]+")){
						line = line.replaceAll("[^0-9\\s-]", "");
						scanner = new Scanner(line);
						abscisse = scanner.nextInt();
						ordonnee = scanner.nextInt();
					} else if (line.matches("^#R[\\s0-9]+/[0-9]+$")){

						ajouterRegle(line,plateau);

					} else if (line.matches("^[.*]+")){

						int i = 0;
						int tmp=ordonnee;
						while(i<line.length()){
							if(line.charAt(i)=='*'){
								plateau.add(new Cellule(abscisse,ordonnee,-1,true));
							}
							ordonnee++;
							i++;
						}
						abscisse++;
						ordonnee=tmp;

					} else if (line.matches("^#N$")){

						plateau.ajouterRegleVie(3);
						plateau.ajouterRegleMort(2);
						plateau.ajouterRegleMort(3);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			plateau.trierCellule();
		} else {
			throw new LectureException(nomFichier + " n'existe pas !");
		}
		if(plateau.getTailleRegleMort()==0){
			plateau.ajouterRegleMort(2);
			plateau.ajouterRegleMort(3);
		}
		if(plateau.getTailleRegleVie()==0){
			plateau.ajouterRegleVie(3);
		}
	}
	/**
	 * 
	 * @param line
	 * @param abscisse
	 * @param ordonnee
	 * @param grille
	 */
	public static void ajouterCelluleVivante(String line ,int abscisse,int ordonnee, Matrice grille){
		int i = 0;
		int tmp=ordonnee;
		while(i<line.length()){
			if(line.charAt(i)=='*'){
				grille.ajouterCellule(new Cellule(abscisse,ordonnee,-1,true));
			}
			ordonnee++;
			i++;
		}
		abscisse++;
		ordonnee=tmp;
	}
	/**
	 * 
	 * @param line
	 * @param plateau
	 */
	public static void ajouterRegle(String line, Matrice plateau){
		line = line.replaceAll("[^0-9/]", "");
		StringTokenizer regle = new StringTokenizer(line,"/");
		if(regle.countTokens()==2){
			String k = regle.nextToken();
			int i=0;
			while(i<=k.length()-1){
				plateau.ajouterRegleVie(Integer.parseInt(k.charAt(i)+""));
				i++;
			}
			k = regle.nextToken();
			i=0;
			while(i<=k.length()-1){
				plateau.ajouterRegleMort(Integer.parseInt(k.charAt(i)+""));
				i++;
			}
		}
	}
}