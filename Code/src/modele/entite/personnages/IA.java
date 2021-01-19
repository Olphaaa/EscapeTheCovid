package modele.entite.personnages;

import java.util.Random;

/**
 * Classe fille de Personnage
 * Elle permet de gérer l'infection d'une ia ainsi que sont niveaux de vie et sa zone de spawn.
 * Une ia peut être infectée dès son apparition ou bien après contact avec une ia infectée.
 */
public class IA extends Personnage{

    private boolean isInfect;
    private double destX;
    private double destY;
    private Random rand = new Random();


    /**
     * Permet de créer une IA avec 50% de chance qu'elle soit infectée au départ
     * et une position aléatoire
     */
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
        this.setPosiPerso(randX, randY);
        resetDest();
    }

    /**
     * Savoir si un IA est infectée
     * @return true si elle est infectée
     */
    public boolean isInfect() {
        return isInfect;
    }

    /**
     * Reinitialise la position à laquel l'ia doit allers
     */
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

    /**
     * Permet de changer l'état de infection
     * @param bool true s'il est infecté false sinon
     */
    public void setInfect(boolean bool){
        isInfect = bool;
        super.setImage("/images/perso/iaMalade.png");
    }

}
