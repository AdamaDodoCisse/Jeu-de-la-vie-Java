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
}
