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
		
	}
	
	private void groupe(){
		System.out.println(
				"Kouyaté Sory" +
				"Melaine" +
				"Diallo Youssouf" +
				"Cissé Adama Dodo");
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
				if(args[0]=="-name")
						groupe();
				else if(args[0]=="-h")
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
							System.out.println(re.getConfiguration1());
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
