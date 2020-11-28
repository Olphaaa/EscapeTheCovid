package modele.entite.personnages;

import modele.entite.equipements.armes.Arme;
import modele.entite.equipements.protections.Protection;

public class PersoPrincipal extends Personnage{
    private Arme a;
    private Protection p;
    public String pseudo;

    public PersoPrincipal(){
        this.a = null;
        this.p= null;
    }

    public PersoPrincipal(String surnom){
        new PersoPrincipal();
        this.pseudo = surnom;
    }

    private void setArme(Arme a){
        this.a = a;
    }
    private void setProtection(Protection p){
        this.p = p;
    }


    public void attaquer(Arme a, IA ia){
        int pdvAdvers = ia.getPv();
        pdvAdvers -= a.getPdd();
        if(pdvAdvers <= 0){ia.setIsDead(true); ia.disparition();}
        else ia.setPv(pdvAdvers);
    }
}
