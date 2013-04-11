package interface_;

import java.util.Iterator;

import code_du_jeu.Cellule;

 
public interface StructureDeDonnee extends Cloneable{
	public boolean ajouterCellule(Cellule cellule);
	public boolean supprimer(Cellule cellule);
	public boolean ajouterRegleVie(Integer regle);
	public boolean ajouterRegleMort(Integer regle);
	public boolean estVide();
	public Iterator<Cellule> iterer();
	public boolean contains(Cellule cellule);
	public boolean containsRegleMort(Integer regle);
	public boolean containsRegleVie(Integer regle);
	public Object getCelluleVivante() ;
	public void setCelluleVivante(Object celluleVivante) ;
	public int taille();
	public Cellule getCellule(int i);
	public int nombreVoisinCellule(Cellule cellule);
	public void trierCellule();
	public int tailleRegleVie();
	public int tailleRegleMort();
	public StructureDeDonnee clone();
}
