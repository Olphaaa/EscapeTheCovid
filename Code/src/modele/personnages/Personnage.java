package modele.personnages;

import java.awt.*;

public abstract class Personnage {
    private int pointsDeVie;
    private float positionX;
    private float positionY;
    private boolean isDead;
    private Image image;

//constructeur ?

    public void seFaireToucher(){
        this.pointsDeVie--;
    }
}
