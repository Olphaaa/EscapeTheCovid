package modele.entite;

import java.util.concurrent.ThreadLocalRandom;

public class Rocher extends Entite{


    public Rocher(){
        float randX= ThreadLocalRandom.current().nextInt(45,1000-80);
        float randY= ThreadLocalRandom.current().nextInt(45,710-100);
        super.setImage(this.setImageRand(this));
        this.setPPerso(randX,randY);
    }

    private String setImageRand(Rocher r){
        int rand = (int)(Math.random()*(5-1))+1;
        switch (rand){
            case 1:
                r.setImage("rocher1.png");
                break;
            case 2:
                r.setImage("rocher2.png");
                break;
            case 3:
                r.setImage("rocher3.png");
                break;
            case 4:
                r.setImage("rocher4.png");
                break;
        }
        return null;
    }


}
