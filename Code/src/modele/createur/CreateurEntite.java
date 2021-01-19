package modele.createur;

import modele.Carte;
import modele.entite.personnages.PersoPrincipal;


/**
 * Classe Createur entite.
 * Elle permet de crer des entite sans écrire à chaque fois la ligne, juste en appelant une fonction.
 */

public abstract class CreateurEntite {

    /**
     * Creer perso principal perso principal.
     *
     * @param carte the carte
     * @return the perso principal
     */
    public abstract PersoPrincipal creerPersoPrincipal(Carte carte);

    /**
     * Creer ia.
     *
     * @param carte the carte
     */
    public abstract void creerIA(Carte carte);

    /**
     * Creer rocher.
     *
     * @param carte the carte
     */
    public abstract void creerRocher(Carte carte);

    /**
     * Creer combinaison.
     *
     * @param carte the carte
     */
    public abstract void creerCombinaison(Carte carte);

    /**
     * Creer masque.
     *
     * @param carte the carte
     */
    public abstract void creerMasque(Carte carte);

    /**
     * Creer visiere.
     *
     * @param carte the carte
     */
    public abstract void creerVisiere(Carte carte);

}
