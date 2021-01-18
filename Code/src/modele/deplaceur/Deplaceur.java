package modele.deplaceur;

import modele.collisionneur.Collisionneur;
import modele.entite.Entite;
import modele.entite.personnages.PersoPrincipal;


public abstract class Deplaceur {

    protected int pas;
    protected Collisionneur leCollisionneur;

    public Deplaceur(Collisionneur leCollisionneur){
        this.leCollisionneur = leCollisionneur;
    }

    public abstract void deplacerHaut(Entite e);
    public abstract void deplacerBas(Entite e);
    public abstract void deplacerGauche(Entite e);
    public abstract void deplacerDroit(Entite e);
    public abstract void deplacerIA();
    public abstract void deplacerPersonnage(boolean up, boolean down, boolean right, boolean left, boolean space, PersoPrincipal perso);

    public abstract void attaquer(PersoPrincipal perso);
}
