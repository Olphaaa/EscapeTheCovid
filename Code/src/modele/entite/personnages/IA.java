package modele.entite.personnages;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class IA extends Personnage{
    private boolean isInfect;
    Random rand = new Random();

    public IA(){
        isInfect = false;
        super.setImage("/images/perso/iaRien.png");

        float randX= rand.nextInt(920)+45;
        float randY= rand.nextInt(610)+45;
        this.setPPerso(randX, randY);

    }

    public void disparition(){
        /*PAS ENCORE FAIT*/
    }



    public void setInfect(boolean bool){
        isInfect = bool;
        super.setImage("/images/perso/iaMalade.png");
    }
}
