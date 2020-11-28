package modele.entite.equipements.protections;

import modele.entite.equipements.Equipement;

public abstract class Protection extends Equipement {
    public int niveauProtection;// a definir
    public float tauxApparition;// a definir

    public Protection(){
        super.setIdEquipement(1);
    }
}
