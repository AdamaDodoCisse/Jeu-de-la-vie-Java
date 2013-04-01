import java.util.ArrayList;
import java.util.Iterator;

public class Grille<T> implements StructureDeDonnee<T>{
	
	private ArrayList<T>celluleVivante;
	private ArrayList<Integer>regleVieCellule;
	private ArrayList<Integer>regleMortCellule;
	
	public Grille(){
		this.celluleVivante = new ArrayList<T>();
		this.regleVieCellule = new ArrayList<Integer>();
		this.regleMortCellule = new ArrayList<Integer>();
	}

	
	@Override
	public Iterator<T> iterer() {
		// TODO Auto-generated method stub
		Iterator<T> it = celluleVivante.iterator();
		return it;
	}
	@Override
	public boolean ajouterCellule(T cellule) {
		// TODO Auto-generated method stub
		if(this.celluleVivante.contains(cellule)){
			return false;
		}
		celluleVivante.add(cellule);
		return true;
	}
	
	public int taille(){
		return getCelluleVivante().size();
	}

	@Override
	public boolean ajouterRegleVie(Integer regle) {
		// TODO Auto-generated method stub
		if(regleVieCellule.contains(regle)){
			return false;
		}
		return regleVieCellule.add(regle);
	}

	@Override
	public boolean ajouterRegleMort(Integer regle) {
		// TODO Auto-generated method stub
		if(regleMortCellule.contains(regle)){
			return false;
		}
		return regleMortCellule.add(regle);
	}
	
	public ArrayList<T> getCelluleVivante() {
		return celluleVivante;
	}

	public void setCelluleVivante(ArrayList<T> celluleVivante) {
		this.celluleVivante = celluleVivante;
	}

	public ArrayList<Integer> getRegleVieCellule() {
		return regleVieCellule;
	}

	public void setRegleVieCellule(ArrayList<Integer> regleVieCellule) {
		this.regleVieCellule = regleVieCellule;
	}

	public ArrayList<Integer> getRegleMortCellule() {
		return regleMortCellule;
	}

	public void setRegleMortCellule(ArrayList<Integer> regleMortCellule) {
		this.regleMortCellule = regleMortCellule;
	}
	
	public boolean contains(T cellule){
		return celluleVivante.contains(cellule);
	}
	
	public boolean containsRegleVie(Integer regle){
		return regleVieCellule.contains(regle);
	}
	
	public boolean containsRegleMort(Integer regle){
		return regleMortCellule.contains(regle);
	}

	@Override
	public boolean supprimer(T cellule) {
		return celluleVivante.remove(cellule);
	}

	
	@Override
	public boolean estVide() {
	return celluleVivante.size()==0;
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((celluleVivante == null) ? 0 : celluleVivante.hashCode());
		result = prime
				* result
				+ ((regleMortCellule == null) ? 0 : regleMortCellule.hashCode());
		result = prime * result
				+ ((regleVieCellule == null) ? 0 : regleVieCellule.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grille <T> other = (Grille <T>) obj;
		if (celluleVivante == null) {
			if (other.celluleVivante != null)
				return false;
		} else if (!celluleVivante.equals(other.celluleVivante))
			return false;
		if (regleMortCellule == null) {
			if (other.regleMortCellule != null)
				return false;
		} else if (!regleMortCellule.equals(other.regleMortCellule))
			return false;
		if (regleVieCellule == null) {
			if (other.regleVieCellule != null)
				return false;
		} else if (!regleVieCellule.equals(other.regleVieCellule))
			return false;
		return true;
	}

}
