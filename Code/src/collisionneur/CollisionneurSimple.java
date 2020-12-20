package collisionneur;

import modele.entite.Entite;

public class CollisionneurSimple extends Collisionneur {

    @Override
    public boolean canMove(double x, double y) {
        return x>24 && x<=getWidth()-84 && y>24 && y<=getHeight()-105;
    }

    @Override
    public Entite isPresent(double x, double y) {
        return null;
    }
}
