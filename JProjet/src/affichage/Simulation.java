package affichage;
import java.awt.Event; 
import java.io.IOException;
import java.util.Iterator;
import exception.LectureException;

import structureDeDonnee.Cellule;
import structureDeDonnee.PlateauInfini;
import jeuDeLaVie.JeuDeLaVie;
/**
 * <b>Simulation est la classe qui simule l'evolution d'un jeu de la vie dans </br>
 * un temps déterminer dans un terminale</b>
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
	 * 				Un entier correspondant à la durrée de simulation du jeu de la vie.
	 * @param jeu
	 * 				Un jeu de la vie.
	 * @see Simulation#jeu
	 * @see Simulation#dureeSimulation
	 */
	public Simulation(int duree,JeuDeLaVie jeu){
		this.jeu = jeu;
		this.dureeSimulation = duree;
		x1=x2=y1=y2=0;
		updateVariableAffichage();
		
		simuler();
	}
	/**
	 * 
	 * @param x1
	 * @param x2
	 * @param y1
	 * @param y2
	 */
	public void afficher(int x1,int x2,int y1,int y2){
		int cpt = 0;
		String s = " ";
		for(int i=x1-1;i<=y2+1;i++)
			s = s+" = ";
		
		s=s+"\n";
		for(int i=x1-1;i<=x2+1;i++){
			for(int j=y1-1;j<=y2+1;j++){
				if(j==y1-1)
					s=s+" = ";
				else if(j==y2+1)
					s=s+" = ";
				else{
					Cellule k = new Cellule(i,j,-1,true);
					if(jeu.getPlateau().contains(k)){
						s = s+" o ";
						cpt++;
					}
					else 
						s = s+" - ";
				}
			}
			s=s+"\n";
		}
		for(int i=x1-1;i<=y2+1;i++)
			s = s+" = ";
		s +="\nNombre total de cellule vivante = "+jeu.getPlateau().getTailleCelluleVivante()+"\n";
		s = s + "Nombre de cellule vivante afficher = "+cpt+"\n";
		System.out.print(s);
	}
	public void simuler(){
		System.out.println((char)Event.ESCAPE + "[2J");
		System.out.print((char)Event.ESCAPE + "7");
		updateVariableAffichage();
		afficher(x1,x2,y1,y2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int temps=0;
		while(temps<dureeSimulation){
			System.out.println((char)Event.ESCAPE + "8");
			jeu.evolutionSuivante();
			afficher(x1,x2,y1,y2);
			temps++;
			try{
				Thread.sleep(500);
			}catch(Exception e){
				
			}
		}
	}

	/**
	 * @return the jeu
	 */
	public JeuDeLaVie getJeu() {
		return jeu;
	}

	/**
	 * @param jeu the jeu to set
	 */
	public void setJeu(JeuDeLaVie jeu) {
		this.jeu = jeu;
	}

	/**
	 * @return the dureeSimulation
	 */
	public int getDureeSimulation() {
		return dureeSimulation;
	}

	/**
	 * @param dureeSimulation the dureeSimulation to set
	 */
	public void setDureeSimulation(int dureeSimulation) {
		this.dureeSimulation = dureeSimulation;
	}
	public void updateVariableAffichage(){
		Iterator<Cellule> iterateur = jeu.getPlateau().getIterateurCellule();
		while(iterateur.hasNext()){
			Cellule c = iterateur.next();
			if(c.getAbscisse()<x1)
				x1=c.getAbscisse();
			if(c.getOrdonnee()<y1)
				y1=c.getOrdonnee();
		}
		x2 = x1 + 35;
		y2 = y1 + 36;
	}
	public static void main(String[]args) throws LectureException, IOException{
		@SuppressWarnings("unused")
		Simulation si = new Simulation(4,
						new JeuDeLaVie(
						new PlateauInfini("Dossier_Teste/teste_jeu.LIF")));
	}
	
}
