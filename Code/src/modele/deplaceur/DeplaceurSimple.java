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
            e.setPPerso(e.getX(), e.getY()-pas);
        }
    }


    public void deplacerBas(Entite e){
        if (leCollisionneur.canMove(e.getX(), e.getY()+pas)){
            e.setPPerso(e.getX(), e.getY()+pas);
        }
    }

    public void deplacerGauche(Entite e){
        if (leCollisionneur.canMove(e.getX()-pas, e.getY())){
            e.setPPerso(e.getX()-pas, e.getY());
        }

    }
    public void deplacerDroit(Entite e){
        if (leCollisionneur.canMove(e.getX()+pas, e.getY())){
            e.setPPerso(e.getX()+pas, e.getY());
        }
    }

    @Override
    public void attaquer(PersoPrincipal perso) {
        if(leCollisionneur.isPresentAttaq(perso.getX(),perso.getY()) != null){
            perso.attaquer(leCollisionneur.isPresentAttaq(perso.getX(),perso.getY()));
        }
    }
}
