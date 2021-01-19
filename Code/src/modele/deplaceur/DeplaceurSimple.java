package modele.deplaceur;

import modele.collisionneur.Collisionneur;
import modele.entite.Entite;
import modele.entite.personnages.PersoPrincipal;

/**
 * Classe fille du deplaceur
 * Elle permet de vérifier si le personnage n'est pas en collison et puis effectue le mouvement demandé.
 */
public class DeplaceurSimple extends Deplaceur {
    /**
     * Permet de définir le pas du déplacement
     * @param leCollisionneur le collisionneur
     */

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
    public void attaquer(PersoPrincipal perso) {
        if(leCollisionneur.isPresentAttaq(perso.getX(),perso.getY()) != null){
            perso.attaquer(leCollisionneur.isPresentAttaq(perso.getX(),perso.getY()));
        }
    }

    /**
     * Permet de deplacer le personnage en fonciton des état de up, down, right et left
     * @param up    the up
     * @param down  the down
     * @param right the right
     * @param left  the left
     * @param space the space
     * @param perso the perso
     */
    @Override
    public void deplacerPersonnage(boolean up, boolean down, boolean right, boolean left, boolean space, PersoPrincipal perso) {
        if (up){deplacerHaut(perso);}
        if (down){deplacerBas(perso);}
        if (left){deplacerGauche(perso);}
        if (right){deplacerDroit(perso);}
        if (space){attaquer(perso);}
    }
}
