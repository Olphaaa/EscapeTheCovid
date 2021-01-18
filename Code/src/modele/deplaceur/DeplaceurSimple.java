package modele.deplaceur;

import modele.collisionneur.Collisionneur;
import modele.entite.Entite;
import modele.entite.personnages.PersoPrincipal;

public class DeplaceurSimple extends Deplaceur {

    public DeplaceurSimple(Collisionneur leCollisionneur){
        super(leCollisionneur);
        pas=7;
    }

    public void deplacerHaut(Entite e){
        if (leCollisionneur.canMove(e.getX(), e.getY()-pas)){
            e.setPosiPerso(e.getX(), e.getY()-pas);
        }
    }


    public void deplacerBas(Entite e){
        if (leCollisionneur.canMove(e.getX(), e.getY()+pas)){
            e.setPosiPerso(e.getX(), e.getY()+pas);
        }
    }

    public void deplacerGauche(Entite e){
        if (leCollisionneur.canMove(e.getX()-pas, e.getY())){
            e.setPosiPerso(e.getX()-pas, e.getY());
        }

    }
    public void deplacerDroit(Entite e){
        if (leCollisionneur.canMove(e.getX()+pas, e.getY())){
            e.setPosiPerso(e.getX()+pas, e.getY());
        }
    }

    @Override
    public void deplacerIA() {
        return;
    }

    @Override
    public void deplacerPersonnage(boolean up, boolean down, boolean right, boolean left, boolean space, PersoPrincipal perso) {
        if (up){deplacerHaut(perso);}
        if (down){deplacerBas(perso);}
        if (left){deplacerGauche(perso);}
        if (right){deplacerDroit(perso);}
        if (space){attaquer(perso);}
    }

    @Override
    public void attaquer(PersoPrincipal perso) {
        if(leCollisionneur.isPresentAttaq(perso.getX(),perso.getY()) != null){
            perso.attaquer(leCollisionneur.isPresentAttaq(perso.getX(),perso.getY()));
        }
    }
}
