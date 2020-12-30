package modele.entite.equipements.protections;

import java.util.concurrent.ThreadLocalRandom;

public class Visiere extends Protection {

    public Visiere(){
        this.niveauProtection = 2;
        this.tauxApparition = (float) 0.30;

        float randX= ThreadLocalRandom.current().nextInt(45,1000-80);
        float randY= ThreadLocalRandom.current().nextInt(45,710-100);
        super.setImage("/images/protection/visiere.png");

        this.setPPerso(randX,randY);
    }

    @Override
    public String getNom() {
        return "Visiere";
    }
}
