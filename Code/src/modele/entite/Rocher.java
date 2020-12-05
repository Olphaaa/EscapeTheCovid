package modele.entite;

import modele.Position;

import javax.swing.text.html.ImageView;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Rocher extends Entite{


    public Rocher(){
        float randX= ThreadLocalRandom.current().nextInt(10,800+1);
        float randY= ThreadLocalRandom.current().nextInt(10,400+1);
        //System.out.println(randX + ","+randY);
        super.setP(new Position(randX,randY));
        // pour l'image aléatoire:


        super.setImage(this.setImageRand(this));
        //System.out.println(this.getImage());
        /*positionX = ... FAIRE LE RANDOM SELON LA TAILLE DE LA CARTE*/
        /*positionY = ... FAIRE LE RANDOM SELON LA TAILLE DE LA CARTE*/
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
