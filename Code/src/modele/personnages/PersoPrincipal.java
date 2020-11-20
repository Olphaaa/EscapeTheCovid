package modele.personnages;

import modele.equipements.Equipement;
import modele.equipements.armes.Arme;
import modele.equipements.protections.Protection;

import java.lang.reflect.Array;

public class PersoPrincipal {
    private Arme a;
    private Protection p;
    public String surnom;

    public PersoPrincipal(){
        this.a = null;
        this.p= null;
    }

    public PersoPrincipal(String surnom){
        new PersoPrincipal();
        this.surnom = surnom;
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
        else ia.setPdv(pdvAdvers);
    }
}
