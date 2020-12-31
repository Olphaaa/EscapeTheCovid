package modele.collisionneur;

import modele.Carte;
import modele.Manager;
import modele.entite.Entite;
import modele.entite.Rocher;
import modele.entite.equipements.Equipement;
import modele.entite.equipements.protections.Protection;
import modele.entite.personnages.IA;
import modele.entite.personnages.PersoPrincipal;

import java.util.Iterator;

public class CollisionneurIA extends Collisionneur{
    public CollisionneurIA(Carte laCarte, Manager m) {
        super(laCarte, m);
    }

    @Override
    public boolean canMove(double x, double y) {
        if (isPresent(x,y)){
            return true;
        }
        return false;
    }

    @Override
    public boolean isPresent(double x, double y) {
        Iterator<Entite> it = laCarte.getLesEntites().iterator();
        while (it.hasNext()){
            Entite e = it.next();
            if (e instanceof Rocher)
                if (x > e.getX()-40 && x < e.getX()+40 && y>e.getY()-40 && y<e.getY()+40)
                    return  false;
        }
        return true;
    }
}
