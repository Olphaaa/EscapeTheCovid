package modele.partie;

import modele.carte.Carte;
import modele.personnages.PersoPrincipal;

public class Partie{
    public float temps;
    public int nivDifficulte;
    public int nbKills;
    public PersoPrincipal p;
    public Carte map;

    public Partie(){

    }

    public Carte genererCarte(int nivDifficulte){
        Carte map = new Carte(nivDifficulte);
        return map;
    }

}
