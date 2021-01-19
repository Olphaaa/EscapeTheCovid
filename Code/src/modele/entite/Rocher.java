package modele.entite;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import java.lang.Object;
import java.util.concurrent.ThreadLocalRandom;



public class Rocher extends Entite{
    /**
     * Classe fille d'entite
     * Elle permet d'afficher un rocher afin de créer un obstacle à notre personnage principal.
     */
    private Random rand = new Random();
    public Rocher(){
        float randX= rand.nextInt(900)+45;
        float randY= rand.nextInt(610)+45;
        this.setImage("/images/rocher/rock"+((int)(Math.random()*4)+1)+".png");
        this.setPosiPerso(randX,randY);
    }
}
