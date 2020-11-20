package modele.equipements.protections;

import java.awt.*;

public class Visiaire extends Protection {
    private Image image;

    public Visiaire(){
        this.niveauProtection = 2;
        this.tauxApparition = (float) 0.30;
    }
}
