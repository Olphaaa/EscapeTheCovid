package modele.deplaceur;

import modele.collisionneur.Collisionneur;
import modele.entite.Entite;
import modele.ramasseur.Ramasseur;

public class DeplaceurSimple extends Deplaceur {

    public DeplaceurSimple(Collisionneur leCollisionneur, Ramasseur leRamasseur){
        super(leCollisionneur, leRamasseur);
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
}
