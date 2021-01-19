package modele.entite.equipements.protections;

import modele.entite.equipements.Equipement;

/**
 * Classe Protection.
 * Elle permet de faire un point d'extension pour créer plusieurs protections.
 */

public abstract class Protection extends Equipement {
    
    /**
     * Le Niveau de protection.
     */
    public int niveauProtection;
    public float tauxApparition;


    public Protection(){
        super.setIdEquipement(1);
    }
}
