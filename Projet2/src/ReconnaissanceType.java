import java.io.FileNotFoundException;


public class ReconnaissanceType {
	private JeuDeLaVie configuration1,configuration2;
	protected int periodeFinal = 0;
	private int tailleQueue=0;
	private boolean oscillation=false;
	private boolean stabilite =false;
	private boolean mort=false;
	private boolean vaisceau=false;
	private boolean inconnu=true;
	public ReconnaissanceType(JeuDeLaVie jeu,int temp) throws FileNotFoundException{
		configuration1=jeu;
		configuration2=jeu;
		for(int i=0;i< temp;i++){
			if(!inconnu){
				break;
			}
			calculerStructure();
			
		}
	}
	
	public void calculerStructure(){
		
		configuration1.evolutionSuivante(); 
		configuration2.evolutionSuivante(); 
		configuration2.evolutionSuivante();
	}
	
	
	public boolean estOscillation(){
	return configuration1.getJeux().getCelluleVivante().equals(
			configuration2.getJeux().getCelluleVivante());
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
	

}
