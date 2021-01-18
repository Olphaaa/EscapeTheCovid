package modele.entite.equipements.protections;

import modele.entite.equipements.Equipement;

public abstract class Protection extends Equipement {
    public int niveauProtection;
    public float tauxApparition;

    public Protection(){
        super.setIdEquipement(1);
    }
}
