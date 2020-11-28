package modele.entite.personnages;

public class IA extends Personnage{
    private boolean isInfect;

    public IA(){
        isInfect = false;
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
