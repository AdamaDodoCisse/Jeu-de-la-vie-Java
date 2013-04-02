import java.io.FileNotFoundException;
import java.util.Scanner;


public class Client {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		JeuDeLaVie jeu = new MondeInfini("html/jeu.LIF");
		Simulation sim = new Simulation(100,jeu);
		
		/*ReconnaissanceType rec = new ReconnaissanceType(1, 200,"html/jeu.LIF");
		System.out.println(rec.isOscillation());
		try {
			new HTML("html", 20, 1, "resultat");
		} catch (HtmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
