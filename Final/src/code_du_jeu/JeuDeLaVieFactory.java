package code_du_jeu;
import java.io.FileNotFoundException;

import Interface_du_jeu.StructureDeDonnee;

 
public class JeuDeLaVieFactory {
	
	public static final int MONDE_INFINI = 1 ;
	public static final int MONDE_CIRCULAIRE = 2;
	public static final int MONDE_AVEC_FRONTIERE = 3;
	
	public static JeuDeLaVie getJeuDeLaVie(int typeJeu,String nomFichier,StructureDeDonnee grille) throws FileNotFoundException{
		JeuDeLaVie jeu = null;
		
		switch(typeJeu){
		case MONDE_INFINI : 
			jeu = new MondeInfini(nomFichier,grille);
			break;
		case MONDE_CIRCULAIRE : 
			jeu = new MondeCirculaire(nomFichier,grille);
			break;
		case MONDE_AVEC_FRONTIERE : 
			jeu = new JeuDeLaVie(nomFichier,grille);
			break;
		default : 
			throw new IllegalArgumentException("Type de jeu Inconnu "+typeJeu);
			
		}
		return jeu;
			
	}
	
}
