package TableauDynamic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;

public class Grille implements ActionListener{
	
private ArrayList<Point> celluleVivante;
private ArrayList<Integer> regleVie;
private ArrayList<Integer> regleMort;
private int debutLongueur;
private int finLongueur;
private int debutLargeur;
private int finLargeur;
private int periode;
public Timer timer;

public Grille(){
	celluleVivante = new ArrayList<Point>();
	regleVie = new ArrayList<Integer>();
	regleMort = new ArrayList<Integer>();
	debutLargeur = 0;
	finLargeur = 0;
	debutLongueur = 0;
	finLongueur = 0;
	periode = 0;
}


public Grille(String source) throws IOException{
	celluleVivante = new ArrayList<Point>();
	regleVie = new ArrayList<Integer>();
	regleMort = new ArrayList<Integer>();
	debutLargeur = 0;
	finLargeur = 0;
	debutLongueur = 0;
	finLongueur = 0;
	File fichier=new File(source);
	int abscisse=0;
	int ordonnee=0;
	periode = 0;
	String []tab;
	
	if(fichier.isFile()&&fichier.getAbsolutePath().endsWith(".LIF")){
	 	try {
			BufferedReader reader = new BufferedReader(new FileReader(fichier));
			
			String line=null;
			while((line = reader.readLine())!=null){
				
				if(line.matches("^#P[\\s0-9-]+")){
					line = line.replaceAll("[^0-9]", " ");
					line = line.replaceFirst(" ", "");
					tab = line.split(" ");
					try{
					abscisse=Integer.valueOf(tab[0])-1;
					ordonnee=Integer.valueOf(tab[1])-1;
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, "Erreur de lecture du fichier, fichier non conforme au format LIF", "Erreur de lecture", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				else if(line.matches("^#R[\\s0-9]+/[0-9]+")){
					
					line = line.replaceAll("[^0-9/]", "");
					StringTokenizer st = new StringTokenizer(line,"/");
					if(st.countTokens()==2){
						String g = st.nextToken();
						int i=0;
						while(i<=g.length()-1){
							regleVie.add(Integer.valueOf(g.charAt(i)));
							i++;
						}
						g = st.nextToken();
						i=0;
						while(i<=g.length()-1){
							regleMort.add(Integer.valueOf(g.charAt(i)));
							i++;
						}
					}
				}
				else if(line.matches("^[.*]+")){
					System.out.println(line);
					int i=0;
					while(i<line.length()){
						if(line.charAt(i)=='*'){
							celluleVivante.add(new Point(abscisse,ordonnee));
						}
						if(abscisse<debutLongueur)
							debutLongueur = abscisse;
						else if(abscisse>finLongueur)
							finLongueur = abscisse;
						
						if(ordonnee<debutLargeur)
							debutLargeur = ordonnee;
						else if(ordonnee>finLargeur)
							finLargeur = ordonnee;
						ordonnee++;
						i++;
						
					}
					abscisse++;
					ordonnee=0;
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	
	 	if(regleVie.size()==0){
	 		regleVie.add(3);
	 	}
	 	if(regleMort.size()==0){
	 		regleMort.add(3);
	 		regleMort.add(2);
	 	}
	}
	else{
		JOptionPane.showMessageDialog(null, "Erreur de lecture du fichier", "Erreur de lecture", JOptionPane.ERROR_MESSAGE);
	}
}

public String toString(){
	String echiquier = "";
	for(int i=debutLongueur;i<=finLongueur;i++){
		for(int j=debutLargeur;j<=finLargeur;j++){
			Point p = new Point(i,j);
			if(celluleVivante.contains(p))
				echiquier = echiquier+" 0 ";
			else 
				echiquier = echiquier+" - ";
				
		}
		echiquier = echiquier+"\n";
	}
	return echiquier;
}

public void Evolution(){
	
	ArrayList<Point> evol = new ArrayList<Point>();
	
	for(int i=debutLongueur-1;i<=finLongueur+1;i++){
		
		for(int j=debutLargeur-1;j<=finLargeur+1;j++){
			
			Point p = new Point(i,j);
			
			if(celluleVivante.contains(p)){
				if(meurt(p)==true)
				    evol.add(p);
			}
			else{
				if(vivre(p))
					evol.add(p);
			}
			
		}
	}
	periode++;
	this.setCelluleVivante(evol);
	miseAjourTaille();
	System.out.println(this);
	System.out.println(periode);
}
public boolean vivre(Point p){
	
	int voisinVivant=0;
	
	for(int i=p.getX()-1;i<=p.getX()+1;i++){
		
		for(int j=p.getY()-1;j<=p.getY()+1;j++){
			
			Point k = new Point(i,j);
			
			if(celluleVivante.contains(k)&&!k.equals(p))
				
				voisinVivant++;
		}
	}
	return regleVie.contains(voisinVivant);
}

public boolean meurt(Point p){
	
    int voisinVivant=0;
	
	for(int i=p.getX()-1;i<=p.getX()+1;i++){
		
		for(int j=p.getY()-1;j<=p.getY()+1;j++){
			
			Point k = new Point(i,j);
			
			if(celluleVivante.contains(k)&&!k.equals(p))
				
				voisinVivant++;
		}
	}
	return regleMort.contains(voisinVivant);
}

public void miseAjourTaille(){
	/*Point k = celluleVivante.get(0);
	debutLargeur = k.getY();
	finLargeur = k.getY();
	debutLongueur = k.getX();
	finLongueur = k.getX();*/
	debutLongueur = Integer.MAX_VALUE;
	finLongueur = Integer.MIN_VALUE;
	debutLargeur = Integer.MAX_VALUE;
	finLargeur = Integer.MIN_VALUE;
	
 for(Point p : celluleVivante){
	 if(p.getX()<debutLongueur)
		 debutLongueur = p.getX();
	 else if(p.getX()>finLongueur){
		 finLongueur = p.getX();
	 }
	 if(p.getY()<debutLargeur)
		 debutLargeur = p.getY();
	 else if(p.getY()>finLargeur)
		 finLargeur = p.getY();
 }
}

public ArrayList<Point> getCelluleVivante() {
	return celluleVivante;
}

public void setCelluleVivante(ArrayList<Point> celluleVivante) {
	this.celluleVivante = celluleVivante;
}

public ArrayList<Integer> getRegleVie() {
	return regleVie;
}

public void setRegleVie(ArrayList<Integer> regleVie) {
	this.regleVie = regleVie;
}

public ArrayList<Integer> getRegleMort() {
	return regleMort;
}

public void setRegleMort(ArrayList<Integer> regleMort) {
	this.regleMort = regleMort;
}

public int getDebutLongueur() {
	return debutLongueur;
}


public void setDebutLongueur(int debutLongueur) {
	this.debutLongueur = debutLongueur;
}


public int getFinLongueur() {
	return finLongueur;
}


public void setFinLongueur(int finLongueur) {
	this.finLongueur = finLongueur;
}


public int getDebutLargeur() {
	return debutLargeur;
}


public void setDebutLargeur(int debutLargeur) {
	this.debutLargeur = debutLargeur;
}


public int getFinLargeur() {
	return finLargeur;
}


public void setFinLargeur(int finLargeur) {
	this.finLargeur = finLargeur;
}


public void afficher(){
	for(Point p : celluleVivante){
		System.out.println(p);
	}
}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Evolution();
	
}
}
