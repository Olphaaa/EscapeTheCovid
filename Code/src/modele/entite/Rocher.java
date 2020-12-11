package modele.entite;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modele.Position;
import modele.entite.personnages.PersoPrincipal;

import java.io.InputStream;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Rocher extends Entite{


    public Rocher(){
        float randX= ThreadLocalRandom.current().nextInt(45,1000-80);
        float randY= ThreadLocalRandom.current().nextInt(45,710-100);
        super.setImage(this.setImageRand(this));

        Class<?> cl = this.getClass();
        InputStream is = cl.getResourceAsStream(getImage());
        Image im = new Image(is,50,50,true,true);
        this.setImView(new ImageView(im));

        this.setPPerso(new Position(randX,randY));
    }

    private String setImageRand(Rocher r){
        int rand = (int)(Math.random()*(5-1))+1;
        switch (rand){
            case 1:
                r.setImage("rocher1");
                break;
            case 2:
                r.setImage("rocher2");
                break;
            case 3:
                r.setImage("rocher3");
                break;
            case 4:
                r.setImage("rocher4");
                break;
        }
        return r.getImage();
    }


}
