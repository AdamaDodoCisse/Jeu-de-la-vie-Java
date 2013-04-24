package interface_;

import java.util.Iterator;

import jeuDeLaVie.JeuDeLaVie;

import structureDeDonnee.Cellule;


/**
 * <b>Matrice est l'interface définissant la structure de donnée </br>
 * d'un jeu de la vie. </b>
 * @see Jeu 
 * @author kouyate
 *
 */
public interface Matrice extends Cloneable{
	/**
	 * Ajoute une cellule à l'ensemble des cellules vivantes du jeu de la vie.
	 * @param cellule
	 * 			Une cellule vivante.
	 * @return Un booléen indiquant si l'ajout à été bien éffectué ou non.
	 * @see Cellule
	 */
	public boolean ajouterCellule(Cellule cellule);
	/**
	 * Ajoute une règle à l'ensemble des "règles de vie" du jeu de la vie.
	 * @param regle
	 * 			Un entier correspondant à une règle(condition pour qu'une cellule mort naisse).
	 * @return Un booléen indiquant si l'ajout de la règle c'est éffectuer avec succès.
	 */
	public boolean ajouterRegleVie(Integer regle);
	/**
	 * Ajoute une règle à l'ensemble des "règles de Mort" du jeu de la vie.
	 * @param regle
	 * 			Un entier correspondant à une règle (condition pour qu'une cellule vivant reste vivant).
	 * @return Un booléen indiquant si l'ajout de la règle c'est éffectuer avec succès.
	 */
	public boolean ajouterRegleMort(Integer regle);
	/**
	 * Méthode clone de la structure de donnée.
	 * @return Une structure de donnée correspondant au clone de l'objet this.
	 * @see Matrice
	 */
	public Matrice clone();
	/**
	 * Teste q'une cellule est contenu dans l'ensemble des cellules vivantes du jeu de la vie.
	 * @param cellule
	 * 			Une cellule vivante.
	 * @return Un booléen indiquant si la cellule passer en paramètre est vivant.
	 * @see Cellule
	 */
	public boolean contains(Cellule cellule);
	/**
	 * Teste q'un entier est contenu dans l'ensemble des règles de Mort </br>
	 * (condition pour q'une cellule vivante reste vivante).
	 * @param regle
	 * 		Un entier correspondant à une règle.
	 * @return Un booléen indiquant si l'entier passer en paramètre est une règle definie.
	 */
	public boolean containsRegleMort(Integer regle);
	/**
	 * Teste q'un entier est contenu dans l'ensemble des règles de Vie </br>
	 * (condition pour q'une cellule mort naisse).
	 * @param regle
	 * 		Un entier correspondant à une règle.
	 * @return Un booléen indiquant si l'entier passer en paramètre est une règle definie.
	 */
	public boolean containsRegleVie(Integer regle);
	/**
	 * Teste que l'ensemble des cellules vivantes du jeu de la vie est vide.
	 * @return Un booléen indiquant si l'ensemble des cellules vivantes en vide.
	 * @see Cellule
	 * @see Matrice#getCelluleVivante()
	 */
	public boolean estVide();
	/**
	 * Getter de cellule vivante.
	 * @param i
	 * 			Un entier correspondant à la position de la cellule dans l'ensemble.
	 * @return Une cellule vivante à la position i dans l'ensemble.
	 * @see Cellule
	 * @see Matrice#getCelluleVivante()
	 */
	public Cellule getCellule(int i);
	/**
	 * Retourne le nombre de voisin(cellule) vivant d'une cellule parmis ses 8 voisins.
	 * @param cellule
	 * 			Une cellule vivante.
	 * @return Un entier correspondant au nombre de voisin de la cellule passer en paramètre.
	 * @see Cellule
	 * @see StructureDeDonnee#getCelluleVivante()
	 */
	//public int getNombreVoisin(Cellule cellule);
	/**
	 * 
	 */
	public void evoluer();
	/**
	 * Getter de l'ensemble des cellules vivantes.
	 * @return Un objet contenant l'ensemble des cellules vivantes.
	 * @see Cellule
	 */
	public Object getCelluleVivante() ;
	/**
	 * Retourne un itérateur sur l'ensemble des cellules vivantes.
	 * @return Un itérateur sur l'ensemble des cellules vivantes.
	 * @see Cellule
	 * @see Matrice#getCelluleVivante()
	 */
	public Iterator<Cellule> getIterateurCellule();
	/**
	 * Retourne le nombre de cellule vivante du jeu de la vie.
	 * @return Un entier correspondant au nombre de cellule vivante.
	 * @see Cellule
	 * @see Matrice#getCelluleVivante()
	 */
	public int getTailleCelluleVivante();
	/**
	 * Getter du nombre de règle de vie(condition pour qu'une cellule mort naisse).
	 * @return Un entier correspondant au nombre de règle de vie du jeu de la vie.
	 */
	public int getTailleRegleVie();
	/**
	 * Getter du nombre de règle de mort(condition pour qu'une cellule vivant reste vivant).
	 * @return Un entier correspondant au nombre de règle de Mort du jeu de la vie.
	 */
	public int getTailleRegleMort();
	/**
	 * Setter de l'ensemble des cellules vivantes.
	 * @param celluleVivante
	 * 			L'objet contenant l'ensemble des cellules vivantes du jeu de la vie.
	 * @see Cellule
	 */
	public void setCelluleVivante(Object celluleVivante);
	/**
	 * Supprime toutes les cellules vivantes.
	 * @return Un booléen indiquant si la suppression de l'ensemble à réussit.
	 * @see Matrice
	 * @see JeuDeLaVie
	 */
	public boolean removeAll();
	/**
	 * Supprime une cellule à l'ensemble des cellules vivantes. 
	 * @param cellule
	 * 			Une cellule vivante.
	 * @return Un booléen indiquant si la suppression s'est éffectuer avec succès.
	 * @see Cellule
	 */
	public boolean supprimerCellule(Cellule cellule);
	/**
	 * Trie l'ensemble des cellules vivantes.
	 * @see Cellule
	 */
	public void trierCellule();
	/**
	 * Ajoute une cellule vivante dans l'ensemble des cellules vivantes.
	 * @param cellule
	 * @return Un booléen indiquant si l'ajout de la cellule à été éffectuer.
	 * @see Cellule
	 * @see JeuDeLaVie
	 */
	public boolean add(Cellule cellule);
	/**
	 * 
	 * @return le max de l'abscisse de la matrice 
	 */
	public int getMaxAbscisse();
	
	public int getMinAbscisse();
	
	public int getMaxOrdonnee();
	
	public int getMinOrdonnee();
	
}
