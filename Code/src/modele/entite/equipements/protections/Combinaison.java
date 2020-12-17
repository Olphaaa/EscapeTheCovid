package modele.entite.equipements.protections;
import java.util.concurrent.ThreadLocalRandom;

public class Combinaison extends Protection{

    public Combinaison(){
        this.niveauProtection = 4;
        this.tauxApparition = (float) 0.10;

        float randX= ThreadLocalRandom.current().nextInt(45,1000-80);
        float randY= ThreadLocalRandom.current().nextInt(45,710-100);
        super.setImage("combinaison.png");

        this.setPPerso(randX,randY);
    }
}
