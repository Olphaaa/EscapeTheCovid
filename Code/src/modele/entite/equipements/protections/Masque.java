package modele.entite.equipements.protections;
import java.util.concurrent.ThreadLocalRandom;

public class Masque extends Protection {

    public Masque(){
        this.niveauProtection = 1;
        this.tauxApparition = (float) 0.60;

        float randX= ThreadLocalRandom.current().nextInt(45,1000-80);
        float randY= ThreadLocalRandom.current().nextInt(45,710-100);
        super.setImage("/images/protection/masquep.png");

        this.setPPerso(randX,randY);
    }

    @Override
    public String getNom() {
        return "Masque";
    }
}
