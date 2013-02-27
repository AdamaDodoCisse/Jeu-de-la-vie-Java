package TableauDynamic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.Timer;

public class Teste {
public static void main(String[]args){
	try {
		final Grille grille=new Grille("Essai.LIF");
		System.out.println(grille);
		
		final Timer timer = new Timer(1000,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				grille.Evolution(grille.getCelluleVivante(),2);
				grille.setPeriode(grille.getPeriode()+1);
				System.out.println(grille);
				grille.Evolution(grille.getCelluleVivante2(),1);
				
				grille.mort=grille.getCelluleVivante().size()==0 ;
				
				//grille.stable=grille.mort ||false;;
				
				//grille.vaiseau=grille.oscitia || false;;	
				
				if(grille.mort){
					System.out.println("Type : Mort ");
				}
				if(grille.stable){
					System.out.println("Type : Stable ");
				}
				if(grille.getCelluleVivante().equals(grille.getCelluleVivante2()) || grille.stable){
					System.out.println("Type : Oscillation ");
				}
				if(grille.vaiseau){
					System.out.println("Type : Vaisseau ");
				}
				
				System.out.println("Evolution : 1 = "+grille.getPeriode()+"\nEvolution 2 : "+grille.getPeriode()*2);
			}
		});
		
		timer.start();
		try{
			System.in.read();
		}catch(Exception e){
			
		}
		if(args[0].equals("name")){
			System.out.println("Nom des etudiants");
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
