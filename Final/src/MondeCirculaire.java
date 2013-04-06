import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
public class MondeCirculaire extends JeuDeLaVie{

	public MondeCirculaire(String nomFichier) throws FileNotFoundException{
		super(nomFichier);

	}
	public int nombreVoisinCellule(Point p){
		int voisinVivant = 0 ;
		ArrayList<Point> m = new ArrayList<Point>();
		for(int i=p.getX()-1;i<=p.getX()+1;i++){
			for(int j=p.getY()-1;j<=p.getY()+1;j++){
				if(i>=getMinX() && i<=getMaxX() && j>=getMinY() && j<=getMaxY()){
					Point k = new Point(i,j);
					if(getJeux().contains(k) && ! k.equals(p)&&!m.contains(k))
						voisinVivant++;
					else if(k.equals(p))
						voisinVivant+=bordure(p);
				}
			}
		}

		return	voisinVivant;
	}

	private Point opposerVertical(Point p){
		if(p.getX()==getMinX()){
			return new Point(getMaxX(),p.getY());
		}else {
			return new Point(getMinX(),p.getY());
		}
	}
	private Point opposerHorizontal(Point p){
		if(p.getY()==getMinY()){
			return new Point(p.getX(), getMaxY());
		}else {
			return new Point(p.getX(),getMinX());
		}
	}	
	private int bordure(Point p){
		int nombre =0;
		Point hautGauche=new Point(getMinX(), getMinY());
		Point hautDroite=new Point(getMinX(), getMaxY());
		Point basGauche = new Point(getMaxX(),getMinY());
		Point basDroite = new Point(getMaxX(),getMaxY());		
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
				if(getJeux().contains(opposerHorizontal(new Point(p.getX()+1,p.getY())))){
					nombre++;
				}
				if(getJeux().contains(opposerVertical(new Point(p.getX(),p.getY()+1)))){
					nombre++;
				}
			}

			else if(p.equals(hautDroite)){
				if(getJeux().contains(opposerHorizontal(new Point(p.getX()+1,p.getY())))){
					nombre++;
				}
				if(getJeux().contains(opposerVertical(new Point(p.getX(),p.getY()-1)))){
					nombre++;
				}
			}
			else if(p.equals(basGauche)){
				if(getJeux().contains(opposerHorizontal(new Point(p.getX()-1,p.getY())))){
					nombre++;
				}
				if(getJeux().contains(opposerVertical(new Point(p.getX(),p.getY()+1)))){
					nombre++;
				}

			}
			if(p.equals(basDroite)){
				if(getJeux().contains(opposerHorizontal(new Point(p.getX()-1,p.getY())))){
					nombre++;
				}
				if(getJeux().contains(opposerVertical(new Point(p.getX(),p.getY()-1)))){
					nombre++;
				}
			}	
		}else {
			if(p.getX()==getMinX() || p.getX()==getMaxX()){
				if(getJeux().contains(opposerVertical(p))){
					nombre++;
				}
				if(getJeux().contains(opposerVertical(new Point(p.getX(),p.getY()+1)))){
					nombre++;
				}
				if(getJeux().contains(opposerVertical(new Point(p.getX(),p.getY()-1)))){
					nombre++;
				}
			}else if(p.getY()==getMinY() || p.getY()==getMaxY()){
				if(getJeux().contains(opposerHorizontal(p))){
					nombre++;
				}
				if(getJeux().contains(opposerHorizontal(new Point(p.getX()+1, p.getY())))){
					nombre++;
				}
				if(getJeux().contains(opposerHorizontal(new Point(p.getX()-1, p.getY())))){
					nombre++;
				}
	
			}
		}
		return nombre;
	}
	private void bordure(Point p,ArrayList<Point>m){
		Point hautGauche=new Point(getMinX(), getMinY());
		Point hautDroite=new Point(getMinX(), getMaxY());
		Point basGauche = new Point(getMaxX(),getMinY());
		Point basDroite = new Point(getMaxX(),getMaxY());		
		if(p.equals(hautGauche)
				|| p.equals(hautDroite)
				|| p.equals(basGauche)
				|| p.equals(basDroite)){
			Point a =opposerHorizontal(p);
			Point b = opposerVertical(p);
			Point c = opposerVertical(opposerHorizontal(p));
			if(getJeux().contains(a) && !m.contains(a)){
				m.add(a);
			}
			if(getJeux().contains(b) && !m.contains(b)){
				m.add(b);
			}
			if(getJeux().contains(c)){
				m.add(c);
			}
			if(p.equals(hautGauche)){
				a = opposerHorizontal(new Point(p.getX()+1,p.getY()));
				b = opposerVertical(new Point(p.getX(),p.getY()+1));
				if(getJeux().contains(a) && !m.contains(a)){
					m.add(a);
				}
				if(getJeux().contains(b)){
					m.add(b);
				}
			}

			else if(p.equals(hautDroite)){
				 a = opposerHorizontal(new Point(p.getX()+1,p.getY()));
				 b = opposerVertical(new Point(p.getX(),p.getY()-1));
				if(getJeux().contains(a) && !m.contains(a)){
					m.add(a);
				}
				if(getJeux().contains(b) && !m.contains(b)){
					m.add(b);
				}
			}
			else if(p.equals(basGauche)){
				a = opposerHorizontal(new Point(p.getX()-1,p.getY()));
				b = opposerVertical(new Point(p.getX(),p.getY()+1));
				if(getJeux().contains(a)&&!m.contains(a)){
					m.add(a);
				}
				if(getJeux().contains(b)){
					m.add(b);
				}
			}
			if(p.equals(basDroite)){
				 a = opposerHorizontal(new Point(p.getX()-1,p.getY()));
				 b = opposerVertical(new Point(p.getX(),p.getY()-1));
				if(getJeux().contains(a) && !m.contains(a)){
					m.add(a);
				}
				if(getJeux().contains(b) && !m.contains(b)){
					m.add(b);
				}
			}	
		}else {
			if(p.getX()==getMinX() || p.getX()==getMaxX()){
				Point a =opposerVertical(p);
				Point b = opposerVertical(new Point(p.getX(),p.getY()+1));
				Point c = opposerVertical(new Point(p.getX(),p.getY()-1));
				if(getJeux().contains(a) && !m.contains(a)){
					m.add(a);
				}
				if(getJeux().contains(b) && !m.contains(b)){
					m.add(b);
				}
				if(getJeux().contains(c) && !m.contains(c)) {
					m.add(c);
				}
			}else if(p.getY()==getMinY() || p.getY()==getMaxY()){
				Point a = opposerHorizontal(p);
				Point b = opposerHorizontal(new Point(p.getX()+1, p.getY()));
				Point c = opposerHorizontal(new Point(p.getX()-1, p.getY()));
				if(getJeux().contains(a) 
						&& !m.contains(a)){
					m.add(a);
				}
				if(getJeux().contains(b) 
						&& !m.contains(b)){
					m.add(b);
				}
				if(getJeux().contains(c) 
						&& !m.contains(c)){
					m.add(c);
				}
	
			}
		}
	}
	public void update(){

		setMinX(0);
		setMaxX(10);
		setMinY(0);
		setMaxY(10);
	}
	
	public void evolutionSuivante(){
		Grille<Point> grille = new Grille<Point>();
		for(int i=getMinX();i<=getMaxY();i++){
			for(int j=getMinY();j<=getMaxY();j++){
				Point p = new Point(i, j);
				if(getJeux().contains(p) && getJeux().containsRegleMort(nombreVoisinCellule(p))){
					grille.ajouterCellule(p);
				}else if(!getJeux().contains(p) && getJeux().containsRegleVie(nombreVoisinCellule(p))){
					grille.ajouterCellule(p);
				}
			}
		}
		getJeux().setCelluleVivante(grille.getCelluleVivante());
		Collections.sort(grille.getCelluleVivante());
		update();
	}

	public static void main(String[]args){
		JeuDeLaVie j;
		try {
			j = new MondeCirculaire("html/jeu.LIF");
			new Simulation(1000, j);
		} catch (FileNotFoundException e) {
		}

	}
}

