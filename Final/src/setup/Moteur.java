package setup;
import interface_.StructureDeDonnee;

import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

import code_du_jeu.Cellule;
import Evolution.Commande;
public class Moteur {
	public static void main(String []args){
		new Commande(args,new StructureDeDonnee() {
			
			private Stack<Cellule> cellules;
			private Stack<Integer> RegleVies;
			private Stack<Integer> regleMorts;
			
			@Override
			public void trierCellule() {
				// TODO Auto-generated method stub
				Collections.sort(cellules);
			}
			
			@Override
			public int tailleRegleVie() {
				// TODO Auto-generated method stub
				return RegleVies.size();
			}
			
			@Override
			public int tailleRegleMort() {
				// TODO Auto-generated method stub
				return regleMorts.size();
			}
			
			@Override
			public int taille() {
				// 
				return cellules.size();
			}
			
			@Override
			public boolean supprimer(Cellule cellule) {
				// TODO Auto-generated method stub
				return cellules.remove(cellule);
			}
			
			@SuppressWarnings("unchecked")
			@Override
			public void setCelluleVivante(Object celluleVivante) {
				// TODO Auto-generated method stub
				this.cellules = (Stack<Cellule>) celluleVivante;
			}
			
			@Override
			public int nombreVoisinCellule(Cellule cellule) {
				// TODO Auto-generated method stub
				int voisinVivant = 0 ;
				for(int i=cellule.getX()-1;i<=cellule.getX()+1;i++){
					for(int j=cellule.getY()-1;j<=cellule.getY()+1;j++){

						Cellule k = new Cellule(i,j);

						if(contains(k) && ! k.equals(cellule))

							voisinVivant++;
					}
				}
				return voisinVivant;
			}
			
			@Override
			public Iterator<Cellule> iterer() {
				// TODO Auto-generated method stub
				return cellules.iterator();
			}
			
			@Override
			public void initialise() {
				// TODO Auto-generated method stub
				cellules =new Stack<Cellule>();
				RegleVies = new Stack<Integer>();
				regleMorts = new Stack<Integer>();
			}
			
			@Override
			public Object getCelluleVivante() {
				// TODO Auto-generated method stub
				return cellules;
			}
			
			@Override
			public Cellule getCellule(int i) {
				// TODO Auto-generated method stub
				return cellules.get(i);
			}
			
			@Override
			public boolean estVide() {
				// TODO Auto-generated method stub
				return cellules.isEmpty();
			}
			
			@Override
			public boolean containsRegleVie(Integer regle) {
				// TODO Auto-generated method stub
				return RegleVies.contains(regle);
			}
			
			@Override
			public boolean containsRegleMort(Integer regle) {
				// TODO Auto-generated method stub
				return regleMorts.contains(regle);
			}
			
			@Override
			public boolean contains(Cellule cellule) {
				// TODO Auto-generated method stub
				return cellules.contains(cellule);
			}
			
			@Override
			public boolean ajouterRegleVie(Integer regle) {
				// TODO Auto-generated method stub
				return RegleVies.add(regle);
			}
			
			@Override
			public boolean ajouterRegleMort(Integer regle) {
				// TODO Auto-generated method stub
				return regleMorts.add(regle);
			}
			
			@Override
			public boolean ajouterCellule(Cellule cellule) {
				// TODO Auto-generated method stub
				return cellules.add(cellule);
			}
			
			public StructureDeDonnee clone(){
				try {
					return (StructureDeDonnee) super.clone();
				} catch (CloneNotSupportedException e) {}
				return null;
			}
		});
		
	}
	
}
