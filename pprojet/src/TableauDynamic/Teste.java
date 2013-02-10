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
				grille.Evolution();
				if(grille.typeMort()){
					System.out.println("Type : Mort ");
				}
				if(grille.stable){
					System.out.println("Type : Stable ");
				}
				if(grille.oscitia){
					System.out.println("Type : Oscillation ");
				}
				if(grille.vaiseau){
					System.out.println("Type : Vaisseau ");
				}
				
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
