package modele.boucleur;

public class BoucleurSimple extends Boucleur{
    @Override
    public void run() {
        while (actif){
            timeBeep();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                actif = false;
            }
        }
    }
}
