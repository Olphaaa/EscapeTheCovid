package modele.deplaceur;

import modele.collisionneur.Collisionneur;
import modele.entite.Entite;
import modele.entite.personnages.PersoPrincipal;


/**
 * Classe Deplaceur.
 * Elle permet de faire bouger notre personnage sur la map tout en contrôlant s'il n'est pas en collision avec un rocher.
 */
public abstract class Deplaceur {

    /**
     * Vitesse de déplacement du joueur.
     */
    protected int pas;
    /**
     * The Le collisionneur.
     */
    protected Collisionneur leCollisionneur;

    /**
     * Instantiates a new Deplaceur.
     *
     * @param leCollisionneur  le collisionneur
     */
    public Deplaceur(Collisionneur leCollisionneur){
        this.leCollisionneur = leCollisionneur;
    }

    /**
     * Deplacer haut.
     *
     * @param e the e
     */
    public abstract void deplacerHaut(Entite e);

    /**
     * Deplacer bas.
     *
     * @param e the e
     */
    public abstract void deplacerBas(Entite e);

    /**
     * Deplacer gauche.
     *
     * @param e the e
     */
    public abstract void deplacerGauche(Entite e);

    /**
     * Deplacer droit.
     *
     * @param e the e
     */
    public abstract void deplacerDroit(Entite e);

    /**
     * Deplacer ia.
     */
    public abstract void deplacerIA();

    /**
     * Deplacer personnage.
     *
     * @param up    the up
     * @param down  the down
     * @param right the right
     * @param left  the left
     * @param space the space
     * @param perso the perso
     */
    public abstract void deplacerPersonnage(boolean up, boolean down, boolean right, boolean left, boolean space, PersoPrincipal perso);

    /**
     * Attaquer.
     *
     * @param perso the perso
     */
    public abstract void attaquer(PersoPrincipal perso);
}
