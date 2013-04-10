package interface_;

import code_du_jeu.Cellule;


public interface Jeu { 
public void evolutionSuivante();
public boolean celluleMourante(Cellule p);
public boolean celluleNaissante(Cellule p);

}

