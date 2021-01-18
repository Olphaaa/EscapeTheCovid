package modele.entite.personnages;

import java.util.Random;


public class IA extends Personnage{
    private boolean isInfect;
    private double destX;
    private double destY;


    public boolean isInfect() {
        return isInfect;
    }

    Random rand = new Random();

    public IA(){
        if(rand.nextFloat()>0.5){
            isInfect = false;
            super.setImage("/images/perso/iaRien.png");
        }
        else{
            isInfect = true;
            super.setImage("/images/perso/iaMalade.png");
        }

        float randX= rand.nextInt(895 - 24)+24;
        float randY= rand.nextInt(605 - 24)+24;
        this.setPPerso(randX, randY);
        resetDest();
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
