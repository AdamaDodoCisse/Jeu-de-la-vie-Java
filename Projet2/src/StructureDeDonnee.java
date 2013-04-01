import java.util.Iterator;


public interface StructureDeDonnee<T> {
	public boolean ajouterCellule(T cellule);
	public boolean supprimer(T cellule);
	public boolean ajouterRegleVie(Integer regle);
	public boolean ajouterRegleMort(Integer regle);
	public boolean estVide();
	public Iterator<T> iterer();
	
	
}
