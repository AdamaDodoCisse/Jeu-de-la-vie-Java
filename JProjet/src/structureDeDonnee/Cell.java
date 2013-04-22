package structureDeDonnee;


public class Cell implements Comparable<Cell>{
	private int abscisse;
	private int ordonnee;
	private int nombreVoisin;
	private boolean status;
	
	public Cell(){
		this.abscisse = 0;
		this.ordonnee = 0;
		this.nombreVoisin = -1;
		status = false;
		
	}
	
	public Cell(int abs,int ord,int n,boolean s){
		this.abscisse = abs;
		this.ordonnee = ord;
		this.nombreVoisin = n;
		this.status = s;
	}
	public int getAbscisse() {
		return abscisse;
	}

	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}

	public int getOrdonnee() {
		return ordonnee;
	}

	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}

	public int getNombreVoisin() {
		return nombreVoisin;
	}

	public void setNombreVoisin(int nombreVoisin) {
		this.nombreVoisin = nombreVoisin;
	}

	@Override
	public int compareTo(Cell o) {
		if(this.getAbscisse()>o.getAbscisse())
			return 1;
		else if(this.getAbscisse()==o.getAbscisse()){
			if(this.getOrdonnee()>o.getOrdonnee())
				return 1;
			else if(this.getOrdonnee()<o.getOrdonnee())
				return -1;
			else return 0;
		}
		return -1;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Cell [abscisse=" + abscisse + ", ordonnee=" + ordonnee
				+ ", nombreVoisin=" + nombreVoisin + ", status=" + status + "]";
	}
	
	
	
}
