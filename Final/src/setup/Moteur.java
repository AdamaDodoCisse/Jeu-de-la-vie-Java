package setup;
import code_du_jeu.Grille;
import Evolution.Commande;
public class Moteur {
	public static void main(String []args){
		new Commande(args,new Grille());
	}
	
}
