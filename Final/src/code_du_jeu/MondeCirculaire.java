package code_du_jeu;

import interface_.StructureDeDonnee;

import java.io.FileNotFoundException;

import Evolution.Simulation;
public class MondeCirculaire extends JeuDeLaVie{
	private StructureDeDonnee clone;
	public MondeCirculaire(String nomFichier,StructureDeDonnee structure) throws FileNotFoundException{
		super(nomFichier,structure);
		clone = structure.clone();

	}
	
	public int nombreVoisinCellule(Cellule p){
		int voisinVivant = 0 ;
		for(int i=p.getX()-1;i<=p.getX()+1;i++){
			for(int j=p.getY()-1;j<=p.getY()+1;j++){
				if(i>=getMinX() && i<=getMaxX() && j>=getMinY() && j<=getMaxY()){
					Cellule k = new Cellule(i,j);
					if(getJeux().contains(k) && ! k.equals(p))
						voisinVivant++;
					else if(k.equals(p))
						voisinVivant+=bordure(p);
				}
			}
		}

		return	voisinVivant;
	}

	private Cellule opposerVertical(Cellule p){
		if(p.getX()==getMinX()){
			return new Cellule(getMaxX(),p.getY());
		}else {
			return new Cellule(getMinX(),p.getY());
		}
	}
	private Cellule opposerHorizontal(Cellule p){
		if(p.getY()==getMinY()){
			return new Cellule(p.getX(), getMaxY());
		}else {
			return new Cellule(p.getX(),getMinX());
		}
	}	
	private int bordure(Cellule p){
		int nombre =0;
		Cellule hautGauche=new Cellule(getMinX(), getMinY());
		Cellule hautDroite=new Cellule(getMinX(), getMaxY());
		Cellule basGauche = new Cellule(getMaxX(),getMinY());
		Cellule basDroite = new Cellule(getMaxX(),getMaxY());		
		if(p.equals(hautGauche)
				|| p.equals(hautDroite)
				|| p.equals(basGauche)
				|| p.equals(basDroite)){
			if(getJeux().contains(opposerHorizontal(p)))
				nombre++;
			if(getJeux().contains(opposerVertical(p)))
				nombre++;
			if(getJeux().contains(opposerVertical(opposerHorizontal(p))))
				nombre++;
			if(p.equals(hautGauche)){
				if(getJeux().contains(opposerHorizontal(new Cellule(p.getX()+1,p.getY())))){
					nombre++;
				}
				if(getJeux().contains(opposerVertical(new Cellule(p.getX(),p.getY()+1)))){
					nombre++;
				}
			}

			else if(p.equals(hautDroite)){
				if(getJeux().contains(opposerHorizontal(new Cellule(p.getX()+1,p.getY())))){
					nombre++;
				}
				if(getJeux().contains(opposerVertical(new Cellule(p.getX(),p.getY()-1)))){
					nombre++;
				}
			}
			else if(p.equals(basGauche)){
				if(getJeux().contains(opposerHorizontal(new Cellule(p.getX()-1,p.getY())))){
					nombre++;
				}
				if(getJeux().contains(opposerVertical(new Cellule(p.getX(),p.getY()+1)))){
					nombre++;
				}

			}
			if(p.equals(basDroite)){
				if(getJeux().contains(opposerHorizontal(new Cellule(p.getX()-1,p.getY())))){
					nombre++;
				}
				if(getJeux().contains(opposerVertical(new Cellule(p.getX(),p.getY()-1)))){
					nombre++;
				}
			}	
		}else {
			if(p.getX()==getMinX() || p.getX()==getMaxX()){
				if(getJeux().contains(opposerVertical(p))){
					nombre++;
				}
				if(getJeux().contains(opposerVertical(new Cellule(p.getX(),p.getY()+1)))){
					nombre++;
				}
				if(getJeux().contains(opposerVertical(new Cellule(p.getX(),p.getY()-1)))){
					nombre++;
				}
			}else if(p.getY()==getMinY() || p.getY()==getMaxY()){
				if(getJeux().contains(opposerHorizontal(p))){
					nombre++;
				}
				if(getJeux().contains(opposerHorizontal(new Cellule(p.getX()+1, p.getY())))){
					nombre++;
				}
				if(getJeux().contains(opposerHorizontal(new Cellule(p.getX()-1, p.getY())))){
					nombre++;
				}

			}
		}
		return nombre;
	}
	public void update(){
		setMinX(0);
		setMaxX(10);
		setMinY(0);
		setMaxY(10);
	}
 
	public void evolutionSuivante(){
		StructureDeDonnee structure = clone.clone();
		structure.initialise();
		for(int i=getMinX();i<=getMaxY();i++){
			for(int j=getMinY();j<=getMaxY();j++){
				Cellule p = new Cellule(i, j);
				if(getJeux().contains(p) && getJeux().containsRegleMort(nombreVoisinCellule(p))){
					structure.ajouterCellule(p);
				}else if(!getJeux().contains(p) && getJeux().containsRegleVie(nombreVoisinCellule(p))){
					structure.ajouterCellule(p);
				}
			}
		}
		getJeux().setCelluleVivante(structure.getCelluleVivante());
		getJeux().trierCellule();
		update();
	}


}


