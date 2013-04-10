package Interface_du_jeu;

import java.util.Iterator;
 
import setup.Cellule;
public interface StructureDeDonnee {
	public boolean ajouterCellule(Cellule cellule);
	public boolean supprimer(Cellule cellule);
	public boolean ajouterRegleVie(Integer regle);
	public boolean ajouterRegleMort(Integer regle);
	public boolean estVide();
	public Iterator<Cellule> iterer();
	public boolean contains(Cellule cellule);
	//public ArrayList<Integer> getRegleMortCellule();
	public boolean containsRegleMort(Integer regle);
	public boolean containsRegleVie(Integer regle);
	public Object getCelluleVivante() ;
	public void setCelluleVivante(Object celluleVivante) ;
	//public ArrayList<Integer> getRegleVieCellule() ;
	public int taille();
	public Cellule getCellule(int i);
	public int nombreVoisinCellule(Cellule cellule);
	public void trierCellule();
	public int tailleRegleVie();
	public int tailleRegleMort();
}
