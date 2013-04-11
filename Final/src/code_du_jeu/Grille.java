package code_du_jeu;
import interface_.StructureDeDonnee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;



public class Grille  implements StructureDeDonnee{
	
	private ArrayList<Cellule>celluleVivante;
	private ArrayList<Integer>regleVieCellule;
	private ArrayList<Integer>regleMortCellule;
	
	public Grille(){
		this.celluleVivante = new ArrayList<Cellule>();
		this.regleVieCellule = new ArrayList<Integer>();
		this.regleMortCellule = new ArrayList<Integer>();
	}

	
	@Override
	public Iterator<Cellule> iterer() {
		// TODO Auto-generated method stub
		Iterator<Cellule> it = celluleVivante.iterator();
		return it;
	}
	@Override
	public boolean ajouterCellule(Cellule cellule) {
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
	

	
	public boolean containsRegleVie(Integer regle){
		return regleVieCellule.contains(regle);
	}
	
	public boolean containsRegleMort(Integer regle){
		return regleMortCellule.contains(regle);
	}

	@Override
	public boolean supprimer(Cellule cellule) {
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
		
		Grille  other = (Grille ) obj;
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


	@Override
	public int nombreVoisinCellule(Cellule  p) {
			int voisinVivant = 0 ;
			for(int i=p.getX()-1;i<=p.getX()+1;i++){
				for(int j=p.getY()-1;j<=p.getY()+1;j++){

					Cellule k = new Cellule(i,j);

					if(contains(k) && ! k.equals(p))

						voisinVivant++;
				}
			}
		return voisinVivant;
		}


	@Override
	public boolean contains(Cellule cellule) {
		// TODO Auto-generated method stub
		return  celluleVivante.contains(cellule);
	}


	@Override
	public ArrayList<Cellule> getCelluleVivante() {
		// TODO Auto-generated method stub
		return celluleVivante;
	}


	@Override
	public Cellule getCellule(int i) {
		// TODO Auto-generated method stub
		return  celluleVivante.get(i);
	}


	@Override
	public void trierCellule() {
		// TODO Auto-generated method stub
		Collections.sort(getCelluleVivante());
	}


	@Override
	public int tailleRegleVie() {
		// TODO Auto-generated method stub
		return regleVieCellule.size();
	}


	@Override
	public int tailleRegleMort() {
		// TODO Auto-generated method stub
		return regleMortCellule.size();
	}


	@SuppressWarnings("unchecked")
	@Override
	public void setCelluleVivante(Object celluleVivante) {
		// TODO Auto-generated method stub
		try{
			this.celluleVivante = (ArrayList<Cellule>) celluleVivante;
		}catch(Exception e){};
		
	}


	
}


	
