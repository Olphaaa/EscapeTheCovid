package modele.entite.equipements;

import modele.entite.Entite;

public abstract class Equipement extends Entite {
    private int idEquipement;

    public void setIdEquipement(int idEquipement) {
        this.idEquipement = idEquipement;
    }

    public abstract String getNom();
}
