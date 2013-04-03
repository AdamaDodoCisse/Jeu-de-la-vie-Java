import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;;

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
		time = new Timer(1000,new ActionListener(){
			int temps = 0;
			public void actionPerformed(ActionEvent e){
				System.out.println((char)Event.ESCAPE + "8");
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
				Point p = new Point(i,j);
				if(jeu.getJeux().contains(p)){
					s = s + " 0 ";
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