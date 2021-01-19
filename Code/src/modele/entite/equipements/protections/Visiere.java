package modele.entite.equipements.protections;

import java.util.concurrent.ThreadLocalRandom;
/**
 * Classe fille de Protection
 * Elle créer une protection de type Visiere de niveau 2;
 */
public class Visiere extends Protection {



    public Visiere(){
        this.niveauProtection = 2;
        this.tauxApparition = (float) 0.30;

        float randX= ThreadLocalRandom.current().nextInt(45,1000-80);
        float randY= ThreadLocalRandom.current().nextInt(45,710-100);
        super.setImage("/images/protection/visiere.png");

        this.setPosiPerso(randX,randY);
    }

    @Override
    public String getNom() {
        return "Visiere";
    }
}
