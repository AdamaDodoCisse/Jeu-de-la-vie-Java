package TableauDynamic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Timer;
/**
 * @author cisse
 *
 */
public class Scene implements ActionListener{
	private int periode=0;
	private ArrayList<ArrayList<Celulle>> tableau;
	private ArrayList<ArrayList<Celulle>>Point_de_depart;
	public Timer t;
	private boolean Mort=false;
	private boolean Stable=false;
	private boolean Oscillatteur=false;
	private boolean Vaisseau=false;
	@SuppressWarnings("unchecked")
	public Scene(){

		t=new Timer(500,this);
		setTableau(new ArrayList<ArrayList<Celulle>>());
		Clown();
		//ajout(15, 15, false);
		Point_de_depart=new ArrayList<ArrayList<Celulle>>();
		Point_de_depart=(ArrayList<ArrayList<Celulle>>) tableau.clone();
		t.start();
		try {
			System.in.read();
		} catch (IOException e1) {}
		t.stop();
	}
	public Scene(boolean t){
		setTableau(new ArrayList<ArrayList<Celulle>>());
	}
	/**
	 * Function qui Gère l'evolution dans un monde avec Frontière
	 */
	public void Evolution(){
		
		for(int i=0;i<getTableau().size();i++){
			for(int j=0;j<getTableau().get(i).size();j++){
				System.out.print(getTableau().get(i).get(j).getForm()+" ");
			}System.out.println();
		}
		for(ArrayList<Celulle> s : tableau){
			for(Celulle c : s){
				c.Ajout_Voisin(this);
			}
		}System.out.println();

		ArrayList<ArrayList<Celulle>>copy=new ArrayList<ArrayList<Celulle>>();
		initialisation(getTableau().size()-1, getTableau().get(0).size()-1, copy, false);

		for(int i=0;i<getTableau().size();i++){
			for(int j=0;j<getTableau().get(i).size();j++){
				if(getTableau().get(i).get(j).getMesVoisins().size() == 3 && !getTableau().get(i).get(j).isVie()){
					copy.get(i).set(j, new Celulle(i, j, true));
					copy.get(i).get(j).setForm('O');
				}else if((getTableau().get(i).get(j).getMesVoisins().size() == 2 || getTableau().get(i).get(j).getMesVoisins().size()== 3) && getTableau().get(i).get(j).isVie() ){
					copy.get(i).set(j, new Celulle(i, j, true));
					copy.get(i).get(j).setForm('O');
				}else{
					copy.get(i).set(j, new Celulle(i, j, false));
					copy.get(i).get(j).setForm('-');
				}
			}
		}
		periode++;
		System.out.println(periode);
		setTableau(copy);
		Oscillation();
		System.out.println(Oscillatteur ? "Oscillation" : ""); 
		if(periode==110){
			//t.stop();
		}
	}

	public void Oscillation(){
		for(int i=0;i<getTableau().size();i++){
			for(int j=0;j<getTableau().get(0).size();j++){
				if(Point_de_depart.get(i).get(j).getForm()!=getTableau().get(i).get(j).getForm()){
					return;
				}
			}
		}setOscillatteur(true);
	}

	/**
	 * function qui fais l'ajout d'une cellule à une position donneé suivant son etat
	 * Il le cree au cas ou la cellule n'existe pas
	 * @param x
	 * @param y
	 * @param b
	 */
	public void ajout(int x,int y,boolean b){
		initialisation(x, y, tableau, b);
	}/**
	 * function qui ajoute une celulle a une liste passer en arguments et ajoute une cellule a la position x , y d'ou b l'etat de la cellule
	 * @param  x
	 * @param  y
	 * @param  b
	 */
	public void initialisation(int x,int y,ArrayList<ArrayList<Celulle>> tableau,boolean b){
		while(x>=tableau.size()){
			ArrayList<Celulle> l =new ArrayList<Celulle>();
			tableau.add(l);
		}
		for(ArrayList<Celulle> value : tableau){
			while(value.size() <= y){
				value.add(new Celulle(tableau.indexOf(value),value.size(),false));
			}
		}	
		Celulle k=new Celulle(x,y,b);
		if(b){
			k.setForm('O');
		}else{
			k.setForm('-');
		}
		tableau.get(x).set(y, k);
	}
	public ArrayList<ArrayList<Celulle>> getTableau() {
		return tableau;
	}
	public void setTableau(ArrayList<ArrayList<Celulle>> tableau) {
		this.tableau = tableau;
	}
	public void Clown(){
		ajout(49, 49, false);
		
		ajout(24, 24, true);
		ajout(25, 24, true);
		ajout(26, 24, true);
		ajout(24, 26, true);
		ajout(25, 26, true);
		ajout(26, 26, true);
		ajout(26, 25, true);
		
	}
	public void Bombe(){
		ajout(24, 24, false);
		for(int i=0;i<=6;i+=2){
			ajout(0, i, true);
			ajout(i, 0, true);
		}
		for(int i=1;i<=5;i+=2){
			ajout(1, i, true);
		}
		for(int i=0;i<=4;i+=2){
			ajout(2, i, true);
		}
		for(int i=0;i<=4;i+=2){
			ajout(4, i, true);
		}
		for(int i=1;i<=3;i+=2){
			ajout(3, i, true);
		}

		ajout(5, 1, true);
		ajout(0, 23, true);
		ajout(0, 22, true);
		ajout(2, 23, true);
		ajout(2, 22, true);
		ajout(1, 20, true);
		ajout(1, 21, true);
		ajout(1, 24, true);

		ajout(11, 13, true);
		ajout(12, 13, true);
		ajout(13, 13, true);

		ajout(22, 1, true);
		ajout(22, 2, true);
		ajout(24, 1, true);
		ajout(24, 2, true);
		ajout(23, 0, true);
		ajout(23, 3, true);
		ajout(23, 4, true);
	}
	/**
	 * Une Initailisation qui permet une Evolution Grenouille
	 * Celui ci Evolu dans un monde Avec Frontière
	 */
	public void grenouille(){
		try {
			System.out.println("START:##GRENOUILLE...");
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			System.out.println("GO....");
			Thread.sleep(300);
		} catch (Exception e) {
			// TODO: handle exception
		}
		ajout(1+20, 1+20,true);
		ajout(1+20, 2+20,true);
		ajout(2+20, 0+20,true);
		ajout(2+20, 1+20,true);
		ajout(2+20, 2+20,true);
		ajout(1+20, 3+20,true);
		ajout(25, 25,false);
	}
	/**
	 *  Une Initailisation qui permet une Evolution Planeur
	 *  Celui ci Evolu dans un monde Circulaire
	 */
	public void planeur(){
		ajout(0, 1,true);
		ajout(2, 0,true);
		ajout(2, 0,true);
		ajout(2, 1,true);
		ajout(2, 2,true);
		ajout(1, 2,true);
		ajout(10, 10, false);
	}
	/**
	 *  Une Initailisation qui permet une Evolution Stable de Quatre bloc
	 * 	
	 */
	public void quatre_bloc(){
		ajout(0+20, 1+20,true);
		ajout(0+20, 2+20,true);
		ajout(1+20, 1+20,true);
		ajout(1+20, 2+20,true);
		ajout(50, 50,false);
	}
	public void clignotant(){
		ajout(24, 24, false);
		ajout(3, 18, true);
		ajout(3, 19, true);
		ajout(3, 20, true);
		ajout(4, 17, true);
		ajout(4, 18, true);
		ajout(4, 19, true);
		ajout(16, 6, true);
		ajout(16, 7, true);
		ajout(16, 8, true);
		ajout(17, 8, true);
		ajout(18, 7, true);
	}
	/**
	 * 	une Initialisation par defaut qui est Aleatoire soit par (Grenouille, quatre_bloc,Planeur)
	 */
	public void Hasard(){
		int rand=(1)+(int)(Math.random()*4);
		if(rand==1){
			grenouille();
		}else if(rand==2){
			planeur();
		}else if(rand==3){
			quatre_bloc();
		}else{
			clignotant();
		}	
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {

		Evolution();
	}
	/**
	 * Verifie l'evolution s'elle est a l'etat Mort
	 * @return Boolean
	 */
	public boolean isMort() {
		for(ArrayList<Celulle> c : getTableau()){
			for(Celulle v : c){
				if(v.isVie()){
					setMort(false);
					return false;
				}
			}
		}
		setMort(true);
		return Mort;
	}
	public void setMort(boolean mort) {
		Mort = mort;
	}
	public boolean isStable() {
		return Stable;
	}
	public void setStable(boolean stable) {
		Stable = stable;
	}
	public boolean isOscillatteur() {
		return Oscillatteur;
	}
	public void setOscillatteur(boolean oscillatteur) {
		Oscillatteur = oscillatteur;
	}
	public boolean isVaisseau() {
		return Vaisseau;
	}
	public void setVaisseau(boolean vaisseau) {
		Vaisseau = vaisseau;
	}
	public void lecture(String Source){

		File fichier=new File(Source);
		if(fichier.isFile()){
			if(Source.endsWith(".lif")){

			}else{

			}
		}else{

		}
	}

}
