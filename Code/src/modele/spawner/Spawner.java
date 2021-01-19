package modele.spawner;

import modele.Carte;
import modele.createur.CreateurSimple;

/**
 * Spawner.
 * Classe mère abstraite qui permet de définir les méthodes de se(s) fille(s)
 */
public abstract class Spawner {
    /**
     * Fait spawn une protection
     *
     * @param cs    Createur Simple
     * @param carte la Carte
     */
    public abstract void spawnProtection(CreateurSimple cs, Carte carte);

    /**
     * Fait spawn plusieurs rochers
     *
     * @param cs         the cs
     * @param carte      the carte
     * @param difficulte the difficulte
     */
    public abstract void spawnRocher(CreateurSimple cs, Carte carte, int difficulte);
}
