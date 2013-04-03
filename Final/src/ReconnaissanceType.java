import java.io.FileNotFoundException;

public class ReconnaissanceType {
	private JeuDeLaVie configuration1;
	private JeuDeLaVie configuration2;
	protected int periodeFinal = 0;
	private int tailleQueue=0;
	private boolean oscillation=false;
	private boolean stabilite =false;
	private boolean mort=false;
	private boolean vaisceau=false;
	private boolean inconnu=true;
	
	public ReconnaissanceType(int type,int temp,String nomFichier) throws FileNotFoundException{
		
		configuration1 = JeuDeLaVieFactory.getJeuDeLaVie(type, nomFichier);
		configuration2 = JeuDeLaVieFactory.getJeuDeLaVie(type, nomFichier);
		
		
		for(int i=1;i<=temp;i++){
			
			calculerStructure();
			
			if(!inconnu){
				break;
			}tailleQueue = i;
			if(estMort()){
				inconnu = false;
				mort = true;
			}
			if(estOscillation()){
				inconnu = false;
				oscillation=true;
				//		Calcule de la periode
				while(true){
					calculerStructure();
					periodeFinal++;
					if(estOscillation())
						break;
				}if(periodeFinal == 1)
					stabilite = true;
			}
			if(estVaiseau()){
				inconnu = false;
				vaisceau=true;
				if(!isOscillation())
						//		Calcule de la periode		
					while(true){
						calculerStructure();
						periodeFinal++;
						if(estVaiseau())
							break;
					}
			}
		}
	}
	public void calculerStructure(){
		configuration1.evolutionSuivante(); 
		configuration2.evolutionSuivante(); 
		configuration2.evolutionSuivante();
	}
	
	public boolean estOscillation(){
	return configuration1.getJeux().getCelluleVivante().equals(
			configuration2.getJeux().getCelluleVivante()) ;
	}
	
	public boolean estMort(){
		return configuration1.getJeux().estVide();
	}
	
	public boolean estVaiseau(){
		if(estMort() || estOscillation())
			return true;
		if(configuration1.getJeux().taille() == configuration2.getJeux().taille()){
			Point p1 = configuration1.getJeux().getPoint(0);
			Point p2 = configuration2.getJeux().getPoint(0);
			int taille = configuration1.getJeux().taille();
			double distance = distance(p1, p2);
			for(int i = 1;i<taille;i++){
				Point a = configuration1.getJeux().getPoint(i);
				Point b = configuration2.getJeux().getPoint(i);
				if(distance(a, b) !=distance)
					return false;
			}return true;
		}return false;
		
	}
	
	public double distance(Point p1,Point p2){
		return (Math.sqrt((Math.pow(p1.getX() - p2.getX(), 2)) + (Math.pow(p1.getY() - p2.getY(), 2))));
	}
	
	public void clone(JeuDeLaVie j1,JeuDeLaVie j2){
		j2.setJeux(j1.getJeux());
		j2.setMaxX(j1.getMaxY());
		j2.setMaxY(j1.getMinX());
		j2.setMinX(j1.getMinX());
		j2.setMinY(j1.getMinY());
	}
	
	
	
	
	
	public JeuDeLaVie getConfiguration1() {
		return configuration1;
	}
	public void setConfiguration1(JeuDeLaVie configuration1) {
		this.configuration1 = configuration1;
	}
	public JeuDeLaVie getConfiguration2() {
		return configuration2;
	}
	public void setConfiguration2(JeuDeLaVie configuration2) {
		this.configuration2 = configuration2;
	}
	public int getPeriodeFinal() {
		return periodeFinal;
	}
	public void setPeriodeFinal(int periodeFinal) {
		this.periodeFinal = periodeFinal;
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
	public boolean isInconnu() {
		return inconnu;
	}
	public void setInconnu(boolean inconnu) {
		this.inconnu = inconnu;
	}
	
	public String toString(){
		if(isInconnu())
			return  "Type inconnu";
		else if(isMort())
			return  "Type Mort donc Stable ,Oscillation et Vaisseau \n" +
					"sur une periode de : "+periodeFinal+" et sa queue est de : "+tailleQueue+"";
		else if(isStabilite())
			return  "Type Stable donc Oscillation et Vaisseau \n" +
					"sur une periode de : "+periodeFinal+" et sa queue est de : "+tailleQueue+"";
		else if(isOscillation())
			return  "Type Oscillation donc Vaisseau \n" +
					"sur une periode de : "+periodeFinal+" et sa queue est de : "+tailleQueue+"";
		else
			return  "Type Vaisseau \n" +
					"sur une periode de : "+periodeFinal+" et sa queue est de : "+tailleQueue+"";
	}

}
