package TableauDynamic;

import java.awt.Point;
import java.util.ArrayList;

public class Celulle {
	private boolean vie=false;
	private char form='-';
	private int posX;
	private int posY;
	private ArrayList<Point> MesVoisins;
	
	public Celulle(int x,int y,boolean vie){
		this.vie=vie;
		this.posX=x;
		this.posY=y;
		MesVoisins=new ArrayList<Point>();
	}
	
	public void ajoutVoisin(Celulle c){
		MesVoisins.add(new Point(c.posX, c.posY));
	}

	public boolean isVie() {
		return vie;
	}

	public void setVie(boolean vie) {
		this.vie = vie;
	}
	public Celulle(){
		MesVoisins=new ArrayList<Point>();
	}
	/**
	 * function qui ce charge de l'ajout des voisins d'une cellule si celle si existe 
	 * Dans le Monde avec Frontière
	 * @param scene
	 */
	public void Ajout_Voisin(Scene scene){
		try {
			if(scene.getTableau().get(posX).get(posY+1).isVie())
				MesVoisins.add(new Point(posX,posY+1));
		} catch (Exception e) {}
		try {
			if(scene.getTableau().get(posX).get(posY-1).isVie())
				MesVoisins.add(new Point(posX,posY-1));
		} catch (Exception e) {}
		try {
			if(scene.getTableau().get(posX+1).get(posY).isVie())
				MesVoisins.add(new Point(posX+1,posY));
			} catch (Exception e) {}
		try {
			if(scene.getTableau().get(posX-1).get(posY).isVie())
				MesVoisins.add(new Point(posX-1,posY));
			} catch (Exception e) {}
		try {
			if(scene.getTableau().get(posX+1).get(posY+1).isVie())
				MesVoisins.add(new Point(posX+1,posY+1));
			} catch (Exception e) {}
		try {
			if(scene.getTableau().get(posX-1).get(posY-1).isVie())
				MesVoisins.add(new Point(posX-1,posY-1));
			} catch (Exception e) {}
		try {
			if(scene.getTableau().get(posX-1).get(posY+1).isVie())
				MesVoisins.add(new Point(posX-1,posY+1));
			} catch (Exception e) {}
		try {
			if(scene.getTableau().get(posX+1).get(posY-1).isVie())
				MesVoisins.add(new Point(posX+1,posY-1));
			} catch (Exception e) {}
	}
	/**
	 * 	function qui ce charge de l'ajout des voisins d'une cellule si celle si existe 
	 * 	Dans le Monde circulaire
	 *  @param scene
	 */
	public void Ajout_Voisin_Cir(Scene scene){
		Ajout_Voisin(scene);
	}
	public char getForm() {
		return form;
	}

	public void setForm(char form) {
		this.form = form;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public ArrayList<Point> getMesVoisins() {
		return MesVoisins;
	}

	public void setMesVoisins(ArrayList<Point> mesVoisins) {
		MesVoisins = mesVoisins;
	}
	
}
