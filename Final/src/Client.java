import java.io.FileNotFoundException;


public class Client {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		JeuDeLaVie jeu = new MondeInfini("jeu.LIF");
		Simulation simule = new Simulation(6,jeu);
	}

}
