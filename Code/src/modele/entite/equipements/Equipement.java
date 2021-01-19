package modele.entite.equipements;

import modele.entite.Entite;

/**
 * Classe Equipement.
 * Elle permet un premier point d'extension pour pouvoir créer plusieur type d'équipement
 * tel que les Protections ou bien les Armes même si celle ci ne sont pas encore implentées.
 */
public abstract class Equipement extends Entite {

    private int idEquipement;

    /**
     * Sets id equipement.
     *
     * @param idEquipement the id equipement
     */
    public void setIdEquipement(int idEquipement) {
        this.idEquipement = idEquipement;
    }

    /**
     * Gets nom.
     *
     * @return the nom
     */
    public abstract String getNom();
}
