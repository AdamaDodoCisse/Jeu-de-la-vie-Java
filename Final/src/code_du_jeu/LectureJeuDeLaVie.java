package code_du_jeu;

import interface_.StructureDeDonnee;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
public class LectureJeuDeLaVie {
	/*Methode qui permet de lire de Fichier et mettre son contenu dans une grille qui est de type StructureDeDonnee
	 * @param String nomFichier 	et une StructuredeDonnee grille
	 * 
	 */
	public static void LectureJeu(String nomFichier,StructureDeDonnee grille) throws FileNotFoundException{
		BufferedReader reader = null;
		File fichier=new File(nomFichier);
		int abscisse=0;
		int ordonnee=0;
		String line = null; 
		Scanner scanner  = null;
		if( fichier.isFile() /*|| ! fichier.getAbsolutePath().matches(".[Ll][Ii][Ff]$")*/
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

						ajouterRegle(line,grille);

					} else if (line.matches("^[.*]+")){

						int i = 0;
						int tmp=ordonnee;
						while(i<line.length()){
							if(line.charAt(i)=='*'){
								grille.ajouterCellule(new Cellule(abscisse,ordonnee));
							}
							ordonnee++;
							i++;
						}
						abscisse++;
						ordonnee=tmp;

					} else if (line.matches("^#N$")){

						grille.ajouterRegleVie(3);
						grille.ajouterRegleMort(2);
						grille.ajouterRegleMort(3);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			grille.trierCellule();
		}
		if(grille.tailleRegleMort()==0){
			grille.ajouterRegleMort(2);
			grille.ajouterRegleMort(3);
		}
		if(grille.tailleRegleVie()==0){
			grille.ajouterRegleVie(3);
		}
	}
/**Methode ajouterCelluleVivante
 * 
 * @param line
 * @param abscisse
 * @param ordonnee
 * @param grille
 */
	public static void ajouterCelluleVivante(String line ,int abscisse,int ordonnee, StructureDeDonnee grille){
		int i = 0;
		int tmp=ordonnee;
		while(i<line.length()){
			if(line.charAt(i)=='*'){
				grille.ajouterCellule(new Cellule(abscisse,ordonnee));
			}
			ordonnee++;
			i++;
		}
		abscisse++;
		ordonnee=tmp;
	}

/**Methode ajouterRegle 
 * 
 * 
 * @param line
 * @param grille
 */
	public static void ajouterRegle(String line, StructureDeDonnee grille){
		line = line.replaceAll("[^0-9/]", "");
		StringTokenizer regle = new StringTokenizer(line,"/");
		if(regle.countTokens()==2){
			String k = regle.nextToken();
			int i=0;
			while(i<=k.length()-1){
				grille.ajouterRegleVie(Integer.parseInt(k.charAt(i)+""));
				i++;
			}
			k = regle.nextToken();
			i=0;
			while(i<=k.length()-1){
				grille.ajouterRegleMort(Integer.parseInt(k.charAt(i)+""));
				i++;
			}
		}
	}
}




