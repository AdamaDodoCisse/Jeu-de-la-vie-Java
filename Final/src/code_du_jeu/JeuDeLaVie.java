package code_du_jeu;

import interface_.Jeu;
import interface_.StructureDeDonnee;

import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Iterator;




public class JeuDeLaVie implements Jeu{
	private StructureDeDonnee jeux;
	private StructureDeDonnee clone;
	private int minX,minY,maxX,maxY;
	public JeuDeLaVie(StructureDeDonnee grille){
		jeux = grille.clone();
		clone=grille.clone(); 
		minX = minY = maxY = maxX = 0;
	}


	public JeuDeLaVie(String nomFichier,StructureDeDonnee grille) throws FileNotFoundException{
		minX = minY = maxY = maxX = 0;
		jeux = grille.clone();
		clone=grille.clone();
		LectureJeuDeLaVie.LectureJeu(nomFichier,jeux);
		update();
	}

	public void update(){
		Iterator<Cellule> iterator = jeux.iterer();
		while(iterator.hasNext()){
			Cellule p = iterator.next();
			if(p.getX()<minX)
				minX = p.getX();
			else if(p.getX()>maxX)
				maxX = p.getX();
			else if(p.getY()<minY)
				minY = p.getY();
			else if(p.getY()>maxY)
				maxY = p.getY();
		}
	}

	public void evolutionSuivante(){
		StructureDeDonnee g = clone.clone();
		g.initialise();
		Iterator<Cellule> iterator =jeux.iterer();
		while(iterator.hasNext()){
			Cellule p = iterator.next();
			calclulercelluleVivante((StructureDeDonnee) g, p);
		}

		jeux.setCelluleVivante(((StructureDeDonnee) g).getCelluleVivante());
		jeux.trierCellule();
		update();

	}

	public void calclulercelluleVivante(StructureDeDonnee grille,Cellule p){
		for(int i=p.getX()-1;i<=p.getX()+1;i++){
			for(int j=p.getY()-1;j<=p.getY()+1;j++){
				Cellule k = new Cellule(i,j);
				if(jeux.contains(k)){
					if( ! celluleMourante(k)
							&& ! grille.contains(k)){
						grille.ajouterCellule(k);
					}
				} else {
					if(celluleNaissante(k)
							&& ! grille.contains(k)
							&& ajouterCellule(k)){
						grille.ajouterCellule(k);
					}
				}
			}
		}
	}

	public boolean celluleMourante(Cellule p){
		int nombreVoisin = nombreVoisinCellule(p);
		if( ! jeux.containsRegleMort(nombreVoisin) ){
			return true;
		}
		return false;
	}

	public boolean celluleNaissante(Cellule p){
		int nombreVoisin = nombreVoisinCellule(p);
		if( jeux.containsRegleVie(nombreVoisin) ){
			return true;
		}
		return false;
	}

	public int nombreVoisinCellule(Cellule p){
		int voisinVivant = 0 ;
		for(int i=p.getX()-1;i<=p.getX()+1;i++){
			for(int j=p.getY()-1;j<=p.getY()+1;j++){

				Cellule k = new Cellule(i,j);

				if(jeux.contains(k) && ! k.equals(p))

					voisinVivant++;
			}
		}
		return voisinVivant;
	}

	public boolean ajouterCellule(Cellule p){
		if(p.getX()>=minX && p.getX()<= maxX && p.getY()>=minY && p.getY()<=maxY)
			return true;
		return false;
	}


	public StructureDeDonnee getJeux() {
		return jeux;
	}

	public void setJeux(StructureDeDonnee jeux) {
		this.jeux = jeux;
	}


	public int getMinX() {
		return minX;
	}

	public void setMinX(int minX) {
		this.minX = minX;
	}

	public int getMinY() {
		return minY;
	}

	public void setMinY(int minY) {
		this.minY = minY;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
}
