package modele.collisionneur;

import modele.Carte;
import modele.Manager;
import modele.entite.Entite;
import modele.entite.Rocher;
import modele.entite.personnages.IA;

public class CollisionneurIA extends Collisionneur{
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

    public void contaminerAuContacte(Entite entite){
        Iterator<Entite> it = laCarte.getLesEntites().iterator();
        while (it.hasNext()){
            Entite e = it.next();
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

    @Override
    public IA isPresentAttaq(double x, double y) {
        return null;
    }
}
