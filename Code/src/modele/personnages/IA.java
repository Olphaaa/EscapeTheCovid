package modele.personnages;

import java.util.Random;

public class IA extends Personnage{
    private int idIa;
    private boolean isInfect;

    public IA(){
        Random r = new Random();
        idIa = r.nextInt(25); //PENSER À CHERCHER SI IL EXISTE DEJÀ DANS UNE COLLECTION
        isInfect = false;
    }
    public void setPdv(int pdv){
        this.pointsDeVie = pdv;
    }
    public void disparition(){
        /*PAS ENCORE FAIT*/
    }

    public void iaToucher(IA ia){
        ia.setInfect(true);
    }

    public void setInfect(boolean bool){
        isInfect = bool;
    }
}
