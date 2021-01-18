package modele.deplaceur;

import modele.collisionneur.Collisionneur;
import modele.entite.Entite;
import modele.entite.personnages.PersoPrincipal;
import modele.ramasseur.Ramasseur;

public class DeplaceurSimple extends Deplaceur {

    public DeplaceurSimple(Collisionneur leCollisionneur, Ramasseur leRamasseur){
        super(leCollisionneur, leRamasseur);
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
    public void attaquer(PersoPrincipal perso) {
        if(leCollisionneur.isPresentAttaq(perso.getX(),perso.getY()) != null){
            perso.attaquer(leCollisionneur.isPresentAttaq(perso.getX(),perso.getY()));
        }
    }
}
