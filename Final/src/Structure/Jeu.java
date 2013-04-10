package Interface_du_jeu;

import Code_du_jeu.Cellule;


public interface Jeu {
public void evolutionSuivante();
public boolean celluleMourante(Cellule p);
public boolean celluleNaissante(Cellule p);

}

