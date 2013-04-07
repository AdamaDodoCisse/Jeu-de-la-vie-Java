import java.util.ArrayList;
import java.util.Iterator;
public interface StructureDeDonnee<T> {
	public boolean ajouterCellule(T cellule);
	public boolean supprimer(T cellule);
	public boolean ajouterRegleVie(Integer regle);
	public boolean ajouterRegleMort(Integer regle);
	public boolean estVide();
	public Iterator<T> iterer();
	public boolean contains(T cellule);
	public void setRegleMortCellule(ArrayList<Integer> regleMortCellule) ;
	public ArrayList<Integer> getRegleMortCellule();
	public boolean containsRegleMort(Integer regle);
	public boolean containsRegleVie(Integer regle);
	public ArrayList<T> getCelluleVivante() ;
	public void setCelluleVivante(ArrayList<T> celluleVivante) ;
	public ArrayList<Integer> getRegleVieCellule() ;
	public void setRegleVieCellule(ArrayList<Integer> regleVieCellule);
	public int taille();
	public T getPoint(int i);
	public int nombreVoisinCellule(T cellule);
}
