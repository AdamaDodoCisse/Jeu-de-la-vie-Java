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
		
		ReconnaissanceType rec = new ReconnaissanceType(1, 200,"jeu.LIF");
		System.out.println(rec.isOscillation());
	}
}
