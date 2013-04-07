import java.io.FileNotFoundException;


public class Client {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		JeuDeLaVie jeu = new MondeInfini("html/jeu.LIF",new Grille());
		Simulation simule = new Simulation(20,jeu);
	}

}
