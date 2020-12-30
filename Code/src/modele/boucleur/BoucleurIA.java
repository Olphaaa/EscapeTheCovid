package modele.boucleur;

public class BoucleurIA extends Boucleur{
    @Override
    public void run() {

        while (super.actif){
            timeBeep();
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                actif = false;
            }
        }
    }
}
