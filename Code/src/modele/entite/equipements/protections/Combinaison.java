package modele.entite.equipements.protections;
import java.util.concurrent.ThreadLocalRandom;

public class Combinaison extends Protection{

    /**
     * Classe fille de Protection
     * Elle créer une protection de type Combinaison de niveau 4;
     */

    public Combinaison(){
        this.niveauProtection = 4;
        this.tauxApparition = (float) 0.10;

        float randX= ThreadLocalRandom.current().nextInt(45,1000-80);
        float randY= ThreadLocalRandom.current().nextInt(45,710-100);
        super.setImage("/images/protection/combinaison.png");

        this.setPosiPerso(randX,randY);
    }

    @Override
    public String getNom() {
        return "Combinaison";
    }
}
