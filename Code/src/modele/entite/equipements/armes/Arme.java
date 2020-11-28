package modele.entite.equipements.armes;

import modele.entite.equipements.Equipement;

public class Arme extends Equipement {
    private final int ptsDegat;

    public Arme(int ptsDegat){
        super.setIdEquipement(2);
        this.ptsDegat=ptsDegat;
    }

    public int getPdd(){
        return this.ptsDegat;
    }
}
