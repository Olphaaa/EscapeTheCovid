package modele.entite.personnages;

import modele.entite.equipements.Equipement;
import modele.entite.equipements.armes.Arme;
import modele.entite.equipements.protections.Combinaison;
import modele.entite.equipements.protections.Masque;
import modele.entite.equipements.protections.Protection;
import modele.entite.equipements.protections.Visiere;

public class PersoPrincipal extends Personnage{
    private Arme a;
    private Protection p;
    private boolean isEquiped;


    public PersoPrincipal(){
        this.a = null;
        this.p = null;
        this.setEquiped(false);
        this.setImage("/images/perso/ppRien.png");
        this.setX(45);
        this.setY(375);
    }


    private void setArme(Arme a){
        this.a = a;
    }
    public void setProtection(Protection p){
        this.p = p;
    }
    public Protection getProtection(){return p;}


    public void attaquer(Arme a, IA ia){
        int pdvAdvers = ia.getPv();
        pdvAdvers -= a.getPdd();
        if(pdvAdvers <= 0){ia.setIsDead(true); ia.disparition();}
        else ia.setPv(pdvAdvers);
    }

    public boolean isEquiped() {
        return isEquiped;
    }
}
