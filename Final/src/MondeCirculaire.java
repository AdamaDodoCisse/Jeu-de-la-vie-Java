import java.io.FileNotFoundException;
public class MondeCirculaire extends JeuDeLaVie{
	
	public MondeCirculaire(String nomFichier) throws FileNotFoundException{
		super(nomFichier);
		
	}
	public int nombreVoisinCellule(Point p){
		int voisinVivant = 0 ;
		for(int i=p.getX()-1;i<=p.getX()+1;i++){
			for(int j=p.getY()-1;j<=p.getY()+1;j++){
				Point k = new Point(i,j);
				if(getJeux().contains(k) && ! k.equals(p))
					voisinVivant ++ ;
				if(k.equals(p))
					voisinVivant +=bordure(p);
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
						if(getJeux().contains(opposerVertical(new Point(p.getX()+1,p.getY()))))
							nombre++;
						if(getJeux().contains(opposerHorizontal(new Point(p.getX(),p.getY()+1))));
							nombre++;
					}
					
					if(p.equals(hautDroite)){
						if(getJeux().contains(opposerVertical(new Point(p.getX()+1,p.getY()))))
							nombre++;
						if(getJeux().contains(opposerHorizontal(new Point(p.getX(),p.getY()-1))));
							nombre++;
					}
					if(p.equals(basGauche)){
						if(getJeux().contains(opposerVertical(new Point(p.getX()-1,p.getY()))))
							nombre++;
						if(getJeux().contains(opposerHorizontal(new Point(p.getX(),p.getY()+1))));
							nombre++;
						
					}
					if(p.equals(basDroite)){
						if(getJeux().contains(opposerVertical(new Point(p.getX()-1,p.getY()))))
							nombre++;
						if(getJeux().contains(opposerHorizontal(new Point(p.getX(),p.getY()-1))));
							nombre++;
						
					}
					
						
				}else if(p.getX()==getMinX() || p.getX()==getMaxX()){
					if(getJeux().contains(opposerVertical(p)))
						nombre++;
					if(getJeux().contains(opposerVertical(new Point(p.getX()-1,p.getY()))))
						nombre++;
					if(getJeux().contains(opposerVertical(new Point(p.getX()+1,p.getY()))))
						nombre++;
				}else if(p.getY()==getMinY() || p.getY()==getMaxY()){
					if(getJeux().contains(opposerVertical(p)))
						nombre++;
					if(getJeux().contains(opposerHorizontal(new Point(p.getX(),p.getY()+1))))
						nombre++;
					if(getJeux().contains(opposerHorizontal(new Point(p.getX(),p.getY()-1))))
						nombre++;
				}
				
				return nombre;
	}
	public void update(){
		
		setMinX(0);
		setMaxX(10);
		setMinY(0);
		setMaxY(10);
	}
	
	public static void main(String[]args){
		JeuDeLaVie j;
		try {
			j = new MondeCirculaire("html/jeu.LIF");
			new Simulation(20, j);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

