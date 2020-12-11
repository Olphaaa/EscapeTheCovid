package modele.entite.personnages;

import javafx.scene.image.ImageView;
import modele.Position;
import modele.entite.Entite;

public abstract class Personnage extends Entite {
    public int pointsDeVie;
    private boolean isDead;

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
