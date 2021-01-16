package modele.entite.personnages;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class IA extends Personnage implements Observable {
    private boolean isInfect;
    private double destX;
    private double destY;

    private List<InvalidationListener> lesObservateurIA = new ArrayList<>();


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
        lesObservateurIA.forEach(o -> Platform.runLater(() -> o.invalidated(this)));

    }

    public void addListener(InvalidationListener invalidationListener) {
        lesObservateurIA.add(invalidationListener);
    }

    public void removeListener(InvalidationListener invalidationListener) {
        lesObservateurIA.remove(invalidationListener);
    }
}
