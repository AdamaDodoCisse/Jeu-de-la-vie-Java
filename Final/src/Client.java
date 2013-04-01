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
	//Simulation sim = new Simulation(20,jeu);
	String line = "n -218 05 -5";
	line = line.replaceAll("[^0-9\\s-]", "");
	Scanner sc = new Scanner(line);
	System.out.println(line);
	while(sc.hasNextInt()){
		System.out.println(sc.next());
	}
	System.out.println("Tout");
	}

}
