package modele.collisionneur;

import modele.Carte;
import modele.Manager;
import modele.entite.Entite;
import modele.entite.Rocher;
import modele.entite.personnages.IA;
import modele.entite.personnages.PersoPrincipal;

/**
 * Classe Collisionneur ia.
 */

public class CollisionneurIA extends Collisionneur{

    /**
     * Classe fille du collisionneur pour nos IA qui nous permet de savoir lorsque l'on touche une IA
     * ou qu'elle se touche elle même.
     *
     * @param laCarte  la carte
     * @param m
     */
    public CollisionneurIA(Carte laCarte, Manager m) {
        super(laCarte, m);
    }

    @Override
    public boolean canMove(double x, double y) {
        return isPresent(x, y);
    }

    @Override
    public boolean isPresent(double x, double y) {
        for (Entite e : laCarte.getLesEntites()) {
            if (e instanceof Rocher)
                if (x > e.getX() - 40 && x < e.getX() + 40 && y > e.getY() - 40 && y < e.getY() + 40)
                    return false;
        }
        return true;
    }

    @Override
    public IA isPresentAttaq(double x, double y) {
        return null;
    }

    /**
     * Contaminer au contacte.
     *
     * @param entite  entite
     */
    public void contaminerAuContacte(Entite entite){
        for(Entite e: laCarte.getLesEntites()){
            if (entite.getX() > e.getX()-40 && entite.getX() < e.getX()+40 && entite.getY()>e.getY()-40 && entite.getY()<e.getY()+40){
                if (e instanceof IA && !entite.equals(e) && !((IA)entite).isInfect()){
                    if (((IA) e).isInfect()){
                        ((IA) entite).setInfect(true);//todo l'image ne se met pas a jour au contacte (mais le chemin chamge)
                    }
                }
                if (e instanceof PersoPrincipal){
                    PersoPrincipal pp = super.leManager.getPerso();
                    pp.seFaireToucher();
                    pp.setX(45);
                    pp.setY(375);
                }
            }

        }
    }

}
