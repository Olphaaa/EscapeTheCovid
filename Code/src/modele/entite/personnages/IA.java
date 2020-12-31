package modele.entite.personnages;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class IA extends Personnage{
    private boolean isInfect;

    private double destX;
    private double destY;

    public boolean isInfect() {
        return isInfect;
    }

    Random rand = new Random();

    public IA(){
        isInfect = false;
        super.setImage("/images/perso/iaRien.png");
        float randX= rand.nextInt(895 - 24)+24;
        float randY= rand.nextInt(605 - 24)+24;
        this.setPPerso(randX, randY);
        resetDest();
    }

    public void disparition(){
        /*PAS ENCORE FAIT*/
    }

    public void resetDest(){
        destX = rand.nextInt(895 - 24)+24;
        destY = rand.nextInt(605 - 24)+24;
    }
    public double getDestX(){
        return destX;
    }
    public double getDestY(){
        return destY;
    }

    public void setInfect(boolean bool){
        isInfect = bool;
        super.setImage("/images/perso/iaMalade.png");
    }
}
