
public class JeuDeLaVieFactory {
	public static final int MONDE_INFINI = 1 ;
	public static final int MONDE_CIRCULAIRE = 2;
	public static final int MONDE_AVEC_FRONTIERE = 3;
	
	public JeuDeLaVie getJeuDeLaVie(int typeJeu,String nomFichier){
		JeuDeLaVie jeu = null;
		
		switch(typeJeu){
		case MONDE_INFINI : 
			jeu = new MondeInfini(nomFichier);
			break;
		case MONDE_CIRCULAIRE : 
			jeu = new MondeCirculaire(nomFichier);
			break;
		case MONDE_AVEC_FRONTIERE : 
			jeu = new MondeAvecFrontiere(nomFichier);
			break;
		default : 
			throw new IllegalArgumentException("Type de jeu Inconnu");
			
		}
		return jeu;
			
	}
	
}
