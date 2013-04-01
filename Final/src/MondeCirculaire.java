import java.io.FileNotFoundException;


public class MondeCirculaire extends JeuDeLaVie{
	
	public MondeCirculaire(String nomFichier) throws FileNotFoundException{
		super(nomFichier);
	}
	public int nombreVoisinCellule(Point p){
		int nombreVoisin = 0;
		if(p.getX()==getMinX() && p.getY()==getMinY()){
			Point t=new Point(getMinX(),p.getY()+1);
			Point y=new Point (p.getX()+1,p.getY());
			Point k=new Point(getMinX(),getMaxY());
			Point x =new Point(getMaxX(),getMinY()); 
			Point z=new Point(p.getX()+1,p.getY()+1);
			if(getJeux().contains(t)){
				nombreVoisin++;
			}if(getJeux().contains(y)){
				nombreVoisin++;
			}
			if(getJeux().contains(k)){
				nombreVoisin++;
			}
			if(getJeux().contains(x)){
				nombreVoisin++;
			}
			
			if(getJeux().contains(z)){
				nombreVoisin++;
			}
			
		}
		else if (p.getX()==getMinX() && p.getY()==getMaxY()){
			Point t=new Point (getMinX(),getMaxY()-1);
			Point z=new Point(getMinX()+1,getMaxY());
			Point y=new Point(getMinX()+1,getMaxY()-1);
			Point k=new Point (getMinX(),getMinY());
			Point x=new Point (getMaxX(),getMaxY());
			
			if(getJeux().contains(t)){
				nombreVoisin++;
				
			}
			
			if(getJeux().contains(y)){
				nombreVoisin++;
				
			}
			
			if(getJeux().contains(z)){
				nombreVoisin++;
				
			}
			
			if(getJeux().contains(k)){
				nombreVoisin++;
				
			}
			if(getJeux().contains(x)){
				nombreVoisin++;
			
			}
		} else if(p.getX()==getMaxX() && p.getY()==getMinY()){
			
			Point t=new Point(getMaxX(),getMinY()+1);
			Point z=new Point(getMaxX()-1,getMinY());
			
			Point y=new Point(getMaxX()-1,getMinY()+1);
			Point k=new Point (getMinX(),getMinY());
			Point x=new Point (getMaxX(),getMaxY());
			
			

			if(getJeux().contains(t)){
				nombreVoisin++;
				
			}

			if(getJeux().contains(y)){
				nombreVoisin++;
				
			}

			if(getJeux().contains(z)){
				nombreVoisin++;
				
			}
			
			if(getJeux().contains(k)){
				nombreVoisin++;
				
			}
			if(getJeux().contains(x)){
				nombreVoisin++;
			
			}
			
		}else if (p.getX()==getMaxX() && p.getY()==getMaxY()){
			Point t=new Point (getMaxX(), getMaxY()-1);
			Point z=new Point (getMaxX()-1,getMaxY()-1);
			Point y=new Point(getMaxX()-1,getMaxY());

			Point k=new Point (getMinX(),getMaxY());
			Point x=new Point (getMaxX(),getMinY());
			

			if(getJeux().contains(t)){
				nombreVoisin++;
				
			}
			

			if(getJeux().contains(z)){
				nombreVoisin++;
				
			}

			if(getJeux().contains(y)){
				nombreVoisin++;
				
			}
			
			if(getJeux().contains(k)){
				nombreVoisin++;
				
			}
			if(getJeux().contains(x)){
				nombreVoisin++;
			
			}
			
		}else if(p.getX()==getMaxX() && p.getY() > getMinY()){
			Point t=new Point (p.getX(),p.getY()-1);
			Point y=new Point (p.getX(),p.getY()+1);
			Point z=new Point (p.getX()-1,p.getY()-1);
			
		Point k=new Point (getMinX(),p.getY());
		Point x=new Point (p.getX()-1,p.getY()+1);		
		
		if(getJeux().contains(t)){
			nombreVoisin++;
		
		}
		
		if(getJeux().contains(y)){
			nombreVoisin++;
		
		}
		if(getJeux().contains(z)){
			nombreVoisin++;
		
		}
		if(getJeux().contains(k)){
			nombreVoisin++;
		
		}
		if(getJeux().contains(x)){
			nombreVoisin++;
		
		}
		} 
		return nombreVoisin;
	}
	public void update(){}
}

