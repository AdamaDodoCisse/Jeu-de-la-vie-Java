package structureDeDonnee;
import java.io.FileNotFoundException;

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
}
