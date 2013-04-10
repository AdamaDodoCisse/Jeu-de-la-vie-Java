package Code_du_jeu;

import setup.Cellule;

public interface Jeu {
public void evolutionSuivante();
public boolean celluleMourante(Cellule p);
public boolean celluleNaissante(Cellule p);

}

