
import java.util.Iterator;
public interface StructureDeDonnee<T> {
	public boolean ajouterCellule(Point cellule);
	public boolean supprimer(Point cellule);
	public boolean ajouterRegleVie(Integer regle);
	public boolean ajouterRegleMort(Integer regle);
	public boolean estVide();
	public Iterator<Point> iterer();
	public boolean contains(Point cellule);
	//public ArrayList<Integer> getRegleMortCellule();
	public boolean containsRegleMort(Integer regle);
	public boolean containsRegleVie(Integer regle);
	public T getCelluleVivante() ;
	public void setCelluleVivante(T celluleVivante) ;
	//public ArrayList<Integer> getRegleVieCellule() ;
	public int taille();
	public Point getCellule(int i);
	public int nombreVoisinCellule(Point cellule);
	public void trierCellule();
	public int tailleRegleVie();
	public int tailleRegleMort();
}
