package interface_;
import structureDeDonnee.PlateauCirculaire;
import structureDeDonnee.PlateauFini;
import structureDeDonnee.PlateauInfini;

public interface Jeu {
	/**
	 * Calcule l'évolution suivante de l'ensemble des cellules vivantes et des cellules </br>
	 * voisines du jeu de la vie à partir des règles définient. 
	 * Elle est dépendante de la structure de donnée utilisé ({@link PlateauFini},{@link PlateauInfini},
	 * {@link PlateauCirculaire}).
	 * @see Matrice
	 * @see PlateauFini 
	 * @see PlateauInfini
	 * @see PlateauCirculaire
	 */
	public void evolutionSuivante();
	/**
	 * Teste si une cellule vivante doit survivre à l'evolution suivante du jeu de la vie.
	 * Elle est dépendante des règles de Mort des cellules({@link StructureDeDonnee}) définient dans le jeu.
	 * @param cellule
	 * 				Une cellule vivante du jeu de la vie.
	 * @return Un booléen indiquant si la cellule doit mourir ou non.
	 * @see Cellule
	 * 
	 */
	//public boolean estCelluleMourante(Cellule cellule);
	/**
	 * Teste si une cellule doit naitre à l'evolution suivante du jeu de la vie.
	 * Elle est dépendante des règles de vie des cellules({@link StructureDeDonnee}) définient dans le jeu.
	 * @param cellule
	 * 				Une cellule du jeu de la vie.
	 * @return Un booléen indiquant si la cellule doit naitre ou non.
	 * @see Cellule
	 * 
	 */
	//public boolean estCelluleNaissante(Cellule cellule);
}
