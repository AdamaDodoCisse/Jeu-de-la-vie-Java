import java.io.FileNotFoundException;

//	gestion des Arguments 

public class Commande {
	
	//	construteur
	
	public Commande(String []args){
		try {
			initialiser(args);
			
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
	
	private void groupe(){
		System.out.println(
				"Kouyaté Sory\n" +
				"Melaine\n" +
				"Diallo Youssouf\n" +
				"Cissé Adama Dodo\n");
	}
	
	private void simuler(String fichier,int temps,int jeu){
		JeuDeLaVie j;
		try {
			j = JeuDeLaVieFactory.getJeuDeLaVie(jeu, fichier);
			new Simulation(temps, j);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	private void nouveauHtml(String Dossier,int temps,int jeu,String nouveauFichier) {
		try {
			new HTML(Dossier, temps, jeu, nouveauFichier);
		} catch (HtmlException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void initialiser(String []args)throws CommandeException{
		if(args.length ==1  ||( args.length ==3 || args.length ==4)){
			if(args.length==1){
				if(args[0].equals("-name"))
						groupe();
				else if(args[0].equals("-h"))
					aider();
				else
					throw new CommandeException("Commande inconnu !");
			}else if(args.length == 3){
				if(args[1].matches("^[0-9]+$")){
					int temps = Integer.parseInt(args[1]);
					if(args[0].equals("-s"))
						simuler(args[2],temps,1);
					else if(args[0].equals("-c")){
						try {
							ReconnaissanceType re = new ReconnaissanceType(1, temps, args[2]);
							System.out.println(re);
						} catch (FileNotFoundException e) {
							System.out.println(e.getMessage());
						}
					}else if(args[0].equals("-w")){
							nouveauHtml(args[2], temps, 1, "Jeu de la vie");
					}
				}else
					throw new CommandeException("Le deuxième Argument n'est pas un entier");
			}
		}else{
			throw new CommandeException("Commande invalide");
		}
	}
}
