import java.io.FileNotFoundException;


public class MondeInfini extends JeuDeLaVie{
	
	public MondeInfini(String nomFichier,StructureDeDonnee grille) throws FileNotFoundException{
		super(nomFichier,grille);
	}

	@Override
	public boolean ajouterCellule(Point p){
		return true;
	}
}
	

