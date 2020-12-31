package modele.deplaceur;

import modele.collisionneur.Collisionneur;
import modele.entite.Entite;
import modele.entite.personnages.IA;
import modele.ramasseur.Ramasseur;

public class DeplaceurIA extends Deplaceur{

    public DeplaceurIA(Collisionneur leCollisionneur, Ramasseur leRamasseur){//todo voir s'il faut quand meme le ramasseur
        super(leCollisionneur, leRamasseur);
        pas = 10;
    }

    public void deplacerHaut(Entite e){
        if (leCollisionneur.canMove(e.getX(), e.getY()-pas)){
            e.setPPerso(e.getX(), e.getY()-pas);
        }
        else
            ((IA) e).resetDest();

    }

    public void deplacerBas(Entite e){
        if (leCollisionneur.canMove(e.getX(), e.getY()+pas)){
            e.setPPerso(e.getX(), e.getY()+pas);
        }else
            ((IA) e).resetDest();
    }

    public void deplacerGauche(Entite e){
        if (leCollisionneur.canMove(e.getX()-pas, e.getY())){
            e.setPPerso(e.getX()-pas, e.getY());
        }else
            ((IA) e).resetDest();
    }

    public void deplacerDroit(Entite e){
        if (leCollisionneur.canMove(e.getX()+pas, e.getY())){
            e.setPPerso(e.getX()+pas, e.getY());
        }else
            ((IA) e).resetDest();
    }
}
