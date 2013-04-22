package structureDeDonnee;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import exception.LectureException;

import jeuDeLaVie.JeuDeLaVie;

/**
 * <b>PlateauCirculaire est la classe répresentant une structure de donnée du jeu de la vie </br>
 * dans un plateau circulaire(Monde circulaire).</b>
 * Elle hérite de la classe {@link PlateauFini}.
 * @see JeuDeLaVie
 * @author kouyate
 */
public class PlateauCirculaire extends PlateauFini {
	
	public PlateauCirculaire(String nomFichier) throws FileNotFoundException, LectureException {
		super(nomFichier);
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see structure.StructureDeDonnee#getNombreVoisin(structure.Cellule)
	 */
/*	@Override
	public int getNombreVoisin(Cellule p){
		int voisinVivant = 0 ;
		for(int i=p.getAbscisse()-1;i<=p.getAbscisse()+1;i++){
			for(int j=p.getOrdonnee()-1;j<=p.getOrdonnee()+1;j++){
				if(i>=getMinAbscisse() && i<=getMaxAbscisse() && j>=getMinOrdonnee() && j<=getMaxOrdonnee()){
					Cellule k = new Cellule(i,j);
					if(contains(k) && ! k.equals(p))
						voisinVivant++;
					else if(k.equals(p))
						voisinVivant += nombreVoisinBord(p);
				}
			}
		}
		System.out.println(voisinVivant);
		return	voisinVivant;
	}
	/**
	 * Calcule l'opposé d'une cellule.
	 * @param p
	 * 			Une cellule vivante.
	 * @return	Une cellule correspondant à l'opposé de la cellule passée en paramètre.
	 * @see Cellule
	 */
	/*private Cellule opposerVertical(Cellule p){
		if(p.getAbscisse()==getMinAbscisse()){
			return new Cellule(getMaxAbscisse(),p.getOrdonnee());
		}else {
			return new Cellule(getMinAbscisse(),p.getOrdonnee());
		}
	}
	/**
	 * Calcule l'opposé d'une cellule.
	 * @param p
	 * 			Une cellule vivante.
	 * @return	Une cellule correspondant à l'opposé de la cellule passée en paramètre.
	 * @see Cellule
	 */
/*	private Cellule opposerHorizontal(Cellule p){
		if(p.getOrdonnee()==getMinOrdonnee()){
			return new Cellule(p.getAbscisse(), getMaxOrdonnee());
		}else {
			return new Cellule(p.getAbscisse(),getMinOrdonnee());
		}
	}
	/**
	 * Calcul le nombre de voisin d'une cellule dans un plateau circulaire.
	 * @param p
	 * 				Une cellule vivante.
	 * @return Un entier correspondant aux nombres de voisins vivants de la cellule passée en paramètre. 
	 * @see Cellule
	 * @see PlateauCirculaire
	 * @see JeuDeLaVie
	 */
	/*private int nombreVoisinBord(Cellule p){
		int nombre =0;
		Cellule hautGauche=new Cellule(getMinAbscisse(), getMinOrdonnee());
		Cellule hautDroite=new Cellule(getMinAbscisse(), getMaxOrdonnee());
		Cellule basGauche = new Cellule(getMaxAbscisse(),getMinOrdonnee());
		Cellule basDroite = new Cellule(getMaxAbscisse(),getMaxOrdonnee());		
		if(p.equals(hautGauche)
				|| p.equals(hautDroite)
				|| p.equals(basGauche)
				|| p.equals(basDroite)){
			if(contains(opposerHorizontal(p)))
				nombre++;
			if(contains(opposerVertical(p)))
				nombre++;
			if(contains(opposerVertical(opposerHorizontal(p))))
				nombre++;
			if(p.equals(hautGauche)){
				if(contains(opposerHorizontal(new Cellule(p.getAbscisse()+1,p.getOrdonnee())))){
					nombre++;
				}
				if(contains(opposerVertical(new Cellule(p.getAbscisse(),p.getOrdonnee()+1)))){
					nombre++;
				}
			}

			else if(p.equals(hautDroite)){
				if(contains(opposerHorizontal(new Cellule(p.getAbscisse()+1,p.getOrdonnee())))){
					nombre++;
				}
				if(contains(opposerVertical(new Cellule(p.getAbscisse(),p.getOrdonnee()-1)))){
					nombre++;
				}
			}
			else if(p.equals(basGauche)){
				if(contains(opposerHorizontal(new Cellule(p.getAbscisse()-1,p.getOrdonnee())))){
					nombre++;
				}
				if(contains(opposerVertical(new Cellule(p.getAbscisse(),p.getOrdonnee()+1)))){
					nombre++;
				}

			}
			if(p.equals(basDroite)){
				if(contains(opposerHorizontal(new Cellule(p.getAbscisse()-1,p.getOrdonnee())))){
					nombre++;
				}
				if(contains(opposerVertical(new Cellule(p.getAbscisse(),p.getOrdonnee()-1)))){
					nombre++;
				}
			}	
		}else {
			if(p.getAbscisse()==getMinAbscisse() || p.getAbscisse()==getMaxAbscisse()){
				if(contains(opposerVertical(p))){
					nombre++;
				}
				if(contains(opposerVertical(new Cellule(p.getAbscisse(),p.getOrdonnee()+1)))){
					nombre++;
				}
				if(contains(opposerVertical(new Cellule(p.getAbscisse(),p.getOrdonnee()-1)))){
					nombre++;
				}
			}else if(p.getOrdonnee()==getMinOrdonnee() || p.getOrdonnee()==getMaxOrdonnee()){
				if(contains(opposerHorizontal(p))){
					nombre++;
				}
				if(contains(opposerHorizontal(new Cellule(p.getAbscisse()+1, p.getOrdonnee())))){
					nombre++;
				}
				if(contains(opposerHorizontal(new Cellule(p.getAbscisse()-1, p.getOrdonnee())))){
					nombre++;
				}

			}
		}
		return nombre;
	} */
	
	
	public ArrayList<Cellule> translation(int x,int y){
		ArrayList<Cellule> nouvelleTranslation = new ArrayList<Cellule>();
		Iterator<Cellule> it = getIterateurCellule();
		
		
		return nouvelleTranslation;
	}
	
	private Cellule SymetrieHorizontale(Cellule cellule,int increment){
		if(increment < 0){
			if(cellule.getOrdonnee() == getMinOrdonnee()){
				return new Cellule(cellule.getAbscisse(), getMaxOrdonnee(), 1, false);
			}else{
				return new Cellule(cellule.getAbscisse(),cellule.getOrdonnee() - increment, 1 , false);
			}
		}else{
			if(cellule.getOrdonnee() == getMaxOrdonnee()){
				return new Cellule(cellule.getAbscisse(), getMinAbscisse(), 1, false);
			}else{
				return new Cellule(cellule.getAbscisse(), cellule.getOrdonnee() + increment, 1, false);
			}
		}	
	}
	
	private Cellule SymetrieVertivale(Cellule cellule,int increment){
		if(increment < 0 ){
			if(cellule.getAbscisse() == getMinAbscisse()){
				return new Cellule(getMaxAbscisse(), cellule.getOrdonnee(), 1, false);
			}else{
				return new Cellule(cellule.getAbscisse() - increment,cellule.getOrdonnee(), 1 , false);
			}
		}else{
			if(cellule.getAbscisse() == getMaxAbscisse()){
				return new Cellule(getMinAbscisse(), cellule.getOrdonnee(), 1, false);
			}else{
				return new Cellule(cellule.getAbscisse() + increment, cellule.getAbscisse(), 1, false);
			}
		}	
	}
	
	
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
			liste5.add(SymetrieVertivale(SymetrieHorizontale(c5.next(), -1), 1));
		}
		ArrayList<Cellule> liste6 = new ArrayList<Cellule>();
		Iterator<Cellule> c6 = getIterateurCellule();
		while(c6.hasNext()){
			liste6.add(SymetrieVertivale(SymetrieHorizontale(c5.next(), -1), -1));
		}
		ArrayList<Cellule> liste7 = new ArrayList<Cellule>();
		Iterator<Cellule> c7 = getIterateurCellule();
		while(c7.hasNext()){
			liste7.add(SymetrieHorizontale(SymetrieVertivale(c.next(), 1), 1));
		}

		ArrayList<Cellule> liste8 = new ArrayList<Cellule>();
		Iterator<Cellule> c8 = getIterateurCellule();
		while(c7.hasNext()){
			liste8.add(SymetrieHorizontale(SymetrieVertivale(c.next(), 1), -1));
		}
		
		liste1 = ajouterElement(liste1,liste2);
		liste1 = ajouterElement(liste1,liste3);
		liste1 = ajouterElement(liste1,liste4);
		liste1 = ajouterElement(liste1,liste5);
		liste1 = ajouterElement(liste1,liste6);
		liste1 = ajouterElement(liste1,liste7);
		liste1 = ajouterElement(liste1,liste8);
		liste1 = ajouterElement(liste1,null);	// cellule Vivante pas declarer d'abord 
		Collections.sort(liste1);
		calculerEvolution(liste1);
		
	}
}
