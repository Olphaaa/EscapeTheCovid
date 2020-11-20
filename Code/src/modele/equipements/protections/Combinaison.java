package modele.equipements.protections;

import java.awt.*;

public class Combinaison extends Protection{
    private Image image;

    public Combinaison(){
        this.niveauProtection = 4;
        this.tauxApparition = (float) 0.10;
    }
}
