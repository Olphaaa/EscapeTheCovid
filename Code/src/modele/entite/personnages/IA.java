package modele.entite.personnages;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modele.Position;

import java.io.InputStream;
import java.util.concurrent.ThreadLocalRandom;


public class IA extends Personnage{
    private boolean isInfect;

    public IA(){
        isInfect = false;
        super.setImage("iaRien");

        float randX= ThreadLocalRandom.current().nextInt(45,1000-80);
        float randY= ThreadLocalRandom.current().nextInt(45,710-100);

        Class<?> cl = this.getClass();
        InputStream is = cl.getResourceAsStream(getImage());
        Image im = new Image(is,50,50,true,true);
        this.setImView(new ImageView(im));

        this.setPPerso(new Position(randX, randY));

    }

    public void disparition(){
        /*PAS ENCORE FAIT*/
    }



    public void setInfect(boolean bool){
        isInfect = bool;
        super.setImage("iaMalade");
        Class<?> cl = this.getClass();
        InputStream is = cl.getResourceAsStream(getImage());
        Image im = new Image(is,50,50,true,true);
        this.setImView(new ImageView(im));
    }
}
