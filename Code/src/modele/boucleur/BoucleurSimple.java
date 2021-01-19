package modele.boucleur;

public class BoucleurSimple extends Boucleur{
    /**
     * Classe fille du Boucleur
     * Elle permet de faire avancer le temps écoulé de la partie ainsi que de faire spawn à interval régulier
     * des IA.
     */
    @Override
    public void run() {

        while (super.actif){
            timeBeep();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                actif = false;
            }
        }
    }
}
