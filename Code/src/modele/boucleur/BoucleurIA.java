package modele.boucleur;

import modele.Manager;

public class BoucleurIA extends Boucleur{

    @Override
    public void run() {

        while (super.actif){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                actif = false;
            }
        }
    }
}
