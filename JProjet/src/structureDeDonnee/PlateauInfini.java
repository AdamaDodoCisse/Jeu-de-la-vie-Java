package structureDeDonnee;
import java.io.IOException;
import java.util.ArrayList;

import exception.LectureException;

import jeuDeLaVie.JeuDeLaVie;

/**
 * <b>PlateauInfini est la classe répresentant une structure de donnée du jeu de la vie </br>
 * dans un plateau infini.</b>
 * Elle hérite de la classe {@link PlateauFini}.
 * @see JeuDeLaVie
 * @author kouyate
 *
 */
public class PlateauInfini extends PlateauFini{
	
	public PlateauInfini() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PlateauInfini(String nomFichier) throws LectureException, IOException {
		super(nomFichier);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	/* (non-Javadoc)
	 * @see structure.StructureDeDonnee#ajouterCellule(structure.Cellule)
	 */
	@Override
	public boolean ajouterCellule(Cellule cellule) {
		if(contains(cellule)){
			return false;
		}
		return ((ArrayList<Cellule>) getCelluleVivante()).add(cellule);
	}
}
