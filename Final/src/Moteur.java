import java.util.ArrayList;
import java.util.Iterator;

public class Moteur {
	
	public static void main(String []args){
		new Commande(args);
		StructureDeDonnee<Point> d = new StructureDeDonnee<Point>() {

			@Override
			public boolean ajouterCellule(Point cellule) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean supprimer(Point cellule) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean ajouterRegleVie(Integer regle) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean ajouterRegleMort(Integer regle) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean estVide() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Iterator<Point> iterer() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean contains(Point cellule) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void setRegleMortCellule(ArrayList<Integer> regleMortCellule) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public ArrayList<Integer> getRegleMortCellule() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean containsRegleMort(Integer regle) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean containsRegleVie(Integer regle) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public ArrayList<Point> getCelluleVivante() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void setCelluleVivante(ArrayList<Point> celluleVivante) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public ArrayList<Integer> getRegleVieCellule() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void setRegleVieCellule(ArrayList<Integer> regleVieCellule) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public int taille() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Point getPoint(int i) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int nombreVoisinCellule(Point cellule) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
	}
	
}
