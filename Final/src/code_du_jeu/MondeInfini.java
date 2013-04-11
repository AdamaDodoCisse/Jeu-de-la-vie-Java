package code_du_jeu;

import interface_.StructureDeDonnee;

import java.io.FileNotFoundException;

public class MondeInfini extends JeuDeLaVie{
	
	public MondeInfini(String nomFichier,StructureDeDonnee grille) throws FileNotFoundException{
		super(nomFichier,grille);
	}

	public boolean ajouterCellule(Cellule p){
		return true;
	}
}
	

