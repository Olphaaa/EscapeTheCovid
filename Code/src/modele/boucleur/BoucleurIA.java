package modele.boucleur;

import modele.Manager;

public class BoucleurIA extends Boucleur{
    //Manager m = new Manager();
    @Override
    public void run() {

        while (super.actif){
            //m.deplacementDesIa();
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                actif = false;
            }
        }
    }
}
