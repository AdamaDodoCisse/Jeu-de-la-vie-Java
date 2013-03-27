import java.awt.*;
import java.util.*;

/**
 * 
 * @author kouyate
 *
 */

public abstract class JeuDeLaVie {
	
	private ArrayList<Point> celluleVivante;
	private ArrayList<Integer>regleVieCellule;
	private ArrayList<Integer>regleMortCellule;
	
	public abstract void evolutionSuivante();
	
	
	public void construireJeu(String fichier){
		
		celluleVivante = new ArrayList<Point>();
		regleVieCellule = new ArrayList<Integer>();
		regleMortCellule = new ArrayList<Integer>();
		
		LectureJeuDeLaVie.lireJeuDeLaVie(this, fichier);
	}


	public ArrayList<Point> getCelluleVivante() {
		return celluleVivante;
	}


	public void setCelluleVivante(ArrayList<Point> celluleVivante) {
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

}
