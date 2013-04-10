package code_du_jeu;

public class Cellule implements Comparable<Cellule>{

	private int x;
	private int y; 

	public Cellule(int abs,int ord){
		this.x = abs;
		this.y = ord;
	}

	@Override
	public int compareTo(Cellule o) {
		if(this.getX()>o.getX())
			return 1;
		else if(this.getX()==o.getX()){
			if(this.getY()>o.getY())
				return 1;
			else if(this.getY()<o.getY())
				return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cellule other = (Cellule) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
