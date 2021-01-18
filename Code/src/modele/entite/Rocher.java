package modele.entite;

import java.util.Random;



public class Rocher extends Entite{
    Random rand = new Random();

    public Rocher(){
        float randX= rand.nextInt(900)+45;
        float randY= rand.nextInt(610)+45;
        this.setImage("/images/rocher/rock"+((int)(Math.random()*4)+1)+".png");
        this.setPPerso(randX,randY);
    }
}
