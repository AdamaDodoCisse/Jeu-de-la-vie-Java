import java.io.FileNotFoundException;
import java.util.*;

/**
 * 
 * @author kouyate,Cisse,Melaine,Diallo
 *
 */
public class JeuDeLaVie implements Jeu{
	private Grille<Point> jeux;
	private int minX,minY,maxX,maxY;
	private boolean estStable = false;
	public JeuDeLaVie(){
		jeux = new Grille<Point>();
		minX = minY = maxY = maxX = 0;
	}
	
	public JeuDeLaVie(String nomFichier) throws FileNotFoundException{
		minX = minY = maxY = maxX = 0;
		jeux = new Grille<Point>();
		 LectureJeuDeLaVie.LectureJeu(nomFichier,jeux);
		 update();
	}
	
	public void update(){
		Iterator<Point> iterator = jeux.iterer();
		while(iterator.hasNext()){
			Point p = iterator.next();
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
		Grille<Point> g = new Grille<Point>();
		
		Iterator<Point> iterator =jeux.iterer();
		
		while(iterator.hasNext()){
			Point p = iterator.next();
			calclulercelluleVivante(g, p);
		}
		
		estStable = g.getCelluleVivante().equals(getJeux().getCelluleVivante());
		
		jeux.setCelluleVivante(g.getCelluleVivante());
		Collections.sort(jeux.getCelluleVivante());
		update();
	}
	
	public void calclulercelluleVivante(Grille<Point> grille,Point p){
		for(int i=p.getX()-1;i<=p.getX()+1;i++){
			for(int j=p.getY()-1;j<=p.getY()+1;j++){
				Point k = new Point(i,j);
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
	
	public boolean celluleMourante(Point p){
		int nombreVoisin = nombreVoisinCellule(p);
		if( ! jeux.containsRegleMort(nombreVoisin) ){
			return true;
		}
		return false;
	}
	
	public boolean celluleNaissante(Point p){
		int nombreVoisin = nombreVoisinCellule(p);
		if( jeux.containsRegleVie(nombreVoisin) ){
			return true;
		}
		return false;
	}
	
	public int nombreVoisinCellule(Point p){
		int voisinVivant = 0 ;
		for(int i=p.getX()-1;i<=p.getX()+1;i++){

			for(int j=p.getY()-1;j<=p.getY()+1;j++){

				Point k = new Point(i,j);

				if(jeux.getCelluleVivante().contains(k) && ! k.equals(p))

					voisinVivant++;
			}
		}
	return voisinVivant;
	}
	
	public boolean ajouterCellule(Point p){
		if(p.getX()>=minX && p.getX()<= maxX && p.getY()>=minY && p.getY()<=maxY)
			return true;
		return false;
	}
	
	public boolean estStable(){
		return estStable;
	}

	public Grille<Point> getJeux() {
		return jeux;
	}

	public void setJeux(Grille<Point> jeux) {
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
