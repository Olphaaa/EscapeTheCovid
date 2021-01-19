package modele.entite.personnages;

import modele.entite.Entite;
/**
 * Classe Personnage
 * Elle permet de créer notre type d'entité "visible" tel que l'IA ou le personnage principal
 *
 */
public abstract class Personnage extends Entite {
    public int pointsDeVie;

    private boolean isDead;

    public Personnage(){
        isDead = false;
        pointsDeVie = 3;
    }


    public void setPv(int pdv){this.pointsDeVie = pdv;}
    public int getPv(){return this.pointsDeVie;}

    public void setIsDead(boolean bool){
        isDead = bool;
    }

    public void seFaireToucher(){
        this.pointsDeVie--;
    }




}
