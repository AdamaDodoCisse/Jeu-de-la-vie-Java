
import java.util.ArrayList;
import java.util.Iterator;
/*
 * 
 */

public class MondeInfini extends JeuDeLaVie{

	public MondeInfini(String nomFichier){
		construireJeu(nomFichier);
	}

	@Override
	public void evolutionSuivante() {
		// TODO Auto-generated method stub
		Iterator<Point> iterator = this.getCelluleVivante().iterator();
		ArrayList<Point> listeSuivante = new ArrayList<Point>();
		while(iterator.hasNext()){
			Point p = (Point)iterator.next();
			verifieCelluleVivante(p,listeSuivante);
		}
		
		this.setCelluleVivante(listeSuivante);
	}

	
	public void testeCelluleVivante(Point p){
		
	}
	
	public void verifieCelluleVivante(Point p,ArrayList<Point> listeSuivante){
		
	
		for(int i=p.getX()-1;i<=p.getX()+1;i++){

			for(int j=p.getY()-1;j<=p.getY()+1;j++){

				Point k = new Point(i,j);
				int nombreVoisin = nombreVoisinCellule(k);
				if(this.getCelluleVivante().contains(k)){
					if(this.getRegleMortCellule().contains(nombreVoisin)){
						listeSuivante.add(k);
					}
				} else {
					if(this.getRegleVieCellule().contains(nombreVoisin)){
						listeSuivante.add(k);
					}
				}
			}
		}
	}
	
	public int nombreVoisinCellule(Point p){
		int voisinVivant = 0 ;
		for(int i=p.getX()-1;i<=p.getX()+1;i++){

			for(int j=p.getY()-1;j<=p.getY()+1;j++){

				Point k = new Point(i,j);

				if(this.getCelluleVivante().contains(k))

					voisinVivant++;
			}
	}
		return voisinVivant;
}
	
}
