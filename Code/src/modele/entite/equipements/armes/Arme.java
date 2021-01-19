package modele.entite.equipements.armes;
import modele.entite.equipements.Equipement;

/**
 * Permet d'attaquer une IA
 */
public abstract class Arme extends Equipement {
    private final int ptsDegat;

    /**
     * Points d'extension pour ajouter des armes par la suite.
     *
     * @param ptsDegat
     */

    public Arme(int ptsDegat){
        super.setIdEquipement(2);
        this.ptsDegat=ptsDegat;
    }

    public int getPdd(){
        return this.ptsDegat;
    }

    @Override
    public String getNom() {
        return "Arme";
    }
}
