package modele.entite.equipements.protections;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modele.Position;

import java.io.InputStream;
import java.util.concurrent.ThreadLocalRandom;

public class Combinaison extends Protection{

    public Combinaison(){
        this.niveauProtection = 4;
        this.tauxApparition = (float) 0.10;

        float randX= ThreadLocalRandom.current().nextInt(45,1000-80);
        float randY= ThreadLocalRandom.current().nextInt(45,710-100);
        super.setImage("combinaison");

        Class<?> cl = this.getClass();
        InputStream is = cl.getResourceAsStream(getImage());
        Image im = new Image(is,50,50,true,true);
        this.setImView(new ImageView(im));

        this.setPPerso(new Position(randX,randY));
    }
}
