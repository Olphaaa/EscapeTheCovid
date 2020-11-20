package modele.equipements.protections;

import java.awt.*;

public class Masque extends Protection {
    private Image image;

    public Masque(){
        this.niveauProtection = 1;
        this.tauxApparition = (float) 0.40;
    }
}
