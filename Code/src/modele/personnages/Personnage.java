package modele.personnages;

import java.awt.*;

public abstract class Personnage {
    public int pointsDeVie;
    private float positionX;
    private float positionY;
    private boolean isDead;
    private Image image;

//constructeur ?

    public Personnage(){
        isDead = false;
        pointsDeVie = 3;
    }

    public void setPv(int pdv){this.pointsDeVie = pdv;}
    public int getPv(){
        return this.pointsDeVie;
    }

    public void setIsDead(boolean bool){
        isDead = bool;
    }

    public void seFaireToucher(){
        this.pointsDeVie--;
    }
}
