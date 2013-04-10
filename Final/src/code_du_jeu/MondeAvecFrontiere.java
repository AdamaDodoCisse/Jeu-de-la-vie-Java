package code_du_jeu;

import java.io.FileNotFoundException;
public class MondeAvecFrontiere extends JeuDeLaVie{
	public MondeAvecFrontiere(String nomFichier) throws FileNotFoundException{
		super(nomFichier,new Grille());
	}
	
	public void update(){}
}
