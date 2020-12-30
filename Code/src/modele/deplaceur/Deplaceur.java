package modele.deplaceur;

import modele.collisionneur.Collisionneur;
import modele.entite.Entite;
import modele.ramasseur.Ramasseur;


public abstract class Deplaceur {

    protected int pas;
    protected Collisionneur leCollisionneur;
    protected Ramasseur leRamasseur;

    public Deplaceur(Collisionneur leCollisionneur, Ramasseur leRamasseur){
        this.leCollisionneur = leCollisionneur;
    }

    public abstract void deplacerHaut(Entite e);
    public abstract void deplacerBas(Entite e);
    public abstract void deplacerGauche(Entite e);
    public abstract void deplacerDroit(Entite e);
}
