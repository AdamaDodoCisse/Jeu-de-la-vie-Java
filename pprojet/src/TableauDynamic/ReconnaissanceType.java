package TableauDynamic;
import java.io.IOException;

public class ReconnaissanceType {

	private Grille PrimoG ;
	private Grille SeconG ;
	
	protected int periodeFinal = 0;
	
	private int tailleQueue;
	private boolean oscillation=false;
	private boolean stabilite =false;
	private boolean mort=false;
	private boolean vaisceau=false;
	private boolean inconnu=true;
	public ReconnaissanceType(String source) throws IOException{
		PrimoG = new Grille(source);
		SeconG = new Grille(source);
		tailleQueue = 0;

	}

    public void structure(){
    	
    	if(!isVaisceau()){
    		periodeFinal++;
    	}
    	if(PrimoG.getCelluleVivante().isEmpty()){
    		
    		mort=true;
    		stabilite=true;
    		oscillation=true;
    		vaisceau=true;
    		inconnu=false;
    	}
    	if(verifStable(PrimoG)){
    		stabilite = true;
    		oscillation = true;
    		vaisceau = true ;
    		inconnu=false;
    	}
    	
    	if(verifOscillation()){
    		oscillation = true;
    		vaisceau = true ;
    		inconnu=false;
    	}
    	if(verifVaisceau()){
    		vaisceau=true;
    		inconnu=false;
    	}
    	
    }
    
    
    public boolean isInconnu() {
		return inconnu;
	}

	public void setInconnu(boolean inconnu) {
		this.inconnu = inconnu;
	}

	public double distance(Point p,Point p2){
    	return Math.sqrt(Math.pow(p.getX()-p2.getX(), 2) + Math.pow(p.getY()-p2.getY(), 2)) ;
    }
    public boolean verifVaisceau(){
    	if(PrimoG.getCelluleVivante().size()==SeconG.getCelluleVivante().size() && PrimoG.getCelluleVivante().size()!=0){
    		double dist=distance(PrimoG.getCelluleVivante().get(0), SeconG.getCelluleVivante().get(0));
    		
    		for(int i=1;i<PrimoG.getCelluleVivante().size();i++){
    			double distcourant = distance(PrimoG.getCelluleVivante().get(i), SeconG.getCelluleVivante().get(i));
    			if(dist != distcourant){
    				return false;
    			}
    		}return true;
    	}return false;
    }
    
    
    
    
    
    public boolean verifOscillation(){
    	return PrimoG.getCelluleVivante().equals(SeconG.getCelluleVivante());
    }
    public boolean verifStable(Grille p){
    	
    	Grille grille = new Grille();
    	p.clone(grille);
    	grille.Evolution(1);
    	return (p.getCelluleVivante().equals(grille.getCelluleVivante()));
    	
    }
    
	public Grille getPrimoG() {
		return PrimoG;
	}


	public void setPrimoG(Grille primoG) {
		PrimoG = primoG;
	}


	public Grille getSeconG() {
		return SeconG;
	}


	public void setSeconG(Grille seconG) {
		SeconG = seconG;
	}
	public int getTailleQueue() {
		return tailleQueue;
	}
	public void setTailleQueue(int tailleQueue) {
		this.tailleQueue = tailleQueue;
	}


	public boolean isOscillation() {
		return oscillation;
	}


	public void setOscillation(boolean oscillation) {
		this.oscillation = oscillation;
	}


	public boolean isStabilite() {
		return stabilite;
	}


	public void setStabilite(boolean stabilite) {
		this.stabilite = stabilite;
	}


	public boolean isMort() {
		return mort;
	}


	public void setMort(boolean mort) {
		this.mort = mort;
	}


	public boolean isVaisceau() {
		return vaisceau;
	}


	public void setVaisceau(boolean vaisceau) {
		this.vaisceau = vaisceau;
	}
	
	
	public String Resultat(String Fichier,int time){
		String d = "d' ";
		if(!((Fichier.charAt(0)+"").equalsIgnoreCase("U") ||(Fichier.charAt(0)+"").equalsIgnoreCase("I") 
			||(Fichier.charAt(0)+"").equalsIgnoreCase("A")||(Fichier.charAt(0)+"").equalsIgnoreCase("O"))
			||(Fichier.charAt(0)+"").equalsIgnoreCase("E"))
				d="de ";
		if (isMort()){
			return "<p  class=\"Titre\">"+Fichier.substring(0, Fichier.length()-4).toUpperCase()+"</p>\n" +
					   "<p class=\"Resultat\">L'evolution Asymptotique "+d+Fichier.substring(0, Fichier.length()-4)+" est de type ['Mort'] sur une durée de "+time+"" +
					   		"\net sa periode = "+periodeFinal+" on deduit qu'il est stable, oscillant, et vaisseau</p>\n";
		}
		else if (isStabilite()){
			return "<p class=\"Titre\">"+Fichier.substring(0, Fichier.length()-4).toUpperCase()+"</p>\n" +
					   "<p class=\"Resultat\">L'evolution Asymptotique "+d+Fichier.substring(0, Fichier.length()-4)+" est de type ['Stable'] sur une durée de "+time+" \n" +
					   	"et sa Periode de stabilité = "+periodeFinal+" Vu qu'il est stable on deduit " +
					   			"qu'il est oscillant et Vaisseau </p>\n";
		}else if( isOscillation()){
			return "<p class=\"Titre\">"+Fichier.substring(0, Fichier.length()-4).toUpperCase()+"</p>\n" +
					   "<p class=\"Resultat\">L'evolution Asymptotique "+d+Fichier.substring(0, Fichier.length()-4)+" est de type ['Oscillant'] sur une durée de "+time+" \n" +
					   	"et sa Periode d'oscillation = "+periodeFinal+" Vu qu'il est oscillant on deduit " +
					   	"qu'il est Vaisseau </p>\n";
		}else if(isVaisceau()){
			return "<p class=\"Titre\">"+Fichier.substring(0, Fichier.length()-4)+"</p>\n" +
					   "<p class=\"Resultat\">L'evolution Asymptotique "+d+Fichier.substring(0, Fichier.length()-4)+" est de type ['Vaisseau'] sur une durée de "+time+"\n" +
					   		"et periode = "+periodeFinal+"</p>\n";
		}else{
			return "<p class=\"Titre\">"+Fichier.substring(0, Fichier.length()-4).toUpperCase()+"</p>\n" +
					   "<p class=\"Resultat\">L'evolution Asymptotique "+d+Fichier.substring(0, Fichier.length()-4)+" est de type ['Inconnu'] sur une durée de "+time+"</p>\n";
		}
	}
	
}
