
public class Simulation {
	private int dureeSimulation;
	private JeuDeLaVie jeu;
	
	public Simulation(int d,JeuDeLaVie j){
		this.dureeSimulation = d;
		this.jeu = j;
		simuler();
	}
	
	public void simuler(){
		int temps = 0;
		afficher();
		while(temps<=dureeSimulation){
			jeu.evolutionSuivante();
			afficher();
			temps ++ ;
			
		}
	}
	public void afficher(){
		
	}
	public int getDureeSimulation() {
		return dureeSimulation;
	}

	public void setDureeSimulation(int dureeSimulation) {
		this.dureeSimulation = dureeSimulation;
	}

	public JeuDeLaVie getJeu() {
		return jeu;
	}

	public void setJeu(JeuDeLaVie jeu) {
		this.jeu = jeu;
	}
	


}