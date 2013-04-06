import java.io.FileNotFoundException;

//	gestion des Arguments 

public class Commande {
	
	//	construteur
	
	public Commande(String []args){
		try {
			executer(args);
			
		} catch (CommandeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	private void aider(){
		System.out.println("" +
				"1 : java -jar JeuDeLaVie.jar -name affiche vos noms et prénoms\n"+
				"2 : java -jar JeuDeLaVie.jar -h rappelle la liste des options du programme\n"+
				"3 : java -jar JeuDeLaVie.jar -s d fichier.lif exécute une simulation du jeu\n"+
				"    d’une durée d affichant les configurations du jeu avec le numéro de génération\n"+
				"4 : java -jar JeuDeLaVie.jar -c max fichier.lif calcule le type d’évolution du\n"+
				"    jeu avec ses caractéristiques (taille de la queue, période et déplacement); max représente la durée\n"+
				"    maximale de simulation pour déduire les résultats du calcul.\n"+
				"5 : java -jar JeuDeLaVie.jar -w max dossier calcule le type d’évolution de tous les\n"+
				"jeux contenus dans le dossier passé en paramètre et affiche les résultats sous la forme d’un fichier html.\n");
	}
	/**
	 * Affiche la liste des realisateurs du jeu
	 */
	
	private void groupe(){
		System.out.println(
				"Kouyaté Sory\n" +
				"Melaine\n" +
				"Diallo Youssouf\n" +
				"Cissé Adama Dodo\n");
	}
	
	/**
	 * Fais la simulation d'un jeu sur un temps donné
	 * @param fichier
	 * @param temps
	 * @param jeu
	 */
	
	private void simuler(String fichier,int temps,int jeu){
		JeuDeLaVie j;
		try {
			j = JeuDeLaVieFactory.getJeuDeLaVie(jeu, fichier);
			new Simulation(temps, j);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	
	}
	/**
	 * Création d'un nouveau fichier Html contenant le resultat de
	 * toutes les fichiers Lif dans le dossiers passer en parametre 
	 * sur un temps donné
	 * @param Dossier
	 * @param temps
	 * @param jeu
	 * @param nouveauFichier
	 */
	private void nouveauHtml(String Dossier,int temps,int jeu,String nouveauFichier) {
		try {
			new HTML(Dossier, temps, jeu, nouveauFichier);
		} catch (HtmlException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Analyse du fichier passer en paramètre sur un temps donné 
	 * et Affiche les caracteristiques (
	 * Période , taille queue et déplacement)
	 * @param jeu
	 * @param temps
	 * @param nomfichier
	 */
	
	private void analyserFichier(int jeu,int temps,String nomfichier){
		try {
			ReconnaissanceType re = new ReconnaissanceType(jeu, temps, nomfichier);
			System.out.println(re);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Executer la commande passer en paramètre
	 * @param args
	 * @throws CommandeException
	 */
	
	private void executer(String []args)throws CommandeException{
		if(args.length ==1  ||( args.length ==3 || args.length ==4)){
			if(args.length==1){
				if(args[0].equals("-name"))
						groupe();
				
				else if(args[0].equals("-h"))
						aider();
				
				else
					throw new CommandeException("Commande inconnu !");
			}else if(args.length == 3 || args.length == 4){
				if(args[1].matches("^[0-9]+$")){
					
					int temps = Integer.parseInt(args[1]);
					String nomRepertoire = args[2];
					
					if(args[0].equals("-s") && args.length==3)
						simuler(nomRepertoire,temps,1);
					else if(args[0].equals("-s")){
						try{
							int a = Integer.parseInt(args[3]);
							if(a >=1 && a<=3)
								simuler(nomRepertoire,temps,a);
							else
								throw new CommandeException("l'entier doit etre entre 1 et 3");
						}catch(Exception e){
							throw new CommandeException("le quatrième arguments est un entier");
						}
					}
					if(args[0].equals("-c") && args.length==3)
						analyserFichier(1, temps, nomRepertoire);
					else if(args[0].equals("-c")){
						try{
							int a = Integer.parseInt(args[3]);
							if(a >=1 && a<=3)
								analyserFichier(a, temps, nomRepertoire);
							else
								throw new CommandeException("l'entier doit etre entre 1 et 3");
						}catch(Exception e){
							throw new CommandeException("le quatrième arguments est un entier");
						}
					}
					if(args[0].equals("-w") && args.length==3){
						nouveauHtml(nomRepertoire, temps, 1, "Jeu de la vie");
					}else if(args[0].equals("-w")){
						try{
							int a = Integer.parseInt(args[3]);
							if(a >=1 && a<=3)
								nouveauHtml(nomRepertoire, temps, a, "Jeu de la vie");
							else
								throw new CommandeException("l'entier doit etre entre 1 et 3");
						}catch(Exception e){
							throw new CommandeException("le quatrième arguments est un entier");
						}
					}
				}else
					throw new CommandeException("Le deuxième Argument n'est pas un entier");
			}else{
				
			}
		}else{
			throw new CommandeException("Commande invalide");
		}
	}
}
