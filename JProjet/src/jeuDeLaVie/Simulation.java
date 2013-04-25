package jeuDeLaVie;
import java.awt.Event; 
import structureDeDonnee.Cellule;
/**
 * <b>Simulation est la classe qui simule l'évolution d'un jeu de la vie </br>
 * dans un terminale</b>
 * <p>
 * Un object simulation est caractérisée par : 
 * <ul>
 * <li>Un jeu de la vie.</li>
 * <li>Une durée de simulation du jeu.</li>
 * </ul>
 * @see JeuDeLaVie
 * </p>
 * @author Cissé,Diallo,kouyate,Melaine
 *
 */ 
public class Simulation {
	/**
	 * Jeu de la vie à simuler.
	 * @see Simulation#getJeu()
	 * @see Simulation#setJeu(JeuDeLaVie)
	 * @see JeuDeLaVie
	 */
	private JeuDeLaVie jeu;
	/**
	 * Durrée de la simulation du jeu de la vie.
	 * @see Simulation#dureeSimulation
	 * @see Simulation#getDureeSimulation()
	 * @see JeuDeLaVie
	 */
	private int dureeSimulation;
	/**
	 * Les entiers définissant la taille de l'ecran d'affichage.
	 */
	private int x1,x2,y1,y2;
	/**
	 * Constructeur Simulation.
	 * @param duree
	 * 				Un entier correspondant à la durée de simulation du jeu de la vie.
	 * @param jeu
	 * 				Un jeu de la vie.
	 * @see Simulation#jeu
	 * @see Simulation#dureeSimulation
	 */
	public Simulation(int duree,JeuDeLaVie jeu){
		this.jeu = jeu;
		this.dureeSimulation = duree;
		//on fixe les variables d'affichage .
		x1 = jeu.getPlateau().getMinAbscisse();
		x2 = x1 + 33;
		y1 = jeu.getPlateau().getMinOrdonnee();
		y2 = y1 + 134;
		
		simuler();
	}
	/**
	 * Afficher 
	 * @param temps
	 */
	public void afficher(int temps){
		int cpt = 0;
		String s="";
		for(int i=0;i<=46;i++){
			if(i==0)
				s = s + "=";
			else if(i==46)
				s = s + "=";
			else 
				s = s + " = ";
		}
		s = s + "\n";
		int pos =0;
		int taille = jeu.getPlateau().getTailleCelluleVivante();
		for(int i= x1-1;i <= x2 ; i++){
			for(int j = y1-1;j <= y2+1 ; j++){
					Cellule k = new Cellule(i,j,-1,true);
					if(j==y1-1){
						s = s + "=";
					}
					else if(j==y2+1){
						s = s + "=";
					}
					else if(pos < taille && jeu.getPlateau().getCellule(pos).equals(k)){
						s = s+"o";
						cpt++;
						pos++;
					}
					else 
						s = s+" ";
			}
			s=s+"\n";
		}
		for(int i=0;i<=46;i++){
			if(i==0)
				s = s + "=";
			else if(i==46)
				s = s + "=";
			else 
				s = s + " = ";
		}
		s +="\nNombre total de cellule vivante = "+jeu.getPlateau().getTailleCelluleVivante()+"\n";
		s = s + "Nombre de cellule vivante afficher = "+cpt+"\n";
		s = s + "Numéro de génération = "+temps+"\n";
		
		System.out.print(s);
	}
	/**
	 * 
	 */
	public void simuler(){
		//on efface l'ecran du terminale
		System.out.println((char)Event.ESCAPE + "[2J");
		//enregistrement de la position actuel du curseur
		System.out.print((char)Event.ESCAPE + "7");
		afficher(0);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int temps=1;
		//simulation du jeu
		while(temps<=dureeSimulation){
			//restorer la position du curseur enregistrer 
			System.out.println((char)Event.ESCAPE + "8");
			//évolution suivante du jeu
			jeu.evolutionSuivante();
			afficher(temps);
			temps++;
			try{
				Thread.sleep(150);
			}catch(Exception e){
				
			}
		}
	}

	/**
	 * Getter jeu
	 * @return Le jeu de la vie.
	 * @see Simulation#jeu
	 */
	public JeuDeLaVie getJeu() {
		return jeu;
	}

	/**
	 * Setter jeu
	 * @param jeu un jeu de la vie
	 * @see Simulation#jeu
	 */
	public void setJeu(JeuDeLaVie jeu) {
		this.jeu = jeu;
	}

	/**
	 * Getter dureeSimulation
	 * @return the dureeSimulation
	 * @see Simulation#dureeSimulation
	 */
	public int getDureeSimulation() {
		return dureeSimulation;
	}

	/**
	 * Setter dureeSimulation
	 * @param dureeSimulation Un entier correspondant à la durée de simulation.
	 * @see Simulation#dureeSimulation
	 */
	
	public void setDureeSimulation(int dureeSimulation) {
		this.dureeSimulation = dureeSimulation;
	}
}
