package Evolution;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Code_du_jeu.Cellule;
import Code_du_jeu.JeuDeLaVie;

public class Simulation {
	private int dureeSimulation;
	private JeuDeLaVie jeu;
	private int x1,x2,y1,y2;
	Timer time ;
	
	public Simulation(int d,JeuDeLaVie j){
		this.dureeSimulation = d;
		this.jeu = j;

		simuler();
	}
	
	public void simuler(){
	    
		afficher();
		time = new Timer(500,new ActionListener(){
			int temps = 0;
			public void actionPerformed(ActionEvent e){
				System.out.println((char)Event.ESCAPE + "8");
				System.out.println((char)Event.ESCAPE + "[2J");
				System.out.println((char)Event.ESCAPE + "2J" );
				jeu.evolutionSuivante();
				afficher();
				temps++;
				if(temps>dureeSimulation){
					System.exit(0);
				}
		
			}
		});
		
		time.start();
		try{
			System.in.read();
				
		}catch(Exception e){
			
		}
		
	}
	public void afficher(){
		String s = "";
		for(int i=jeu.getMinX();i<=jeu.getMaxX();i++){
			for(int j=jeu.getMinY();j<=jeu.getMaxY();j++){
				Cellule p = new Cellule(i,j);
				if(jeu.getJeux().contains(p)){
					s = s + " O ";
				}
				else 
					s = s + " - ";
			}
			s = s + "\n";
		}
		System.out.print(s);
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