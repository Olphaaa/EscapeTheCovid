package modele.collisionneur;

import modele.Carte;
import modele.entite.Entite;
import modele.entite.personnages.PersoPrincipal;

import java.util.Iterator;

public class CollisionneurSimple extends Collisionneur {

    public CollisionneurSimple(Carte laCarte) {
        super(laCarte);
    }

    @Override
    public boolean canMove(double x, double y) {
//        System.out.println("["+x + "], ["+y+"]");
        if (x>24 && x<=getWidth()-84 && y>24 && y<=getHeight()-105 && isPresent(x,y))
            return true;
        return false;
    }


    @Override
    public boolean isPresent(double x, double y) {
        Iterator<Entite> it = laCarte.getLesEntites().iterator();
        while (it.hasNext()){
            Entite e = it.next();
            if (e instanceof PersoPrincipal)
                continue;
            if (x > e.getX()-40 && x < e.getX()+40 && y>e.getY()-40 && y<e.getY()+40)
                return false;
        }
        return true;
    }
}
