import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class LectureJeuDeLaVie {

	public static void lireJeuDeLaVie(JeuDeLaVie jeu,String nomFichier){
		
		File fichier=new File(nomFichier);
		int abscisse=0;
		int ordonnee=0;
		String []tab;
		
		if( fichier.isFile() && fichier.getAbsolutePath().endsWith(".LIF")
				|| fichier.isFile() && fichier.getAbsolutePath().endsWith(".lif")){
			
			try {
				
				BufferedReader reader = new BufferedReader(new FileReader(fichier));
				String line=null;
				
				try {
					while((line = reader.readLine())!=null){

						if(line.matches("^#P[\\s0-9-]+")){
							line = line.replaceAll("[^0-9\\s]", "");
							line = line.replaceFirst(" ", "");
							tab = line.split(" ");
							try{
								abscisse=Integer.valueOf(tab[0])-1;
								ordonnee=Integer.valueOf(tab[1])-1;
							}catch(Exception e){
								JOptionPane.showMessageDialog(null, "Erreur de lecture du fichier, fichier non conforme au format LIF", "Erreur de lecture", JOptionPane.ERROR_MESSAGE);
							}

						} else if(line.matches("^#R[\\s0-9]+/[0-9]+")) {
							ajouterRegle(line,jeu);
							
						}else if(line.matches("^[.*]+")){
							ajouterCelluleVivante(line,abscisse,ordonnee,jeu);
					    }
					
}
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}catch(FileNotFoundException e){
				
			}
			if(jeu.getRegleMortCellule().size()==0){
				jeu.getRegleMortCellule().add(2);
				jeu.getRegleMortCellule().add(3);
			}
			if(jeu.getRegleVieCellule().size()==0){
				jeu.getRegleVieCellule().add(3);
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "Erreur de lecture du fichier", "Erreur de lecture", JOptionPane.ERROR_MESSAGE);
		}
		
	}



public static void ajouterCelluleVivante(String line , int abscisse, int ordonnee, JeuDeLaVie jeu){
	int i = 0;
	while(i<line.length()){
		if(line.charAt(i)=='*'){
			jeu.getCelluleVivante().add(new Point(abscisse,ordonnee));
		}
		ordonnee++;
		i++;
	}
	abscisse++;
	ordonnee=0;
}


public static void ajouterRegle(String line,JeuDeLaVie jeu){
	
	line = line.replaceAll("[^0-9/]", "");
	StringTokenizer regle = new StringTokenizer(line,"/");
	if(regle.countTokens()==2){
		String k = regle.nextToken();
		int i=0;
		while(i<=k.length()-1){
			jeu.getRegleVieCellule().add(Integer.valueOf(k.charAt(i)));
			i++;
		}
		k = regle.nextToken();
		i=0;
		while(i<=k.length()-1){
			jeu.getRegleMortCellule().add(Integer.valueOf(k.charAt(i)));
			i++;
		}
	}
}


}




