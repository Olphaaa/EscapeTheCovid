package modele.deplaceur;

import modele.collisionneur.CollisionneurIA;
import modele.entite.Entite;
import modele.entite.personnages.IA;
import modele.entite.personnages.PersoPrincipal;

public class DeplaceurIA extends Deplaceur{

    public DeplaceurIA(CollisionneurIA leCollisionneur){//todo voir s'il faut quand meme le ramasseur
        super(leCollisionneur);
        pas = 10;
    }

    public void deplacerHaut(Entite e){
        if (leCollisionneur.canMove(e.getX(), e.getY()-pas)){
            e.setPPerso(e.getX(), e.getY()-pas);
            ((CollisionneurIA)leCollisionneur).contaminerAuContacte(e);
        }
        else
            ((IA) e).resetDest();

    }

    public void deplacerBas(Entite e){
        if (leCollisionneur.canMove(e.getX(), e.getY()+pas)){
            e.setPPerso(e.getX(), e.getY()+pas);
            ((CollisionneurIA)leCollisionneur).contaminerAuContacte(e);
        }else
            ((IA) e).resetDest();
    }

    public void deplacerGauche(Entite e){
        if (leCollisionneur.canMove(e.getX()-pas, e.getY())){
            e.setPPerso(e.getX()-pas, e.getY());
            ((CollisionneurIA)leCollisionneur).contaminerAuContacte(e);
        }else
            ((IA) e).resetDest();
    }

    public void deplacerDroit(Entite e){
        if (leCollisionneur.canMove(e.getX()+pas, e.getY())){
            e.setPPerso(e.getX()+pas, e.getY());
            ((CollisionneurIA)leCollisionneur).contaminerAuContacte(e);
        }else
            ((IA) e).resetDest();
    }

    @Override
    public void attaquer(PersoPrincipal perso) {

    }
}
