import java.io.FileNotFoundException;
import java.util.Scanner;


public class Client {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		JeuDeLaVie jeu = new MondeInfini("jeu.LIF");
		//Simulation sim = new Simulation(100,jeu);
		
		ReconnaissanceType rec = new ReconnaissanceType(jeu, 100);
	}
}
