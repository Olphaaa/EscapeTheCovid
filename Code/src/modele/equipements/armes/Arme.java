package modele.equipements.armes;

import modele.equipements.Equipement;

public class Arme extends Equipement {
    private final int ptsDegat;

    public Arme(int ptsDegat){
        this.ptsDegat=ptsDegat;
    }

    public int getPdd(){
        return this.ptsDegat;
    }
}
