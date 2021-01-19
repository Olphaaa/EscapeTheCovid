package modele.boucleur;

public class BoucleurIA extends Boucleur{

    /**
     * Classe fille du boucleur dédié à nos IA
     * Elle permet de faire bouger nos IA tous les 1/4 de seconde.
     */
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
