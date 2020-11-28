package modele.entite.equipements;

import modele.entite.Entite;

import java.awt.*;// import pour les images (a voir)

public abstract class Equipement extends Entite {
    private int idEquipement;

    public void setIdEquipement(int idEquipement) {
        this.idEquipement = idEquipement;
    }
}
