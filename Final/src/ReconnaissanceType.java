import java.io.FileNotFoundException;
import java.util.Iterator;

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
		
		
		for(int i=1;i<= temp;i++){
			
			calculerStructure();
			
			if(!inconnu){
				break;
			}tailleQueue = i;
			if(estMort()){
				inconnu = false;
				mort = true;
			}
			if(estStable()){
				inconnu = false;
				stabilite =true;
				
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
				}
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
			configuration2.getJeux().getCelluleVivante()) || estStable();
	}
	public boolean estStable(){
		return configuration1.estStable() || estMort();
	}
	
	public boolean estMort(){
		return configuration1.getJeux().estVide();
	}
	
	public boolean estVaiseau(){
		if(estMort() || estOscillation())
			return true;
		Iterator<Point> it1 = configuration1.getJeux().iterer();
		Iterator<Point> it2 = configuration2.getJeux().iterer();
		if(configuration1.getJeux().taille() == configuration2.getJeux().taille()){
			int i=0;
			double distance=0;
		while(it1.hasNext()){
			Point p1=it1.next();
			it2 = configuration2.getJeux().iterer();
			while(it2.hasNext()){
				if(i!=0)
					if(distance !=(distance(p1, it2.next())))
						return false;
				else
					distance = (distance(p1,it2.next()));
				i++;
			}
		}return true;}return false;
		
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
	public String Resultat(){
		return null;
	}
	
	public String toString(){
		return null;
	}

}
