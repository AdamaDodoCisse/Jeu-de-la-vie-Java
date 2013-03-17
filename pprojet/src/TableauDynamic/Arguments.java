package TableauDynamic;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Timer;

public class Arguments {
	private boolean name = false;
	private boolean option = false;
	private boolean simulation =false;
	private boolean caracteristique_fichier = false;
	private boolean caracteristique_dossier = false;
	private int duree = 0;
	private String repertoire = null;
	public Arguments(String []arguments){
		try{
			Commande(arguments);
			if(name){
				Name();
			}else if(option){
				Option();
			}
			else if(simulation){
				Simulation();
			}else if(caracteristique_fichier){
				try {
					Caracteristique_fichier();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}else if(caracteristique_dossier){
				Caracteristique_dossier();
			}
		}catch(ArgumentsException e){
			System.out.println(e.getMessage());
		};
	}
	private final void Name(){
		System.out.println("| LISTES DES PARTICIPANTS |");
		System.out.println("|                         |");
		System.out.println("|	 NOM  	|   PRENOM    |");
		System.out.println("| Diallo 	|   Youssouf  |");
		System.out.println("| Cissé  	|   Adama Dodo|");
		System.out.println("| Melène	|   XXXXXXXXXX|");
		System.out.println("| Kouyaté	|   Sory      |");
		System.out.println();
	}
	private final void Option(){
		System.out.println("• java -jar JeuDeLaVie.jar -name : affiche les noms et prénoms");
		System.out.println();
		System.out.println("• java -jar JeuDeLaVie.jar -h \nrappelle la liste des options du programme");
		System.out.println();
		System.out.println("• java -jar JeuDeLaVie.jar -s d fichier.lif \nexécute une simulation du jeu d’une durée d affichant les configurations du jeu avec le numéro de génération.");
		System.out.println();
		System.out.println("• java -jar JeuDeLaVie.jar -c max fichier.lif \ncalcule le type d’évolution du jeu avec ses caractéristiques (taille de la queue, période \net déplacement); max représente la durée maximale de simulation pour déduire les résultats du calcul.");
		System.out.println();
		System.out.println("• java -jar JeuDeLaVie.jar -w max dossier \ncalcule le type d’évolution de tous les jeux contenus dans le dossier passé en paramètre \net affiche les résultats sous la forme d’un fichier html.");
		System.out.println();
	}
	private final void Simulation(){
		final ReconnaissanceType re;
		try {
			re = new ReconnaissanceType(repertoire);
			final Timer timer = new Timer(500,new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					re.getPrimoG().Evolution(1);
					System.out.println(re.getPrimoG());
					if(re.getPrimoG().getPeriode() == duree || re.verifStable(re.getPrimoG()) ||re.getPrimoG().getCelluleVivante().size()==0){
						System.exit(0);
					}
					System.out.println((char)Event.ESCAPE + "8");
				}
			});
			timer.start();
			
			try{
				System.in.read();
			}catch(Exception e){}
		} catch (IOException e1) {}
	}
	private final void Caracteristique_fichier() throws IOException{
		ReconnaissanceType t;
		t=new ReconnaissanceType(repertoire);
		for(int i=0;i<duree;i++){
			if(!t.isInconnu()){
				break;
			}
			t.getPrimoG().Evolution(1);
			t.getSeconG().Evolution(2);
			t.structure();
		}
		if(t.isInconnu()){
			System.out.println(" Type inconnu");
			
		} 
		else if(t.isMort()){
			System.out.println(" Type Mort sur une periode egal à : "+ t.periodeFinal);
			
		}else if(t.isStabilite()){
			System.out.println(" Type Stable sur une periode egal à : "+ t.periodeFinal);
		}
		else if (t.isOscillation()){
			System.out.println(" Type oscillation sur une periode egal à : "+ t.periodeFinal);
		} else if (t.isVaisceau()){
			System.out.println(" Type vaisceau sur une periode egal à : "+ t.periodeFinal);
		}	
	}
	private void Caracteristique_dossier(){
		try {
			new HTML(repertoire, duree);
		} catch (IOException e) {
			System.out.println(e.getCause());
		}
	}
	private final void Commande(String[] arguments)throws ArgumentsException{
		if(arguments.length==1){
			if(arguments[0].equals("-name")){
				name=true;
			}
			else if(arguments[0].equals("-h")){
				option = true;
			}
			else{
				throw new ArgumentsException("<< Erreur d'arguments :... \nTapez : java -jar JeuDeLaVie.jar -h pour voir l'aide !!!");
			}
		}else if(arguments.length == 3 ){
			if(arguments[0].equals("-s") && arguments[1].matches("^[0-9]+$")){
				simulation = true;
				repertoire = arguments[2];
				duree = Integer.parseInt(arguments[1]);
			}
			else if (arguments[0].equals("-c") && arguments[1].matches("^[0-9]+$")){
				caracteristique_fichier = true;
				repertoire = arguments[2];
				duree = Integer.parseInt(arguments[1]);
			}else if (arguments[0].equals("-w") && arguments[1].matches("^[0-9]+$")){
				caracteristique_dossier = true;
				repertoire = arguments[2];
				duree = Integer.parseInt(arguments[1]);
			} else{
				throw new ArgumentsException("<< Erreur d'arguments :... \nTapez : java -jar JeuDeLaVie.jar -h pour voir l'aide !!!");
			}
		}else {
			throw new ArgumentsException("<< Erreur d'arguments :... \nTapez : java -jar JeuDeLaVie.jar -h pour voir l'aide !!!");
		}
	}
}
