import java.io.FileNotFoundException;


public class MondeInfini extends JeuDeLaVie{
	
	public MondeInfini(String nomFichier) throws FileNotFoundException{
		super(nomFichier);
	}

	@Override
	public boolean ajouterCellule(Point p){
		return true;
	}
	
}
	

