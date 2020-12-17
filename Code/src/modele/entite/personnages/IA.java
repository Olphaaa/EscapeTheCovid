package modele.entite.personnages;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.concurrent.ThreadLocalRandom;


public class IA extends Personnage{
    private boolean isInfect;

    public IA(){
        isInfect = false;
        super.setImage("iaRien.png");

        float randX= ThreadLocalRandom.current().nextInt(45,1000-80);
        float randY= ThreadLocalRandom.current().nextInt(45,710-100);
        this.setPPerso(randX, randY);

    }

    public void disparition(){
        /*PAS ENCORE FAIT*/
    }



    public void setInfect(boolean bool){
        isInfect = bool;
        super.setImage("iaMalade.png");

    }
}
