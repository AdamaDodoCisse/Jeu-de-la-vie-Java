package code_du_jeu;

import java.io.FileNotFoundException;


import Interface_du_jeu.StructureDeDonnee;


public class MondeInfini extends JeuDeLaVie{
	
	public MondeInfini(String nomFichier,StructureDeDonnee grille) throws FileNotFoundException{
		super(nomFichier,grille);
	}

	public boolean ajouterCellule(Cellule p){
		return true;
	}
}
	

