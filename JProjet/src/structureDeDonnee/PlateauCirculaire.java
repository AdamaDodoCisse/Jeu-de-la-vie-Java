package structureDeDonnee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.Timer;

import exception.LectureException;

import jeuDeLaVie.JeuDeLaVie;

/**
 * <b>PlateauCirculaire est la classe répresentant un plateau du jeu de la vie </br>
 * dans un Monde circulaire.</b>
 * Elle hérite de la classe {@link PlateauFini}.
 * @see PlateauFini
 * @see JeuDeLaVie
 * @author kouyate
 */
public class PlateauCirculaire extends PlateauFini {
	/**
	 * 
	 * @param nomFichier
	 * @throws FileNotFoundException
	 * @throws LectureException
	 */
	public PlateauCirculaire(String nomFichier) throws FileNotFoundException, LectureException {
		super(nomFichier);
		// la taille doit etre fixer 
		setMinAbscisse(0);
		setMinOrdonnee(0);
		setMaxAbscisse(40);
		setMaxOrdonnee(39);
		
		
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param cellule
	 * @param increment
	 * @return
	 */
	private Cellule SymetrieHorizontale(Cellule cellule,int increment){
		if(increment < 0){
			if(cellule.getOrdonnee() == getMinOrdonnee()){
				return new Cellule(cellule.getAbscisse(), getMaxOrdonnee(), 1, false);
			}else{
				return new Cellule(cellule.getAbscisse(),cellule.getOrdonnee() + increment, 1 , false);
			}
		}else{
			if(cellule.getOrdonnee() == getMaxOrdonnee()){
				
				return new Cellule(cellule.getAbscisse(), getMinAbscisse(), 1, false);
			}else{
				
				return new Cellule(cellule.getAbscisse(), cellule.getOrdonnee() + increment, 1, false);
			}
		}	
	}
	/**
	 * 
	 * @param cellule
	 * @param increment
	 * @return
	 */
	private Cellule SymetrieVertivale(Cellule cellule,int increment){
		if(increment < 0 ){
			if(cellule.getAbscisse() == getMinAbscisse()){
				return new Cellule(getMaxAbscisse(), cellule.getOrdonnee(), 1, false);
			}else{
				
				return new Cellule(cellule.getAbscisse() + increment,cellule.getOrdonnee(), 1 , false);
			}
		}else{
			if(cellule.getAbscisse() == getMaxAbscisse()){
				
				return new Cellule(getMinAbscisse(), cellule.getOrdonnee(), 1, false);
			}else{
				return new Cellule(cellule.getAbscisse() + increment, cellule.getOrdonnee(), 1, false);
			}
		}	
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void evoluer(){
		ArrayList<Cellule> liste1 =new ArrayList<Cellule>();
		Iterator<Cellule> c = getIterateurCellule();
		
		while(c.hasNext()){
			liste1.add(SymetrieHorizontale(c.next(), 1));
		}
		ArrayList<Cellule> liste2 = new ArrayList<Cellule>();
		Iterator<Cellule> c2 = getIterateurCellule();
		while(c2.hasNext()){
			liste2.add(SymetrieVertivale(c2.next(), 1));
		}
		ArrayList<Cellule> liste3 = new ArrayList<Cellule>();
		Iterator<Cellule> c3 = getIterateurCellule();
		while(c3.hasNext()){
			liste3.add(SymetrieHorizontale(c3.next(), -1));
		}	
		
		ArrayList<Cellule> liste4 = new ArrayList<Cellule>();
		Iterator<Cellule> c4 = getIterateurCellule();
		while(c4.hasNext()){
			liste4.add(SymetrieVertivale(c4.next(), -1));
		}
		//
		ArrayList<Cellule> liste5 = new ArrayList<Cellule>();
		Iterator<Cellule> c5 = getIterateurCellule();
		while(c5.hasNext()){
			liste5.add(SymetrieHorizontale(SymetrieVertivale(c5.next(), -1), 1));
		}
		ArrayList<Cellule> liste6 = new ArrayList<Cellule>();
		Iterator<Cellule> c6 = getIterateurCellule();
		while(c6.hasNext()){
			liste6.add(SymetrieHorizontale(SymetrieVertivale(c6.next(), -1), -1));
		}
		ArrayList<Cellule> liste7 = new ArrayList<Cellule>();
		Iterator<Cellule> c7 = getIterateurCellule();
		while(c7.hasNext()){
			liste7.add(SymetrieHorizontale(SymetrieVertivale(c7.next(), 1), 1));
		}

		ArrayList<Cellule> liste8 = new ArrayList<Cellule>();
		Iterator<Cellule> c8 = getIterateurCellule();
		while(c8.hasNext()){
			liste8.add(SymetrieHorizontale(SymetrieVertivale(c8.next(), 1), -1));
		}
		
		liste1 = ajouterElement(liste1,liste2);
		liste1 = ajouterElement(liste1,liste3);
		liste1 = ajouterElement(liste1,liste4);
		liste1 = ajouterElement(liste1,liste5);
		liste1 = ajouterElement(liste1,liste6);
		liste1 = ajouterElement(liste1,liste7);
		liste1 = ajouterElement(liste1,liste8);
		
		
		liste1 = ajouterElement(liste1,(ArrayList<Cellule>) getCelluleVivante());	// cellule Vivante pas declarer d'abord 
		Collections.sort(liste1);
		calculerEvolution(liste1);
		
	}
	
	@SuppressWarnings("unchecked")
	public void afficher(){
		for(int i=0;i<11;i++){
			for (int j = 0; j < 11; j++) {
				boolean b = false;
				for(Cellule c :(ArrayList<Cellule>) getCelluleVivante()){
					if(c.getAbscisse() == i && c.getOrdonnee()==j){
						System.out.print(" * ");
						b=true;
					}
				}
				if(!b){
					System.out.print(" - ");
				}
			}System.out.println();
		}System.out.println();
	}
	public static void main(String []args) throws FileNotFoundException, LectureException{
		final PlateauCirculaire cir = new PlateauCirculaire("Dossier_Teste/teste.LIF");
		Timer t = new Timer(500, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cir.afficher();
				cir.evoluer();
			}
		});
		t.start();
		try{
			System.in.read();
		}catch(Exception e){};
	}
}
